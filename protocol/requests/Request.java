//Source file: /net/hu11/mgbowman/cs2335/lab5/src/edu/cs2335/lab5/protocol/requests/Request.java

package edu.cs2335.lab5.protocol.requests;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public abstract class Request implements Serializable {
    
    public void dispatch(OutputStream outputStream) throws IOException {
        ObjectOutputStream oos =
            new ObjectOutputStream(outputStream);
        
        oos.writeObject(this);
        oos.close();
    }
}
