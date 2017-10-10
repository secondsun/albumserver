/*
 * Created on Sep 28, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package edu.cs2335.lab5.server;

import java.io.File;

import javax.swing.filechooser.FileSystemView;

import edu.cs2335.lab5.protocol.requests.Request;
import edu.cs2335.lab5.protocol.requests.AlbumList;
import edu.cs2335.lab5.protocol.requests.Authentication;
import edu.cs2335.lab5.protocol.requests.Checkin;
import edu.cs2335.lab5.protocol.requests.Checkout;
import edu.cs2335.lab5.protocol.requests.CreateAlbum;
import edu.cs2335.lab5.protocol.requests.RemoveAlbum;
import edu.cs2335.lab5.protocol.requests.SaveAlbum;
import edu.cs2335.lab5.protocol.requests.ViewAlbum;
import edu.cs2335.lab5.protocol.responses.Response;
import edu.cs2335.lab5.protocol.responses.Error;

/**
 * @author jeff
 * looks at the state and the request
 * returns a response and updates the state
 * the class is static, state is held in the individual thread
 * makes synchronizing VERY easy, since only one object
 * (rather than serveral objects of the same class) needs
 * to be synchronized
 * What is album manager had state, not static, but respond was?
 * can static respond refer to non static members?
 */
public abstract class AlbumManager {
// jmy: abstract will keep it static, and respond synchronized
    public static final String DATA_DIR = "data"; 
    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static synchronized Response respond(AlbumManagerState state, Request request) {
        Response response = null;
        
        if( request == null) {
            response = new Error(Error.ERROR_EMPTY_REQUEST);
        }
        else if (request instanceof AlbumList) {
            response = new edu.cs2335.lab5.protocol.responses.AlbumList();
        }
        else if( request instanceof Authentication) {
            Authentication auth = (Authentication) request;
            String username;
            
            username = auth.getUsername();
//          private List getUserList() {
//          List users = new Vector();
//      
            FileSystemView fileSystem = FileSystemView.getFileSystemView();
            File[] userFiles =
                fileSystem.getFiles(new File(DATA_DIR), false);
//      
//          for (int i = 0; i < userFiles.length; ++i) {
//              if (userFiles[i].isDirectory()) {
//                  users.add(userFiles[i].getName());
//              }
//          }
//      
//          return users;
//      }
            
            response = new edu.cs2335.lab5.protocol.responses.Authentication(false, false, false);
        }
        else if (request instanceof Checkin) {
            response = new edu.cs2335.lab5.protocol.responses.Checkin(false);
        }
        else if (request instanceof Checkout) {
            response = new edu.cs2335.lab5.protocol.responses.Checkout(false);
        }
        else if (request instanceof CreateAlbum) {
            response = new edu.cs2335.lab5.protocol.responses.CreateAlbum(false);
        }
        else if (request instanceof RemoveAlbum) {
            response = new edu.cs2335.lab5.protocol.responses.RemoveAlbum(false);
        }
        else if (request instanceof SaveAlbum) {
            response = new edu.cs2335.lab5.protocol.responses.SaveAlbum(false);
        }
        else if (request instanceof ViewAlbum) {
            response = new edu.cs2335.lab5.protocol.responses.ViewAlbum(null, false, null);
        }
        else {
            System.err.println("AlbumManager Error: request invalid!");
            response =  new Error(Error.ERROR_INVALID_REQUEST);
        }
        return response;
    }

}
