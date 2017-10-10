package edu.cs2335.lab5;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.File;
import java.util.List;
import java.util.Vector;

import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileSystemView;

/**
 * @author mgbowman
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public final class Driver {
    
    private JMSpa owner;
    private WorkingDialog workingDialog;
    
    protected Driver(JMSpa owner) {
        this.owner = owner;
    }
    
    private class ShowWorkingDialog implements Runnable {
        
        private JMSpa owner;
        private String message;
        private int maximum;
        private boolean indeterminate;
        
        public ShowWorkingDialog(JMSpa owner, String message, int maximum,
                boolean indeterminate) {
            this.owner = owner;
            this.message = message;
            this.maximum = maximum;
            this.indeterminate = indeterminate;
        }
        
        public void run() {
            workingDialog = new WorkingDialog(owner,message,maximum,indeterminate);
        }
        
    }
    
    private class ImportLocalPhotos implements Runnable {
        
        private static final int INSET = 5;
        private File[] chosen;
        
        public ImportLocalPhotos(File[] chosen) {
            this.chosen = chosen;
        }
        
        public void run() {

            waitCursor();
            
            final List photoFiles = new Vector();
            
            // mgb: count all image files for progress bar
            for (int i = 0; i < chosen.length; ++i) {
                FileSystemView fileSystem = FileSystemView.getFileSystemView();
                File[] localFiles = fileSystem.getFiles(chosen[i], false);
                
                for(int j = 0; j < localFiles.length; ++j) {
                    String localFileName = localFiles[j].getName();
                    String localFileNameTokens[] = localFileName.split("\\.");
                    String localFileExtension = new String();
                    
                    try {
                        localFileExtension =
                            localFileNameTokens[localFileNameTokens.length - 1];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        // mgb: no '.' in the filename
                        System.gc(); // why not? ^_^
                    }
                    
                    if (localFileExtension.compareToIgnoreCase("jpg") == 0 ||
                            localFileExtension.compareToIgnoreCase("gif") == 0 ||
                                    localFileExtension.compareToIgnoreCase("png") == 0) {
                        photoFiles.add(chosen[i] + "/" + localFileName);
                    }
                }
            }
            
            // mgb: open working dialog
            SwingUtilities.invokeLater(new ShowWorkingDialog(owner, "Importing Local Photos...",
                    photoFiles.size(), false));

            for (int i = 0; i < photoFiles.size(); ) {
                GridBagConstraints c = new GridBagConstraints();
                c.insets = new Insets(INSET, INSET, INSET, INSET);
                c.gridx = 0;
                c.gridy = i;
                
                // mgb: create new local photo object and add to panel
                LocalPhoto photo = new LocalPhoto((String) photoFiles.get(i));
                if(photo.isSuccessful()){
                    owner.getLocalPhotoPanel().add(photo, c);
                } else {
                    // mgb: error loading photo
                    // TODO implement error dialog
                }
                
                // mgb: update progress bar if instantiated
                if (workingDialog != null) {
                    workingDialog.updateProgressBarValue(++i);
                }
            }
            
            // mgb: repaint
            owner.getLocalPhotoScrollPane().validate();
            owner.repaint();

            // mgb: close working dialog
            if(workingDialog != null) {
                workingDialog.dispose();
                workingDialog = null;
            }
            
            readyCursor();
        }
    }

    protected void importLocalPhotos(File[] chosen) {
        // mgb: open working dialog
        new Thread(new ImportLocalPhotos(chosen), "ImportLocalPhotos").start();
    }
    
    protected void waitCursor() {
        Component[] c = owner.getComponents();
        for(int i = 0; i < c.length; ++i) {
            c[i].setCursor(Constants.WAIT_CURSOR);
        }
    }
    
    protected void readyCursor() {
        Component[] c = owner.getComponents();
        for(int i = 0; i < c.length; ++i) {
            c[i].setCursor(Constants.READY_CURSOR);
        }
    }
    
}
