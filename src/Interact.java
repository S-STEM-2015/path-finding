import java.awt.*;
import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;

public class Interact
{
    private JFrame frame;
    private JPanel jpTop;
    private JPanel jpBottom;
    private JPanel jpPlayer;
    private JPanel jpButton;
    private JPanel jpOpFor;

    private static final int[] LEVEL = new int[]{1, 2, 3, 4, 5}; 
    private static final double[] TACIT_LEVEL = new double[]{0.1, 0.08, 
        0.06, 0.04, 0.02};
    private static ArrayList<Items> equipped;
    private static ArrayList<Items> bestiary;
    private static Queue<Integer> interaction = new LinkedList<Integer>();
    private static Player thisPlayer;
    private static Monster monster;

    public Interact()
    {
        frame = new JFrame();
        frame.setLocation(100, 100);
        frame.setSize(400, 400);
        frame.setTitle("Interact");

        //instantiates button and result panels
        jpTop = new JPanel();
        jpBottom = new JPanel(new BorderLayout());
        jpPlayer = new JPanel();
        jpButton = new JPanel();
        jpOpFor = new JPanel();

        initComponents();

        thisPlayer = new Player();
        monster = new Monster();
        
        battlePhase();
        
    }

    public void battlePhase()
    {
        frame.setVisible(true);
    }

    /**
     * This method initializes elements of the the battle phase, 
     * not limited to buttons and panels. 
     */
    public void initComponents()
    {
    
        String test = "HP     999";
        String test2 = "Monster    999";

        //Instantiates result label & sets its name
        
        GridLayout jlayRows = new GridLayout(4,0);

        JLabel playerInfo = new JLabel(test); 
        JLabel opForInfo = new JLabel(test2);

        playerInfo.setVerticalAlignment(SwingConstants.CENTER);
        opForInfo.setVerticalAlignment(SwingConstants.CENTER); 

        playerInfo.setName("Player Stats");
        opForInfo.setName("Enemy Stats");

        //Adds result label to 'jpTop' panel

        
        jpPlayer.add(playerInfo);
        jpOpFor.add(opForInfo);

        jpBottom.add(jpPlayer, BorderLayout.LINE_START);
        jpBottom.add(jpButton, BorderLayout.CENTER);
        jpBottom.add(jpOpFor, BorderLayout.LINE_END);

        //assigns "GridLayout" to panels
        jpButton.setLayout(jlayRows);
 
        //Instantiates buttons & assigns their names
        JButton jButton0 = new JButton("Attack");
        JButton jButton1 = new JButton("Blizzard");
        JButton jButton2 = new JButton("Discern");
        JButton jButton3 = new JButton("Heal");

        jButton0.setName("Attack");
        jButton1.setName("Thundera");
        jButton2.setName("Blizzera");
        jButton3.setName("Heal");

        /*//Assigns ActionListener inner classes to buttons
	        jButton0.addActionListener(new InnerAdd());
	        jButton1.addActionListener(new InnerSub());
	        jButton2.addActionListener(new InnerMult());
	        jButton3.addActionListener(new InnerDiv());*/

        //Adds buttons to 'button' panel
        jpButton.add(jButton0);
        jpButton.add(jButton1);
        jpButton.add(jButton2);
        jpButton.add(jButton3);
        
        

        //Adds buttons and result panels to frame
        frame.add(jpTop, BorderLayout.CENTER);
        frame.add(jpBottom, BorderLayout.PAGE_END);
    }
    
    public static void main(String[] args)
    {
        new Interact();
    }

}



//Getters and Setters

