//Source file: /net/hu11/mgbowman/cs2335/lab5/src/edu/cs2335/lab5/protocol/requests/RemoveAlbum.java

package edu.cs2335.lab5.protocol.requests;


/**
 * RemoveAlbum will request that a server remove an existing album.
 */
public final class RemoveAlbum extends Request {
    
    /**
     * album number to remove
     */
    private int albumNumber;
    
    /**
     * Constructs a new RemoveAlbum Request based off the given parameters.
     * @param albumNumber - album number to remove
     */
    public RemoveAlbum(int albumNumber) {
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
