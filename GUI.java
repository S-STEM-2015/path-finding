
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

 
public class trialrun {
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
 
    public static void addComponentsToPane(Container pane) 
    {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
 
        addPathButton(c, pane);
        
        addRestartButton(c, pane);
        
        addPlayerStats(c, pane);
    
        addEnemyStats(c, pane);
        
        addGrid(c, pane, 25, 25);
    }
    
    public static void addPathButton(GridBagConstraints c, Container pane)
    {
        JButton button = new JButton("Show Best Path");
        c.weightx = 0.5;
        c.ipady = 50;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        pane.add(button, c);
    }
    
    public static void addRestartButton(GridBagConstraints c, Container pane)
    {
        JButton button = new JButton("Restart");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 50;
        c.gridx = 1;
        c.gridy = 0;
        pane.add(button, c);
    }
    
    public static void addGrid(GridBagConstraints c, Container pane, int height, int width)
    {
        JPanel panel = new JPanel();
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 1.0;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 1;
        panel.setLayout(new GridLayout(height, width));
        
        pane.add(panel, c);
        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                JPanel subpanel = new JPanel();
                subpanel.setBorder(BorderFactory.createLineBorder(Color.black));
                panel.add(subpanel);
            }
        }
        
    }
    
    public static void addPlayerStats(GridBagConstraints c, Container pane)
    {
        JButton button = new JButton("Player Stat:");
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 250;
        c.gridx = 0;
        c.gridy = 2;
        pane.add(button, c);
    }
    
    public static void addEnemyStats(GridBagConstraints c, Container pane)
    {
        JButton button = new JButton("Enemy Stats:");
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 250;
        c.gridx = 1;
        c.gridy = 2;
        pane.add(button, c);
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("GridBagLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,1000);
        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());
 
        //Display the window.
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
