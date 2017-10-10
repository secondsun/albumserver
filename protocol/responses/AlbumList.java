//Source file: /net/hu11/mgbowman/cs2335/lab5/src/edu/cs2335/lab5/protocol/responses/AlbumList.java

package edu.cs2335.lab5.protocol.responses;

import java.util.List;


public class AlbumList extends Response {
    private List albums;
    
    public AlbumList() {
        setAlbums(albums);
    }
    /**
     * @return Returns the albums.
     */
    public List getAlbums() {
        return albums;
    }
    /**
     * @param albums The albums to set.
     */
    public void setAlbums(List albums) {
        this.albums = albums;
    }
}
