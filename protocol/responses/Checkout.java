//Source file: /net/hu11/mgbowman/cs2335/lab5/src/edu/cs2335/lab5/protocol/responses/Checkout.java

package edu.cs2335.lab5.protocol.responses;


/**
 * Checkout will respond to a client's Checkout Request denoting the success of 
 * the 
 * Checkout.
 */
public final class Checkout extends Response {
    
    boolean success;
    
    /**
     * Constructs a new Checkout Response based off the given parameters.
     * @param success - was successful
     */
    public Checkout(boolean success) {
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
