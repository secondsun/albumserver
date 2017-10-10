//Source file: /net/hu11/mgbowman/cs2335/lab5/src/edu/cs2335/lab5/protocol/responses/Checkin.java

package edu.cs2335.lab5.protocol.responses;


/**
 * Checkin will respond to a client's Checkin Request denoting the success of the 
 * Checkin.
 */
public final class Checkin extends Response {
    
    boolean success;
    
    /**
     * Constructs a new Checkin Response based off the given parameters.
     * @param success - was successful
     */
    public Checkin(boolean success) {
        setSuccess(success);
    }
    /**
     * @return Returns the success.
     */
    public boolean isSuccess() {
        return success;
    }
    /**
     * @param success The success to set.
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }
}
