/*
 * Created on Sep 28, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package edu.cs2335.lab5.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import edu.cs2335.lab5.protocol.requests.AlbumList;
import edu.cs2335.lab5.protocol.requests.Authentication;
import edu.cs2335.lab5.protocol.requests.Request;
import edu.cs2335.lab5.protocol.responses.Response;

/**
 * @author jeff
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AlbumClient {
    public static void main(String[] args) throws ClassNotFoundException, ClassNotFoundException, UnknownHostException, IOException {

        Socket socket = null;
 
        socket = new Socket("localhost", 2969);
        
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
    
        Request authenticate = new Authentication(null, null);
        Request albumList = new AlbumList();
        
        // mgb->jmy: moved the dipatching code to the Request object to save on having to 
        // re-write code over and over again to write to an ObjectOutputStream
        
        try {
            authenticate.dispatch(socket.getOutputStream());
        } catch (IOException e) {
            // mgb: error dispatching authenticate request
            System.err.println(e.getMessage());
        }
        
        Response response = null;
        response = (Response) in.readObject();
        
    }
}
