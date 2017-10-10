//Source file: /net/hu11/mgbowman/cs2335/lab5/src/edu/cs2335/lab5/protocol/responses/ViewAlbum.java

package edu.cs2335.lab5.protocol.responses;

import java.util.List;

import edu.cs2335.lab5.common.Album;

/**
 * ViewAlbum will Respond to a client's Request to view an album.
 */
public final class ViewAlbum extends Response {
    
    /**
     * The ablum to view
     */
    private Album album;
    
    /**
     * Boolean flag to whether or not there are new photos to be downloaded
     */
    private boolean newPhotos;
    
    /**
     * List of photos that were removed from server, 
     * but still on client side. (photos to delete)
     */
    private List deprecatedPhotos;
    
    /**
     * Constructs a new ViewAlbum Request based off the given parameters.
     * @param album - The ablum to view
     * @param newPhotos - Boolean flag to whether or not there are new photos to be 
     * downloaded
     */
    public ViewAlbum(Album album, boolean newPhotos, List deprecatedPhotos) {
        setAlbum(album);
        setNewPhotos(newPhotos);
        setDeprecatedPhotos(deprecatedPhotos);
    }
    /**
     * @return Returns the deprecatedPhotos.
     */
    public List getDeprecatedPhotos() {
        return deprecatedPhotos;
    }
    /**
     * @param deprecatedPhotos The deprecatedPhotos to set.
     */
    public void setDeprecatedPhotos(List deprecatedPhotos) {
        this.deprecatedPhotos = deprecatedPhotos;
    }
    /**
     * @return Returns the album.
     */
    public Album getAlbum() {
        return album;
    }
    /**
     * @param album The album to set.
     */
    public void setAlbum(Album album) {
        this.album = album;
    }
    /**
     * @return Returns the newPhotos.
     */
    public boolean isNewPhotos() {
        return newPhotos;
    }
    /**
     * @param newPhotos The newPhotos to set.
     */
    public void setNewPhotos(boolean newPhotos) {
        this.newPhotos = newPhotos;
    }
}
