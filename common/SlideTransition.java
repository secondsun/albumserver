//Source file: /net/hu11/mgbowman/cs2335/lab5/src/edu/cs2335/lab5/common/SlideTransition.java

package edu.cs2335.lab5.common;



import edu.cs2335.lab5.PhotoEngine;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;





public class SlideTransition extends Transition {
    private int direction;
    
    
    public SlideTransition(int inDirection) {
        direction=inDirection;
    }
    
    /**
     * @param firstGraphic
     */
    
    
    
    public void transform(Photo buffPhoto, Color color1,Photo nextPhoto,Color color2,Frame mainFrame){
        GraphicsConfiguration gc=mainFrame.getGraphicsConfiguration();
        int width=mainFrame.getWidth();
        int height=mainFrame.getHeight();
        
        BufferedImage buff=PhotoEngine.createOriginalBufferedImage(new File(buffPhoto.getFileName()),gc);
        buff=PhotoEngine.createScaledBufferedImage(buff,width,height,gc);
        
        BufferedImage next=PhotoEngine.createOriginalBufferedImage(new File(nextPhoto.getFileName()),gc);
        next=PhotoEngine.createScaledBufferedImage(next,width,height,gc);
        
        
        BufferStrategy bufferStrategy =  mainFrame.getBufferStrategy();
        try {
            Graphics2D g = (Graphics2D)bufferStrategy.getDrawGraphics();
            Rectangle bounds = mainFrame.getBounds();
            for (int i=0; i<90; i++) {
                
                g = (Graphics2D)bufferStrategy.getDrawGraphics();
                if (!bufferStrategy.contentsLost()) {
                    /*drawsnext*/
                    g.setColor(color2);
                    g.fillRect(0,0,bounds.width, bounds.height);
                    g.drawImage(next,null,((width-next.getWidth())/2),((height-next.getHeight())/2));
                    /*draw top*/
                    g.setColor(color1);
                    g.fillRect((width/60)*i,0,bounds.width, bounds.height);
                    g.drawImage(buff,null,((width-buff.getWidth())/2)+(width/60)*i,((height-buff.getHeight())/2));
                    bufferStrategy.show();
                    g.dispose();
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {}
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
