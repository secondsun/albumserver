/*
 * Created on Sep 27, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package edu.cs2335.lab5.server;

import java.io.IOException;
import java.net.ServerSocket;

import edu.cs2335.lab5.server.AlbumServerThread;

/**
 * @author jeff
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AlbumServer {


    
    public AlbumServer(int port) throws IOException {
        ServerSocket socket = null;
        boolean listening = true;
        
        socket = new ServerSocket(port);
        
        while (listening) {

            new AlbumServerThread(socket.accept()).start();
        }
        socket.close();
    }
    
//    public static final String DATA_DIR = "data"; 
    /**
     * @return list of users (each is a subdir of DATA_DIR)
     * @throws IOException
     */
//    private List getUserList() {
//        List users = new Vector();
//    
//        FileSystemView fileSystem = FileSystemView.getFileSystemView();
//        File[] userFiles =
//            fileSystem.getFiles(new File(DATA_DIR), false);
//    
//        for (int i = 0; i < userFiles.length; ++i) {
//            if (userFiles[i].isDirectory()) {
//                users.add(userFiles[i].getName());
//            }
//        }
//    
//        return users;
//    }

    public static void main(String[] args) throws IOException {
        AlbumServer server = new AlbumServer(2969);
    }

}