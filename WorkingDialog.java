package edu.cs2335.lab5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.BevelBorder;

/**
 * Working Dialog to display either communication with a server 
 * or to display communication with the local HDD.
 *
 * @author gtg763m
 */
public final class WorkingDialog extends JDialog {
    /** width constant for this dialog */
    private static final int WIDTH = 500;

    /** height constant for this dialog */
    private static final int HEIGHT = 50;

    /** owner of this dialog */
    private final JMSpa owner;

    /** progress bar to display in this dialog */
    private final JProgressBar progressBar;

    /**
     * Creates a new WorkingDialog object.
     *
     * @param owner of this dialog
     * @param message to display
     * @param maximum value of the progress bar
     * @param indeterminate boolean determining is progress bar indeterminate
     */
    public WorkingDialog(JMSpa owner, String message, int maximum,
        boolean indeterminate) {
        super(owner);
        this.owner = owner;

        getContentPane().setLayout(new BorderLayout());
        setUndecorated(true);
        setSize(WIDTH, HEIGHT);

        final JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEtchedBorder(
                BevelBorder.LOWERED, null, null));

        mainPanel.setBackground(new Color(255, 255, 255));
        mainPanel.setLayout(new GridBagLayout());
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 0, 0, 25);
        c.anchor = GridBagConstraints.WEST;

        final JLabel headerLabel = new JLabel();
        headerLabel.setText(message);
        headerLabel.setFont(Constants.SANS_SERIF_FONT);
        mainPanel.add(headerLabel, c);

        // mgb: constraints above still active
        c.gridx = 1;
        c.insets = new Insets(0, 25, 0, 0);

        progressBar = new JProgressBar(0, maximum);
        progressBar.setStringPainted(true);
        progressBar.setString("0%");
        progressBar.setIndeterminate(indeterminate);
        mainPanel.add(progressBar, c);

        // mgb: center
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dim.width - getWidth()) / 2,
            (dim.height - getHeight()) / 2);

        setVisible(true);
    }

    /**
     * Updates the progress bar based off the given parameters.
     *
     * @param value to update the progress bar with
     */
    protected void updateProgressBarValue(int value) {
        progressBar.setString((int)
                ((double) value / progressBar.getMaximum() * 100) + "%");
        progressBar.setValue(value);
    }
}
