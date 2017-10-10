//Source file: /net/hu11/mgbowman/cs2335/lab5/src/edu/cs2335/lab5/protocol/responses/RemoveAlbum.java

package edu.cs2335.lab5.protocol.responses;


/**
 * RemoveAlbum responds to a client's RemoveAlbum Request denoting the success of 
 * the Album remove.
 */
public final class RemoveAlbum extends Response {
    
    boolean success;
    /**
     * Constructs a new RemoveAlbum Response based off the given parameters.
     * @param success - was successful
     */
    public RemoveAlbum(boolean success) {
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
