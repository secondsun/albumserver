/*
 * Created on Sep 29, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package edu.cs2335.lab5.server;

/**
 * @author jeff
 *
 * This is a structure-like class, and can have public members
 */
public class AlbumManagerState {
    public static final int ACCESS_NONE = 0;
    public static final int ACCESS_READ = 1;
    public static final int ACCESS_READWRITE = 2;
    
    public String profile = "";
    public int accessState = ACCESS_NONE;
    public int activeAlbumNumber = 0;
}
