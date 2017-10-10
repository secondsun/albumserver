package edu.cs2335.lab5;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author mgbowman
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class PhotoEngine {
    
    private static final GraphicsConfiguration GC =
        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
    
    private static final int SCALE_WIDTH  = 150;
    private static final int SCALE_HEIGHT = 100;
    
    public static BufferedImage createScaledBufferedImage(BufferedImage originalPhoto) {
        
        int scaleWidth  = SCALE_WIDTH;
        int scaleHeight = SCALE_HEIGHT;
        
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


    
    public static BufferedImage createOriginalBufferedImage(File photoFile) {
        
        // mgb: read photo from HDD
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
    
    //HSP:  I needed an overload of this for the transitions.
    public static BufferedImage createOriginalBufferedImage(File photoFile, GraphicsConfiguration gcIn) {
        
        // mgb: read photo from HDD
        BufferedImage tmp = null;
        try {
            tmp = ImageIO.read(photoFile);
        } catch (IOException e) {
            // mgb: error reading image
            return null;
        }
        
        BufferedImage ret = 
            gcIn.createCompatibleImage(tmp.getWidth(), tmp.getHeight());
        
        Graphics2D g2d = ret.createGraphics();
        g2d.setComposite(AlphaComposite.Src);
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        
        return ret;
    }
    
    //HSP:  I needed an overload of this for the transitions.
    public static BufferedImage createScaledBufferedImage(BufferedImage originalPhoto, int scaleWidthIn,int scaleHeightIn, GraphicsConfiguration  gcIn) {
        
        int scaleWidth  = scaleWidthIn;
        int scaleHeight = scaleHeightIn;
        
        double scaleRatio = (double) scaleWidth / (double) scaleHeight;
        double originalRatio = (double) originalPhoto.getWidth() / (double) originalPhoto.getHeight();
        
        if (scaleRatio < originalRatio) {
            scaleHeight = (int)(scaleWidth / originalRatio);
        } else {
            scaleWidth = (int)(scaleHeight * originalRatio);
        }
        
        BufferedImage ret =
            gcIn.createCompatibleImage(scaleWidth, scaleHeight);
        
        Graphics2D g2d = ret.createGraphics();
        g2d.setComposite(AlphaComposite.Src);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(originalPhoto, 0, 0, scaleWidth, scaleHeight, null);
        g2d.dispose();
        
        return ret;
    }
   
}
