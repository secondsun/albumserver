/*
 * Created on Sep 29, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package edu.cs2335.lab5.protocol.responses;

/**
 * @author jeff
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Error extends Response {
    public static final int ERROR_EMPTY_REQUEST = -1;
    public static final int ERROR_INVALID_REQUEST = -2;
    
    private int error;
    
    public Error(int error) {
        System.err.println("Error: Request error " + error + "!");
        setError(error);
    }
    
    public void setError(int error) {
        this.error = error;
    }
    public int getError() {
        return error;
    }
}
