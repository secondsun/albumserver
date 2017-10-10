//Source file: /net/hu11/mgbowman/cs2335/lab5/src/edu/cs2335/lab5/protocol/responses/Response.java

package edu.cs2335.lab5.protocol.responses;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public abstract class Response implements Serializable {
    private boolean status;
    
    public void dispatch(OutputStream outputStream) throws IOException {
        ObjectOutputStream oos =
            new ObjectOutputStream(outputStream);
        
        oos.writeObject(this);
        oos.close();
    }
    
    /**
     * @return Returns the status.
     */
    public boolean isStatus() {
        return status;
    }
    
    /**
     * @param status The status to set.
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
}
