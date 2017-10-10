/*
 * Test.java
 *
 * Created on October 2, 2004, 11:32 PM
 */

package edu.cs2335.lab5.common;

/**
 *
 * @author  Sheila Pittman
 */
public class Test {
    public int x;
    public int y;
    /** Creates a new instance of Test */
    public Test(int x1,int y1) {
        x=x1;
        y=y1;
    }
    
    public void swap(){
        x=x^y;
        y=y^x;
        x=y^x;
    }
    
    public String toString(){
        return ("X: "+x+" Y: "+y);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Test t1=new Test(5,6);
        System.out.println(t1);
        t1.swap();
        System.out.println(t1);
    }
    
}
