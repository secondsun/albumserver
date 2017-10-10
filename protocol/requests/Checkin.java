//Source file: /net/hu11/mgbowman/cs2335/lab5/src/edu/cs2335/lab5/protocol/requests/Checkin.java

package edu.cs2335.lab5.protocol.requests;


/**
 * Checkin will request from a server that the currently edited album be checked 
 * in for editing by the others.
 */
public final class Checkin extends Request {
    
    /**
     * album number to be checked in
     */
    private int albumNumber;
    
    /**
     * Constructs a new Checkin Request based off the given parameters.
     * @param albumNumber - album number to be checked in
     */
    public Checkin(int albumNumber) {
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
