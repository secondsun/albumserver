//Source file: /net/hu11/mgbowman/cs2335/lab5/src/edu/cs2335/lab5/protocol/responses/SaveAlbum.java

package edu.cs2335.lab5.protocol.responses;


/**
 * SaveAlbum responds to a client's request to save an album.
 */
public final class SaveAlbum extends Response {
    boolean success;
    /**
     * Constructs a new SaveAlbum Response based off the given parameters.
     * @param success - was successful
     */
    public SaveAlbum(boolean success) {
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
