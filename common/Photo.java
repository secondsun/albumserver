//Source file: /net/hu11/mgbowman/cs2335/lab5/src/edu/cs2335/lab5/common/Photo.java

package edu.cs2335.lab5.common;


public class Photo {
    private String fileName;
    private Metadata theMetadata;
    
    public Photo(String inFile) {
        fileName = inFile;
	theMetadata =  new Metadata();
    }
    
    public String getFileName(){
        return fileName;
    }
     
    public Metadata getMetadata(){
    	return theMetadata;
    }  
    
    
}
