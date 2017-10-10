package edu.cs2335.lab5;

import java.awt.datatransfer.Transferable;

import javax.swing.JComponent;
import javax.swing.TransferHandler;

/**
 * @author mgbowman
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class LocalPhotoTransferHandler extends TransferHandler {

    public Transferable createTransferable(JComponent c) {
        return new LocalPhotoTransferable((LocalPhoto)c);
    }
    
    public int getSourceActions(JComponent c) {
        return TransferHandler.COPY;
    }
    
}
