/*
 * FadeTable.java
 *
 * Created on September 30, 2004, 1:53 AM
 */

/**
 *
 * @author  root
 */
package edu.cs2335.lab5.common;

public class FadeTable implements java.io.Serializable {
    private byte[][] data  =  new byte[31][256];
    /** Creates a new instance of FadeTable */
    public FadeTable() {
        generate();
    }
    public final void generate(){
        
        for (int i = 0;i <= 30;i++){
            for(int id  =  0; id < 256; id++) {
                data[i][id]  =  (byte)((id/255.0) * (255-(255/30)*i));
            }
        }
    }
    public byte[] getRow(int i){
        return data[i];
    }
}
