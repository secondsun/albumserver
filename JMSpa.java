package edu.cs2335.lab5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* *************************************
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
* for this machine, so Jigloo or this code cannot be used legally
* for any corporate or commercial purpose.
* *************************************
*/
public final class JMSpa extends JFrame implements ActionListener {
    
    private Driver driver;
    
    private JSplitPane mainSplitPane;
	private JSplitPane leftSplitPane;
	private JPanel localPhotoPanel;
	private JScrollPane localPhotoScrollPane;
	private JMenuItem importLocalPhotosMenuItem;
	private JMenu fileMenu;
	private JMenuBar mainMenuBar;
	private JLabel slideshowListLabel;
	private JSplitPane rightSplitPane;
	private JPanel slideshowListPanel;

    public JMSpa() {
    		super("JMSpa");
            setSize(900, 700);
            
            // mgb: center
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            setLocation((dim.width - getWidth()) / 2,
                (dim.height - getHeight()) / 2);
            
            BorderLayout thisLayout = new BorderLayout();
            this.getContentPane().setLayout(thisLayout);
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            {
                mainSplitPane = new JSplitPane();
                this.getContentPane().add(mainSplitPane, BorderLayout.CENTER);
                mainSplitPane.setDividerSize(2);
                mainSplitPane.setDividerLocation(200);
                {
                    leftSplitPane = new JSplitPane();
                    mainSplitPane.add(leftSplitPane, JSplitPane.LEFT);
                    leftSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
                    leftSplitPane.setDividerSize(2);
                    leftSplitPane.setDividerLocation(100);
                    leftSplitPane.setFocusCycleRoot(true);
                    leftSplitPane.setMinimumSize(new java.awt.Dimension(200, 600));
                    {
                        slideshowListPanel = new JPanel();
                        leftSplitPane.add(slideshowListPanel, JSplitPane.LEFT);
                        slideshowListPanel.setMinimumSize(new java.awt.Dimension(200, 100));
                        {
                            slideshowListLabel = new JLabel();
                            slideshowListPanel.add(slideshowListLabel);
                            slideshowListLabel.setText("Slideshow List Panel");
                        }
                    }
                    {
                        localPhotoScrollPane = new JScrollPane();
                        leftSplitPane.add(
                            localPhotoScrollPane,
                            JSplitPane.RIGHT);
                        {
                            localPhotoPanel = new JPanel();
                            GridBagLayout jPanel2Layout = new GridBagLayout();
                            localPhotoPanel.setBackground(new java.awt.Color(255,255,255));
                            localPhotoPanel.setLayout(jPanel2Layout);
                            localPhotoScrollPane
                                .setViewportView(localPhotoPanel);
                        }
                    }
                    {
                    }
                }
                {
                    rightSplitPane = new JSplitPane();
                    mainSplitPane.add(rightSplitPane, JSplitPane.RIGHT);
                    rightSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
                    rightSplitPane.setDividerSize(2);
                }
            }
            {
                mainMenuBar = new JMenuBar();
                setJMenuBar(mainMenuBar);
                {
                    fileMenu = new JMenu();
                    mainMenuBar.add(fileMenu);
                    fileMenu.setText("File");
                    {
                        importLocalPhotosMenuItem = new JMenuItem();
                        fileMenu.add(importLocalPhotosMenuItem);
                        importLocalPhotosMenuItem
                            .setText("Import Local Photos...");
                            importLocalPhotosMenuItem.addActionListener(this);
                    }
                }
            }
            
            driver = new Driver(this);
    	}

    /**
     * Get local photo panel
     * 
     * @return Returns the localPhotoPanel.
     */
    protected JPanel getLocalPhotoPanel() {
        return localPhotoPanel;
    }

    /**
     * Get local photo scroll pane
     * 
     * @return Returns the localPhotoScrollPane.
     */
    protected JScrollPane getLocalPhotoScrollPane() {
        return localPhotoScrollPane;
    }
    
    /**
     * Implemented method from ActionListener to handle all actions
     * from this Frame
     * 
     * @see java.awt.event.ActionListener
     */
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().compareTo("Import Local Photos...") == 0) {
            
            // mgb: prompt user for input
            JFileChooser chooser = new JFileChooser();
//            chooser.setFont(Constants.SANS_SERIF_FONT);
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setMultiSelectionEnabled(true);
            
            int ret = chooser.showOpenDialog(this);
            if(ret == JFileChooser.APPROVE_OPTION) {
                
                localPhotoPanel.removeAll();
                localPhotoScrollPane.validate();
                repaint();
                
                driver.importLocalPhotos(chooser.getSelectedFiles());
            }

        }        
    }
    
    /**
     * Overloaded paint method to implement proper split pane constraints
     * 
     * @see java.awt.Component
     */
    public void paint(Graphics g) {
        Dimension d;
        
        d = leftSplitPane.getMinimumSize();
        rightSplitPane.setMinimumSize(
                new Dimension(getWidth() - (d.width + 100), 600));
        
        d = slideshowListPanel.getMinimumSize();
        localPhotoScrollPane.setMinimumSize(
                new Dimension(200, getHeight() - (d.height + 200)));
                
        super.paint(g);
    }

    /**
    * Main
    */
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JMSpa app = new JMSpa();
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
                    SwingUtilities.updateComponentTreeUI(app);
                } catch (Exception e) {
                    // mgb: not much we can do but continue
                    System.gc();
                }
                app.setVisible(true);
            }
        });
    }
    
}
