//Source file: /net/hu11/mgbowman/cs2335/lab5/src/edu/cs2335/lab5/protocol/requests/SaveAlbum.java

package edu.cs2335.lab5.protocol.requests;

import java.util.List;

import edu.cs2335.lab5.common.Album;

/**
 * SaveAlbum will request that a server save an existing album.
 */
public final class SaveAlbum extends Request {
    
    /**
     * Album to save
     */
    private Album album;
    
    /**
     * Boolean flag denoting whether or not the client has new photo.
     */
    private boolean newPhotos;
    
    /**
     * list of deleted photo
     * 
     */
    private List deprecatedPhotos;
    
    /**
     * Constructs a new SaveAlbum Request based off the given parameters.
     * @param album - Album to save
     * @param newPhotos - Boolean flag denoting whether or not the client has new 
     * photos.
     */
    public SaveAlbum(Album album, boolean newPhotos, List deprecatedPhotos) {
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
