//Source file: /net/hu11/mgbowman/cs2335/lab5/src/edu/cs2335/lab5/common/Slide.java

package edu.cs2335.lab5.common;

// jmy: I imported Color so it would compile
import java.awt.Color;


public class Slide {
    private Color backgroundColor = Color.black;
    private int time = 0;
    private Photo photo;
    private Transition transition;
    
    public Slide(Photo inPhoto,Transition inTransition) {
        photo = inPhoto;
        transition = inTransition;
    }
    public Slide(Photo inPhoto,Transition inTransition,Color background) {
        photo = inPhoto;
        transition = inTransition;
        backgroundColor = background;
    }
    
    public Slide(Photo inPhoto,Transition inTransition,Color background,int inTime) {
        photo = inPhoto;
        transition = inTransition;
        backgroundColor = background;
        time = inTime;
    }
    public Slide(Photo inPhoto,Transition inTransition,int inTime) {
        photo = inPhoto;
        transition = inTransition;
        time = inTime;
    }
    
    public Color getBackgrounColor(){
        return backgroundColor;
    }
    
    public int getTime(){
        return time;
    }
    
    public Transition getTransition(){
        return transition;
    }
    
    public Photo getPhoto(){
        return photo;
    }
    
    public void setBackgroundColor(Color newbg){
        backgroundColor = newbg;
    }
    
    public void setTime(int inTime){
        time = inTime;
    }
    
    public void setPhoto(Photo inPhoto){
        photo = inPhoto;
    }
    
    public void setTransition(Transition inT){
        transition = inT;
    }
}
