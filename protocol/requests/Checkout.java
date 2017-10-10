//Source file: /net/hu11/mgbowman/cs2335/lab5/src/edu/cs2335/lab5/protocol/requests/Checkout.java

package edu.cs2335.lab5.protocol.requests;


/**
 * Checkout will request from a server that the specified Album be checked out 
 * for 
 * editing.
 */
public final class Checkout extends Request {
    
    /**
     * album number to be checked out
     */
    private int albumNumber;
    
    /**
     * Constructs a new Checkout Request based off the given parameters.
     * @param album - album number to be checked out
     */
    public Checkout(int albumNumber) {
        setAlbumNumber(albumNumber);
    }
    /**
     * @return Returns the albumNumber.
     */
    public int getAlbumNumber() {
        return albumNumber;
    }
    /**
     * @param albumNumber The albumNumber to set.
     */
    public void setAlbumNumber(int albumNumber) {
        this.albumNumber = albumNumber;
    }
}
