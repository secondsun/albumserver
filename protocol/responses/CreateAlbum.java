//Source file: /net/hu11/mgbowman/cs2335/lab5/src/edu/cs2335/lab5/protocol/responses/CreateAlbum.java

package edu.cs2335.lab5.protocol.responses;


/**
 * CreateAlbum responds to a client's CreateAlbum Request denoting the success of 
 * the Album creation.
 */
public final class CreateAlbum extends Response {
    
    boolean success;
    
    /**
     * Constructs a new CreateAlbum Response based on the given parameters.
     * @param success - was successful
     */
    public CreateAlbum(boolean success) {
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
