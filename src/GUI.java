import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.event.*;
import java.util.ArrayList;
 
public class GUI implements ActionListener
{
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    public static JPanel panel;
    public static int playerPositionX = 1;
    public static int playerPositionY = 1;
    public static JPanel[][] grid;
    public static int dungeon[][];
    public static pathfinder finder;
    
    public GUI(pathfinder finder)
    {
    	this.finder = finder;
    }
    
    public void createGUI(){
    	//Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //createAndShowGUI();
            }
        });
    }
    
    public static void addComponentsToPane(Container pane, int[][] board) 
    {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
 
        addPathButton(c, pane);
        
        addUpMoveButton(c, pane);
        
        addDownMoveButton(c, pane);
        
        addLeftMoveButton(c, pane);
        
        addRightMoveButton(c, pane);
        
        addRestartButton(c, pane);
        
        addPlayerStats(c, pane);
    
        addEnemyStats(c, pane);
        
        addGrid(c, pane, 10, 10);
    }
    
    public static void addPathButton(GridBagConstraints c, Container pane)
    {
        JButton button = new JButton("Show Best Path");
        c.weightx = 0.5;
        c.ipady = 20;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO Auto-generated method stub
            	ArrayList<path> thePath = finder.getMainList();
            	for(int i = 0; i<thePath.size(); i++)
            	{
            		path obj = thePath.get(i);
            		dungeon[obj.getX()][obj.getY()] = 6;
            		grid[obj.getX()][obj.getY()].setBackground(new Color(102,204,255));
            	}
  
            }
            
        });
        
        pane.add(button, c);
    }
    
    public static void addRestartButton(GridBagConstraints c, Container pane)
    {
        JButton button = new JButton("Restart");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 20;
        c.gridx = 1;
        c.gridy = 0;
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	for(int i = 0; i<dungeon.length; i++)
            	{
            		for(int j = 0; j < dungeon[i].length; j++)
            		{
            			if(dungeon[i][j] == 0){//walls
            				grid[i][j].setBackground(Color.black);
                        }
                        else if(dungeon[i][j] == 1){//path
                        	grid[i][j].setBackground(new Color(216,214,215));
                        }
                        else if(dungeon[i][j] == 2){
                        	grid[i][j].setBackground(new Color(94,41,218));
                        }             
                        else if(dungeon[i][j] == 3 || dungeon[i][j] == 4){//start and end points
                        	grid[i][j].setBackground(new Color(00, 255, 00));
                        	playerPositionX = 1;//reset player position
                            playerPositionY = 0;
                        	grid[i][j].setBackground(new Color(94,41,218));
                        }
            		}
            	}
  
            }
            
        });
        
        pane.add(button, c);
    }
    
    public static void addGrid(GridBagConstraints c, final Container pane, int hei, int wid) 
    {
        grid = new JPanel[dungeon.length][dungeon[0].length];
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++)
            {
                grid[i][j] = new JPanel();
            }
        }
        panel = new JPanel();
        
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 1.0;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 3;
        int height =dungeon.length;
        int width =dungeon[1].length;
        panel.setLayout(new GridLayout(height, width));
        
        
        
        pane.add(panel, c);
        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                JPanel subpanel = new JPanel();
                //subpanel.setBorder(BorderFactory.createLineBorder(Color.black));
                if(dungeon[i][j] == 0){
                	subpanel.setBackground(Color.black);
                }
                else if (dungeon[i][j] == 5)
                {
                    subpanel.setBackground(new Color(00, 255, 00));
                }
                else if(dungeon[i][j] == 1){
                	subpanel.setBackground(new Color(216,214,215));
                }
                else if(dungeon[i][j] == 3){
                	subpanel.setBackground(new Color(00, 255, 00));
                }             
                else if(dungeon[i][j] == 4){
                	subpanel.setBackground(new Color(94,41,218));
                }
                
                grid[i][j] = subpanel;
                panel.add(subpanel, c);
            }
        }
        
        
    }
    
    public static void addUpMoveButton(GridBagConstraints c, Container pane)
    {
        JButton buttonUp = new JButton("UP");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.ipady = 10;
        c.gridy = 1;
        buttonUp.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO Auto-generated method stub
                if (playerPositionY - 1 > -1 && dungeon[playerPositionY - 1][playerPositionX] != 0)
                {

                    grid[playerPositionY][playerPositionX].setBackground(new Color(00, 255, 00));
                    
                }
                
                
            }
            
        });
        pane.add(buttonUp, c);
    }
    
    public static void addDownMoveButton(GridBagConstraints c, Container pane)
    {
        JButton buttonDown = new JButton("DOWN");
        
        buttonDown.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO Auto-generated method stub
                if (playerPositionY + 1 < dungeon[0].length && dungeon[playerPositionY + 1][playerPositionX] != 0)
                {

                    grid[playerPositionY][playerPositionX].setBackground(new Color(00, 255, 00));
                    
                }
                
                
            }
            
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.ipady = 10;
        c.gridy = 1;
        pane.add(buttonDown, c);
    }
    
    public static void addLeftMoveButton(GridBagConstraints c, Container pane)
    {
        JButton buttonLeft = new JButton("LEFT");
        
        buttonLeft.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO Auto-generated method stub
                if (playerPositionX - 1>-1 && dungeon[playerPositionY][playerPositionX - 1] != 0)
                {
                    grid[playerPositionY][playerPositionX - 1].setBackground(new Color(00, 255, 00));
                    dungeon[playerPositionY][playerPositionX - 1] = 5;
                    grid[playerPositionY][playerPositionX].setBackground(new Color(216, 214, 215));
                    dungeon[playerPositionY][playerPositionX] = 1;
                    playerPositionX -= 1;
                    //createAndShowGUI(dungeon);
                }
                
                
            }
            
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.ipady = 10;
        c.gridy = 2;
        pane.add(buttonLeft, c);
    }
    
    public static void addRightMoveButton(GridBagConstraints c, Container pane)
    {
        JButton buttonRight = new JButton("RIGHT");
        
        buttonRight.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO Auto-generated method stub
                if (dungeon[playerPositionY][playerPositionX + 1] != 0)
                {
                    grid[playerPositionY][playerPositionX + 1].setBackground(new Color(00, 255, 00));
                    dungeon[playerPositionY][playerPositionX + 1] = 5;
                    grid[playerPositionY][playerPositionX].setBackground(new Color(216, 214, 215));
                    dungeon[playerPositionY][playerPositionX] = 1;
                    playerPositionX += 1;
                }
                
                
            }
            
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.ipady = 10;
        c.gridy = 2;
        pane.add(buttonRight, c);
    }
    
    public static void addPlayerStats(GridBagConstraints c, Container pane)
    {
        
      //Player Stats
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.BLACK));
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 150;
        c.gridx = 0;
        c.gridy = 4;

        JPanel pan = new JPanel();
        ImageIcon icon = new ImageIcon("image/person.jpg","User");
        JLabel label = new JLabel(icon,JLabel.LEFT);
        JLabel label2 = new JLabel("NAME",JLabel.CENTER);
        pan.setBorder(new LineBorder(Color.BLACK));
        pan.setPreferredSize( new Dimension( 300,45 ) );
        pan.add(label);
        pan.add(label2);
        
        JPanel pan1 = new JPanel();
        icon = new ImageIcon("image/plus.jpg","Health");
        label = new JLabel(icon,JLabel.LEFT);
        label2 = new JLabel("Health");
        pan1.setBorder(new LineBorder(Color.BLACK));
        pan1.setPreferredSize( new Dimension( 300,45 ) );
        pan1.add(label);
        pan1.add(label2);
        
        JPanel pan2 = new JPanel();
        icon = new ImageIcon("image/Diamond-Sword-icon.png","Attack");
        label = new JLabel(icon,JLabel.LEFT);
        label2 = new JLabel("Attack");
        pan2.setBorder(new LineBorder(Color.BLACK));
        pan2.setPreferredSize( new Dimension( 300,45 ) );
        pan2.add(label);
        pan2.add(label2);
        
        JPanel pan3 = new JPanel();
        icon = new ImageIcon("image/shield.png","Defense");
        label = new JLabel(icon,JLabel.LEFT);
        label2 = new JLabel("Defense");
        pan3.setBorder(new LineBorder(Color.BLACK));
        pan3.setPreferredSize( new Dimension( 300,45 ) );
        pan3.add(label);
        pan3.add(label2);
        
        panel.add(pan);
        panel.add(pan1);
        panel.add(pan2);
        panel.add(pan3);
        pane.add(panel,c);
    }
    
    public static void addEnemyStats(GridBagConstraints c, Container pane)
    {
    	//Enemy stats
        panel = new JPanel();
        panel.setBorder(new LineBorder(Color.BLACK));
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 150;
        c.gridx = 1;
        c.gridy = 4;

        JPanel pan = new JPanel();
        ImageIcon icon = new ImageIcon("image/villian1.gif","Enemy");
        JLabel label = new JLabel(icon,JLabel.LEFT);
        JLabel label2 = new JLabel("NAME",JLabel.CENTER);
        pan.setBorder(new LineBorder(Color.BLACK));
        pan.setPreferredSize( new Dimension( 300,45 ) );
        pan.add(label);
        pan.add(label2);
        
        JPanel pan1 = new JPanel();
        icon = new ImageIcon("image/plus.jpg","Health");
        label = new JLabel(icon,JLabel.LEFT);
        label2 = new JLabel("Health");
        pan1.setBorder(new LineBorder(Color.BLACK));
        pan1.setPreferredSize( new Dimension( 300,45 ) );
        pan1.add(label);
        pan1.add(label2);
        
        JPanel pan2 = new JPanel();
        icon = new ImageIcon("image/Diamond-Sword-icon.png","Attack");
        label = new JLabel(icon,JLabel.LEFT);
        label2 = new JLabel("Attack");
        pan2.setBorder(new LineBorder(Color.BLACK));
        pan2.setPreferredSize( new Dimension( 300,45 ) );
        pan2.add(label);
        pan2.add(label2);
        
        JPanel pan3 = new JPanel();
        icon = new ImageIcon("image/shield.png","Defense");
        label = new JLabel(icon,JLabel.LEFT);
        label2 = new JLabel("Defense");
        pan3.setBorder(new LineBorder(Color.BLACK));
        pan3.setPreferredSize( new Dimension( 300,45 ) );
        pan3.add(label);
        pan3.add(label2);
        
        panel.add(pan);
        panel.add(pan1);
        panel.add(pan2);
        panel.add(pan3);
        pane.add(panel,c);
        
    }
    
    public static void changeColor(int x, int y,int length, Color c)
    {
        int n = ((x * length) - 1) + y;
        panel.getComponent(n).setBackground(c);
        panel.getComponent(10).setBackground(Color.RED);
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public static void createAndShowGUI(int[][] board) {
        //Create and set up the window.
        JFrame frame = new JFrame("name to be determined");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,1000);
        //Set up the content pane.
        dungeon = board;
        addComponentsToPane(frame.getContentPane(),board);
        
        //Display the window.
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // TODO Auto-generated method stub
        
    }
    
 
}