package edu.cs2335.lab5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.TransferHandler;
import javax.swing.plaf.basic.BasicGraphicsUtils;


/**
 * This code was generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * *************************************
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
 * for this machine, so Jigloo or this code cannot be used legally
 * for any corporate or commercial purpose.
 * *************************************
 */
public class LocalPhoto extends JPanel {
    
    private static final int PADDING = 4;
    
    private File photoFile;
    private BufferedImage originalPhoto;
    private BufferedImage scaledPhoto;
    private boolean successful = false;
    private boolean focus = false;
    
    /**
     * Auto-generated main method to display this
     * JPanel inside a new JFrame.
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.getContentPane().add(new LocalPhoto("/net/hu11/mgbowman/images/fireandice.jpg"));
        frame.pack();
        frame.show();
    }
    
    public LocalPhoto(String photoPath) {
        super();
        
        setBackground(Color.WHITE);
        photoFile = new File(photoPath);
        // mgb: get buffered image
        originalPhoto = PhotoEngine.createOriginalBufferedImage(photoFile);
        // mgb: get scaled buffered image
        scaledPhoto = PhotoEngine.createScaledBufferedImage(originalPhoto);
        
        try {
            // mgb: set component sizes
            Dimension scale = new Dimension(scaledPhoto.getWidth()+(2*PADDING),
            scaledPhoto.getHeight()+(2*PADDING));
            setMaximumSize(scale);
            setMinimumSize(scale);
            setPreferredSize(scale);
        } catch (NullPointerException e) {
            return;
        }
        
        addMouseListener(new FocusMouseAdapter());
        addMouseMotionListener(new DragMouseAdapter());
        setTransferHandler(new LocalPhotoTransferHandler());
        successful = true;
    }
    
    /**
     * @return Returns the successful.
     */
    public boolean isSuccessful() {
        return successful;
    }
    
    /**
     * @see java.awt.Component
     */
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        if(focus) {
            BasicGraphicsUtils.drawLoweredBezel(g2d, 0, 0, scaledPhoto.getWidth()+(2*PADDING)-1,
            scaledPhoto.getHeight()+(2*PADDING)-1,
            Color.DARK_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.BLACK);
        } else {
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0,0, scaledPhoto.getWidth()+(2*PADDING),
            scaledPhoto.getHeight()+(2*PADDING));
        }
        g2d.drawImage(scaledPhoto, PADDING, PADDING, null);
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return photoFile.toString();
    }
    
    private class FocusMouseAdapter extends MouseAdapter {
        
        /* (non-Javadoc)
         * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
         */
        public void mouseEntered(MouseEvent e) {
            e.consume();
            
            // mgb: check to see if pane is being resized
            int button1Mask = MouseEvent.BUTTON1_DOWN_MASK;
            int button2Mask = MouseEvent.BUTTON2_DOWN_MASK;
            int button3Mask = MouseEvent.BUTTON3_DOWN_MASK;
            int modifiers = e.getModifiersEx();
            
            if (((modifiers & button1Mask) != button1Mask) &&
            ((modifiers & button2Mask) != button2Mask) &&
            ((modifiers & button3Mask) != button3Mask)){
                focus = true;
                paint(getGraphics());
            }
        }
        
        public void mouseExited(MouseEvent e) {
            if(focus) {
                e.consume();
                focus = false;
                paint(getGraphics());
            }
        }
    }
    
    private class DragMouseAdapter extends MouseMotionAdapter {
        
        public void mouseDragged(MouseEvent e) {
            e.consume();
            focus = false;
            paint(getGraphics());
            
            // mgb: dragging...
            JComponent c = (JComponent)e.getSource();
            TransferHandler handler = c.getTransferHandler();
            handler.exportAsDrag(c, e, TransferHandler.COPY);
        }
    }
    
}
