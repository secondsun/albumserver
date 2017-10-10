//Source file: /net/hu11/mgbowman/cs2335/lab5/src/edu/cs2335/lab5/protocol/responses/Authentication.java

package edu.cs2335.lab5.protocol.responses;


/**
 * Authentication will Respond to the client denoting whether the Authentication 
 * attempt was a success or failure.
 */
public final class Authentication extends Response {
    
    /**
     * did the user authenticate successfully
     */
    private boolean success;
    
    /**
     * is the user a new user
     */
    private boolean newUser;
    
    /**
     * is the permission read only
     */
    private boolean readOnly;
    
    /**
     * Constructs a new Authentication Response to send to a client on Receipt of an 
     * Authentication Request.
     * @param success - was the user authenticated
     * @param newUser - is the user a new user
     * @param readOnly - is the permission read only
     */
    public Authentication(boolean success, boolean newUser, boolean readOnly) {
        setSuccess(success);
        setNewUser(newUser);
        setReadOnly(readOnly);
    }
    /**
     * @return Returns the newUser.
     */
    public boolean isNewUser() {
        return newUser;
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
    /**
     * @param newUser The newUser to set.
     */
    public void setNewUser(boolean newUser) {
        this.newUser = newUser;
    }
    /**
     * @return Returns the readOnly.
     */
    public boolean isReadOnly() {
        return readOnly;
    }
    /**
     * @param readOnly The readOnly to set.
     */
    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }
}
