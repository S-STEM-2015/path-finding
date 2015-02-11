import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
 
public class trialrun {
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
 
    public static void addComponentsToPane(Container pane) {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
 
    JButton button;
    pane.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    
    if (shouldFill) {
    //natural height, maximum width
    c.fill = GridBagConstraints.HORIZONTAL;
    }
 
    button = new JButton("Show Best Path");
    if (shouldWeightX) {
    c.weightx = 0.5;
    }
    c.ipady = 50;
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 0;
    pane.add(button, c);
 
    button = new JButton("Restart");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.ipady = 50;
    c.gridx = 1;
    c.gridy = 0;
    pane.add(button, c);
    
    //Player Stats
    JPanel panel = new JPanel();
    panel.setBorder(new LineBorder(Color.BLACK));
    c.fill = GridBagConstraints.BOTH;
    c.ipady = 250;
    c.gridx = 0;
    c.gridy = 2;

    JPanel pan = new JPanel();
    ImageIcon icon = new ImageIcon("image/person.jpg","User");
    JLabel label = new JLabel(icon,JLabel.LEFT);
    JLabel label2 = new JLabel("NAME",JLabel.CENTER);
    pan.setBorder(new LineBorder(Color.BLACK));
    pan.setPreferredSize( new Dimension( 300,70 ) );
    pan.add(label);
    pan.add(label2);
    
    JPanel pan1 = new JPanel();
    icon = new ImageIcon("image/plus.jpg","Health");
    label = new JLabel(icon,JLabel.LEFT);
    label2 = new JLabel("Health");
    pan1.setBorder(new LineBorder(Color.BLACK));
    pan1.setPreferredSize( new Dimension( 300,70 ) );
    pan1.add(label);
    pan1.add(label2);
    
    JPanel pan2 = new JPanel();
    icon = new ImageIcon("image/Diamond-Sword-icon.png","Attack");
    label = new JLabel(icon,JLabel.LEFT);
    label2 = new JLabel("Attack");
    pan2.setBorder(new LineBorder(Color.BLACK));
    pan2.setPreferredSize( new Dimension( 300,70 ) );
    pan2.add(label);
    pan2.add(label2);
    
    JPanel pan3 = new JPanel();
    icon = new ImageIcon("image/shield.png","Defense");
    label = new JLabel(icon,JLabel.LEFT);
    label2 = new JLabel("Defense");
    pan3.setBorder(new LineBorder(Color.BLACK));
    pan3.setPreferredSize( new Dimension( 300,70 ) );
    pan3.add(label);
    pan3.add(label2);
    
    panel.add(pan);
    panel.add(pan1);
    panel.add(pan2);
    panel.add(pan3);
    pane.add(panel,c);
    
    //Enemy stats
    panel = new JPanel();
    panel.setBorder(new LineBorder(Color.BLACK));
    c.fill = GridBagConstraints.BOTH;
    c.ipady = 250;
    c.gridx = 1;
    c.gridy = 2;

    pan = new JPanel(new FlowLayout(FlowLayout.LEFT));
    icon = new ImageIcon("image/villian1.gif","Enemy");
    label = new JLabel(icon,JLabel.LEFT);
    label2 = new JLabel("NAME",JLabel.CENTER);
    pan.setBorder(new LineBorder(Color.BLACK));
    pan.setPreferredSize( new Dimension( 300,70 ) );
    pan.add(label);
    pan.add(label2);
    
    pan1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    icon = new ImageIcon("image/plus.jpg","Health");
    label = new JLabel(icon,JLabel.LEFT);
    label2 = new JLabel("Health");
    pan1.setBorder(new LineBorder(Color.BLACK));
    pan1.setPreferredSize( new Dimension( 300,70 ) );
    pan1.add(label);
    pan1.add(label2);
    
    pan2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    icon = new ImageIcon("image/Diamond-Sword-icon.png","Attack");
    label = new JLabel(icon,JLabel.LEFT);
    label2 = new JLabel("Attack");
    pan2.setBorder(new LineBorder(Color.BLACK));
    pan2.setPreferredSize( new Dimension( 300,70 ) );
    pan2.add(label);
    pan2.add(label2);
    
   pan3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    icon = new ImageIcon("image/shield.png","Defense");
    label = new JLabel(icon,JLabel.LEFT);
    label2 = new JLabel("Defense");
    pan3.setBorder(new LineBorder(Color.BLACK));
    pan3.setPreferredSize( new Dimension( 300,70 ) );
    pan3.add(label);
    pan3.add(label2);
    
    panel.add(pan);
    panel.add(pan1);
    panel.add(pan2);
    panel.add(pan3);
    pane.add(panel,c);
    
 
    button = new JButton("Grid");
    c.fill = GridBagConstraints.BOTH;
    c.weighty = 1.0;
    c.gridwidth = 2;
    c.gridx = 0;
    c.gridy = 1;
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