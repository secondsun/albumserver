//Source file: /net/hu11/mgbowman/cs2335/lab5/src/edu/cs2335/lab5/protocol/requests/CreateAlbum.java

package edu.cs2335.lab5.protocol.requests;


/**
 * CreateAlbum will request that a server create a new album.
 * mgb->jmy: the data members for CreateAlbum were just the album name.  I figured 
 * that we would want to send the album name & album description and we could do 
 * the album number hash off that combination.  one other thing to consider is 
 * that the album numbers are going to have to be unique across all the server 
 * albums.  I don't know if you've thought about it at all but just want to make 
 * sure I bring it to your attention.
 */
public final class CreateAlbum extends Request {
    
    /**
     * the name of the album to create
     */
    private String name;
    
    /**
     * the description of the album to create
     */
    private String description;
    
    /**
     * Constructs a new CreateAlbum Request based off the given parameters.
     * @param name - the name of the album to create
     * @param description - the description of the album to create
     */
    public CreateAlbum(String name, String description) {
        setName(name);
        setDescription(description);
    }
    /**
     * @return Returns the description.
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }
    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }
}
