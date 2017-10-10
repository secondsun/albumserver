//Source file: /net/hu11/mgbowman/cs2335/lab5/src/edu/cs2335/lab5/common/Transition.java

package edu.cs2335.lab5.common;

import java.awt.Color;
import java.awt.Frame;
import java.awt.image.BufferedImage;

public abstract class Transition {

    private String name;
    
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    /**
     * @param firstGraphic
     */
    public abstract void transform(Photo buffPhoto, Color color1,Photo nextPhoto, Color color2,Frame mainFrame) ;
}
