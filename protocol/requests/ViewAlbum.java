//Source file: /net/hu11/mgbowman/cs2335/lab5/src/edu/cs2335/lab5/protocol/requests/ViewAlbum.java

package edu.cs2335.lab5.protocol.requests;

import java.util.List;


public final class ViewAlbum extends Request {
    private int albumNumber;
    private List clientPhotos;
    
    public ViewAlbum(int albumNumber, List clientPhotos) {
        setAlbumNumber(albumNumber);
        setClientPhotos(clientPhotos);
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
    /**
     * @return Returns the clientPhotos.
     */
    public List getClientPhotos() {
        return clientPhotos;
    }
    /**
     * @param clientPhotos The clientPhotos to set.
     */
    public void setClientPhotos(List clientPhotos) {
        this.clientPhotos = clientPhotos;
    }
}
