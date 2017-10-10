/**
 * This test takes a number up to 13 as an argument (assumes 2 by
 * default) and creates a multiple buffer strategy with the number of
 * buffers given.  This application enters full-screen mode, if available,
 * and flips back and forth between each buffer (each signified by a different
 * color).
 */
package cs2335.lab5.common;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;


public class ModeDevice {
    
    private static DisplayMode[] BEST_DISPLAY_MODES = new DisplayMode[] {
        new DisplayMode(800,600, 32, 0),
        new DisplayMode(800,600, 16, 0),
        new DisplayMode(800,600, 8, 0)
    };
    
    
    
    public ModeDevice() {
        
    /*    try {
            GraphicsConfiguration gc = device.getDefaultConfiguration();
            mainFrame = new Frame(gc);
            mainFrame.setUndecorated(true);
            mainFrame.setIgnoreRepaint(true);
            device.setFullScreenWindow(mainFrame);
            if (device.isDisplayChangeSupported()) {
                chooseBestDisplayMode(device);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            device.setFullScreenWindow(null);
        }*/
    }
    
    private static DisplayMode getBestDisplayMode(GraphicsDevice device) {
        for (int x = 0; x < BEST_DISPLAY_MODES.length; x++) {
            DisplayMode[] modes = device.getDisplayModes();
            for (int i = 0; i < modes.length; i++) {
                if (modes[i].getWidth() == BEST_DISPLAY_MODES[x].getWidth()
                && modes[i].getHeight() == BEST_DISPLAY_MODES[x].getHeight()
                && modes[i].getBitDepth() == BEST_DISPLAY_MODES[x].getBitDepth()
                ) {
                    return BEST_DISPLAY_MODES[x];
                }
            }
        }
        return null;
    }
    
    public static void chooseBestDisplayMode(GraphicsDevice device) {
        DisplayMode best = getBestDisplayMode(device);
        if (best != null) {
            device.setDisplayMode(best);
        }
    }
    /*
    public static BufferedImage createBufferedImage(String photoFilePath) {
        
        // mgb: read photo from HDD
        File photoFile = new File(photoFilePath);
        BufferedImage tmp = null;
        
        try {
            tmp = ImageIO.read(photoFile);
        } catch (IOException e) {
            // mgb: error reading image
            return null;
        }
        
        BufferedImage ret =
        GC.createCompatibleImage(tmp.getWidth(), tmp.getHeight());
        
        Graphics2D g2d = ret.createGraphics();
        g2d.setComposite(AlphaComposite.Src);
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        
        return ret;
    }
    
    public static BufferedImage createScaledBufferedImage(BufferedImage originalPhoto) {
        
        int scaleWidth  = (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int scaleHeight = (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        
        double scaleRatio = (double) scaleWidth / (double) scaleHeight;
        double originalRatio = (double) originalPhoto.getWidth() / (double) originalPhoto.getHeight();
        
        if (scaleRatio < originalRatio) {
            scaleHeight = (int)(scaleWidth / originalRatio);
        } else {
            scaleWidth = (int)(scaleHeight * originalRatio);
        }
        
        BufferedImage ret =
        GC.createCompatibleImage(scaleWidth, scaleHeight);
        
        Graphics2D g2d = ret.createGraphics();
        g2d.setComposite(AlphaComposite.Src);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(originalPhoto, 0, 0, scaleWidth, scaleHeight, null);
        g2d.dispose();
        
        return ret;
    }
    
    */
    
    
    
/*        public static void main(String[] args) {
            try {
                int numBuffers = 2;
                if (args != null && args.length > 0) {
                    numBuffers = Integer.parseInt(args[0]);
                    if (numBuffers < 2 || numBuffers > COLORS.length) {
                        System.err.println("Must specify between 2 and "
                        + COLORS.length + " buffers");
                        System.exit(1);
                    }
                }
                GraphicsEnvironment env = GraphicsEnvironment.
                getLocalGraphicsEnvironment();
                GraphicsDevice device = env.getDefaultScreenDevice();
                MultiBufferTest test = new MultiBufferTest(numBuffers, device);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.exit(0);
        }*/
}
