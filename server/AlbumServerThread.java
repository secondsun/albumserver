/*
 * Created on Sep 27, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package edu.cs2335.lab5.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import edu.cs2335.lab5.protocol.requests.Request;
import edu.cs2335.lab5.protocol.responses.Response;

/**
 * @author jeff
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AlbumServerThread extends Thread {
    private Socket socket = null;
    AlbumManagerState state = new AlbumManagerState();

    public AlbumServerThread(Socket socket) {
        super("AlbumServerThread");
        this.socket = socket;
    }

    public void run() {
        Object inputObject = null;
 
        try {
            
            // mgb: not the dispatch routine in Response (same as Request)
            
//            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            
            while ((inputObject = in.readObject()) != null) {
                Response response = AlbumManager.respond(state, (Request) inputObject);
//                out.writeObject(response);
                try {
                    response.dispatch(socket.getOutputStream());
                } catch (IOException e) {
                    // mgb: error dispatching response
                    System.err.println(e.getMessage());
                }
            }
            
//            out.close();
            in.close();
            socket.close();
            socket = null;
        }
        catch(IOException e) {
            System.err.println("AlbumServerThread Error: I/O Exception caught!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("AlbumServerThread Error: ClassNotFoundException caught!");
            e.printStackTrace();
        }
    }
}
