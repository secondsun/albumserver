//Source file: /net/hu11/mgbowman/cs2335/lab5/src/edu/cs2335/lab5/common/Slideshow.java

package edu.cs2335.lab5.common;

import cs2335.lab5.common.ModeDevice;
import edu.cs2335.lab5.PhotoEngine;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

public class Slideshow {
    
    private String name;
    private List slides;
    
    public Slideshow() {
        slides = new LinkedList();
        name = "";
    }
    public void setName(String inName){
        name = inName;
    }
    
    public String getName(){
        return name;
    }
    
    public LinkedList getSlides(){
        return (LinkedList)slides;
    }
    
    public void addSlide(Slide inSlide){
        slides.add(inSlide);
    }
    
    public void removeSlide(int index) throws IndexOutOfBoundsException{
        slides.remove(index);
    }
    
    public void fullScreenSlideShow(){
        BufferedImage currentPhotoImage;
        BufferedImage nextPhotoImage;
        int width;
        int height;
        Photo currentPhoto;
        Photo nextPhoto;
        Slide currentSlide;
        Slide nextSlide;
        GraphicsDevice device;
        Frame mainFrame;
        
        ModeDevice md=new ModeDevice();
        GraphicsEnvironment env = GraphicsEnvironment.
        getLocalGraphicsEnvironment();
        device = env.getDefaultScreenDevice();
        ListIterator slidesIterator=slides.listIterator();
        try {
            GraphicsConfiguration gc = device.getDefaultConfiguration();
            mainFrame = new Frame(gc);
            
            mainFrame.setUndecorated(true);
            mainFrame.setIgnoreRepaint(true);
            device.setFullScreenWindow(mainFrame);
            if (device.isDisplayChangeSupported()) {
                md.chooseBestDisplayMode(device);
            }
            mainFrame.createBufferStrategy(3);
            BufferStrategy bufferStrategy  =   mainFrame.getBufferStrategy();
            width=mainFrame.getWidth();
            height=mainFrame.getHeight();
            
            //Unroll first loop/setupscreen
            
            currentSlide=(Slide)slidesIterator.next();
            currentPhoto=currentSlide.getPhoto();
            currentPhotoImage=PhotoEngine.createOriginalBufferedImage(
                new File(currentPhoto.getFileName()));
            currentPhotoImage=PhotoEngine.createScaledBufferedImage(
                currentPhotoImage,width,height,gc);
            System.err.println(currentPhoto.getFileName()+" "+currentPhotoImage.getWidth()+","+currentPhotoImage.getHeight());
            Graphics2D g2d=(Graphics2D)bufferStrategy.getDrawGraphics();
            g2d.setColor(currentSlide.getBackgrounColor());
            g2d.fillRect(0,0,width,height);
            g2d.drawImage(currentPhotoImage,
                    null,
                    ((width-currentPhotoImage.getWidth())/2),
                    ((height-currentPhotoImage.getHeight())/2));
            g2d.dispose();
            bufferStrategy.show();
            try {
                Thread.sleep(currentSlide.getTime()*1000);
            } catch (Exception e) {}
            
            while(slidesIterator.hasNext()){
                nextSlide=(Slide)slidesIterator.next();
                nextPhoto=nextSlide.getPhoto();
                currentSlide.getTransition().transform(currentPhoto,
                currentSlide.getBackgrounColor(),
                nextPhoto,
                nextSlide.getBackgrounColor(),
                mainFrame);
                try {
                    Thread.sleep(nextSlide.getTime()*1000);
                } catch (Exception e) {}
                
                currentPhoto=nextPhoto;
                currentSlide=nextSlide;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            device.setFullScreenWindow(null);
        }
        
    }
    
    public static void main(String[] srgs){
        Slideshow ss=new Slideshow();
        Slide Slide1;
        Slide1=new Slide(new Photo("c:\\AWARE.JPG"), new SquareTransition(), Color.red, 8);
        ss.addSlide(Slide1);
        Slide1=new Slide(new Photo("c:/ATTORNEYSKEET.JPG"), new FadeTransition(), Color.blue, 3);
        ss.addSlide(Slide1);
        Slide1=new Slide(new Photo("c:/OLYMPIC_PAC_MAN.JPG"), new SlideTransition(2), Color.white, 3);
        ss.addSlide(Slide1);
        Slide1=new Slide(new Photo("c:/javault.jpg"), new SquareTransition(), Color.yellow, 3);
        ss.addSlide(Slide1);
        Slide1=new Slide(new Photo("c:/Drywell.jpg"), new FadeTransition(), Color.pink, 3);
        ss.addSlide(Slide1);
        Slide1=new Slide(new Photo("c:/SOYLENTLAND.JPG"), new SlideTransition(2), Color.black, 3);
        ss.addSlide(Slide1);
        try {
            ss.fullScreenSlideShow();
        } catch (Exception e){
            System.exit(1);
        }
        System.exit(0);
    }
    
}
