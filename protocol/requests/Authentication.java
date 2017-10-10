//Source file: /net/hu11/mgbowman/cs2335/lab5/src/edu/cs2335/lab5/protocol/requests/Authentication.java

package edu.cs2335.lab5.protocol.requests;


/**
 * Authentication will request to be authenticated by a server.
 */
public final class Authentication extends Request {
    
    /**
     * username of Authentication Request
     */
    private String username;
    
    /**
     * password of Authentication Request
     */
    private String password;
    
    /**
     * Constructs a new Authentication Request based off the given parameters.
     * @param username - username of Authentication Request
     * @param password - password of Authentication Request
     */
    public Authentication(String username, String password) {
        setUsername(username);
        setPassword(password);
    }
    
    /**
     * @return Returns the password.
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return Returns the username.
     */
    public String getUsername() {
        return username;
    }
    /**
     * @param username The username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

}
