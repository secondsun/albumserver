//Source file: /net/hu11/mgbowman/cs2335/lab5/src/edu/cs2335/lab5/common/FadeTransition.java

package edu.cs2335.lab5.common;
import edu.cs2335.lab5.PhotoEngine;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import java.awt.image.ByteLookupTable;
import java.awt.image.LookupOp;
import java.io.File;


public class FadeTransition extends Transition {
    
    public FadeTransition() {
        
    }
    
    
    public void transform(Photo buffPhoto, Color color1,Photo nextPhoto,Color color2,Frame mainFrame){
        GraphicsConfiguration gc=mainFrame.getGraphicsConfiguration();
        int width=mainFrame.getWidth();
        int height=mainFrame.getHeight();
        
        BufferedImage buff=PhotoEngine.createOriginalBufferedImage(
                                        new File(buffPhoto.getFileName()),gc);
        buff=PhotoEngine.createScaledBufferedImage(buff,width,height,gc);
        
        BufferedImage next=PhotoEngine.createOriginalBufferedImage(
                                        new File(nextPhoto.getFileName()),gc);
        
        next=PhotoEngine.createScaledBufferedImage(next,width,height,gc);
        BufferedImage next2 = new BufferedImage(width,height,buff.getType());
        Graphics2D temp = next2.createGraphics();
        temp.setColor(color1);
        temp.fillRect(0,0,width,height);
        temp.drawImage(buff,null,((width-buff.getWidth())/2),
                                 ((height-buff.getHeight())/2));
        buff = next2;
        temp.dispose();
        
        FadeTable t = new FadeTable();
        byte[] data;
        BufferStrategy bufferStrategy  =   mainFrame.getBufferStrategy();
        
        try {
            Graphics2D g  =  (Graphics2D)bufferStrategy.getDrawGraphics();
            Rectangle bounds  =  mainFrame.getBounds();
            g.dispose();
            for (int i = 0; i<31; i++) {
                data = t.getRow(i);
                ByteLookupTable table  =  new ByteLookupTable(0, data);
                LookupOp op  =  new LookupOp(table, null);
                BufferedImage brighterImage  =  op.filter(buff, null);
                if (!bufferStrategy.contentsLost()) {
                    g  =  (Graphics2D)bufferStrategy.getDrawGraphics();
                    /*g.setColor(color1);
                    g.fillRect(0,0,bounds.width, bounds.height);*/
                    //g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,((float)i/30.0f)));
                    //g.drawImage(buff,null,((width-buff.getWidth())/2),((height-buff.getHeight())/2));
                    g.drawImage(brighterImage,null,((width-buff.getWidth())/2),((height-buff.getHeight())/2));
                    bufferStrategy.show();
                    g.dispose();
                }
                try{Thread.sleep(10);}catch(Exception e){}
            }
            
            next2 = new BufferedImage(width,height,next.getType());
            temp = next2.createGraphics();
            temp.setColor(color2);
            temp.fillRect(0,0,width,height);
            temp.drawImage(next,null,((width-next.getWidth())/2),((height-next.getHeight())/2));
            next = next2;
            temp.dispose();


            for (int i = 30; i>-1; i--) {
                data = t.getRow(i);
                ByteLookupTable table  =  new ByteLookupTable(0, data);
                LookupOp op  =  new LookupOp(table, new java.awt.RenderingHints(RenderingHints.KEY_COLOR_RENDERING ,RenderingHints.VALUE_COLOR_RENDER_SPEED ));
                BufferedImage brighterImage  =  op.filter(next, null);
                g  =  (Graphics2D)bufferStrategy.getDrawGraphics();
                if (!bufferStrategy.contentsLost()) {
                    //g.setColor(color2);
                    //g.fillRect(0,0,bounds.width, bounds.height);
                    g.drawImage(brighterImage,null,((width-next.getWidth())/2),((height-next.getHeight())/2));
                    //g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,((float)i/30.0f)));
                    //g.drawImage(next,null,((width-next.getWidth())/2),((height-next.getHeight())/2));
                    bufferStrategy.show();
                    g.dispose();
                }
                try{Thread.sleep(10);}catch(Exception e){}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
