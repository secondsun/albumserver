
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



public class SquareTransition extends Transition {
    
    
    
    public SquareTransition() {
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
        
        
        BufferedImage next2 = new BufferedImage(width,height,next.getType());
        Graphics2D temp = next2.createGraphics();
        temp.setColor(color2);
        temp.fillRect(0,0,width,height);
        temp.drawImage(next,null,((width-next.getWidth())/2),((height-next.getHeight())/2));
        next = next2;
        temp.dispose();
        BufferStrategy bufferStrategy  =   mainFrame.getBufferStrategy();
        java.util.LinkedList squares = new java.util.LinkedList();
        for(int i = 0;i<900;i++){
            squares.add(new Integer(i));
        }
        try {
            Graphics2D g  =  (Graphics2D)bufferStrategy.getDrawGraphics();
            BufferedImage nextDraw = new BufferedImage(width,height,next.getType());
            Graphics2D gNext = nextDraw.createGraphics();
            Rectangle bounds  =  mainFrame.getBounds();
            gNext.setColor(color1);
            gNext.fillRect(0,0,width,height);
            if (!bufferStrategy.contentsLost()) {
                g.setColor(color1);
                gNext.drawImage(buff,null,((width-buff.getWidth())/2),((height-buff.getHeight())/2));
                g.drawImage(nextDraw,null,((width-next.getWidth())/2),((height-next.getHeight())/2));
                bufferStrategy.show();
                for(int i = 0;i<900;i++){
                    int index = (int)(Math.random()*squares.size());
                    int gotSq = ((Integer)squares.get(index)).intValue();
                    squares.remove(index);
                    BufferedImage subImage = next.getSubimage((gotSq)/30*(width/30),gotSq%30*(height/30), width/30,height/30);
                    gNext.drawImage(subImage,null,(gotSq/30*(width/30)),gotSq%30*(height/30));
                    if(i%10==0){
                        subImage = next.getSubimage(width-(width/30),i/30*(height/30), width/30,height/30);
                        gNext.drawImage(subImage,null,width-(width/30),i/30*(height/30));
                    }
                    g.drawImage(nextDraw,null,0,0);
                    bufferStrategy.show();
                    //System.out.println(squares.size()+"");
                    //try{Thread.sleep(1);}catch(Exception e){}
                }
                g.setColor(color2);
                g.drawImage(next,null,((width-next.getWidth())/2),((height-next.getHeight())/2));
                bufferStrategy.show();
                System.out.println("next:"+next.getWidth()+","+next.getHeight());
                System.out.println("nextDraw:"+nextDraw.getWidth()+","+nextDraw.getHeight());
                g.dispose();
                gNext.dispose();
            }
            
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
