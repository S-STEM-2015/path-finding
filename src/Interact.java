import java.awt.*;

import javax.swing.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Vector;

public class Interact
{
    private JFrame frame;
    private Player player = new Player(); ;
    private Monster monster = new Monster();
    private Codex codex = new Codex();

    public Interact()
    {
        frame = new JFrame();
        frame.setLocation(100, 100);
        frame.setSize(400, 400);
        frame.setTitle("Interact");

        //instantiates button and result panels
        initComponents();
        battlePhase();

    }

    public void battlePhase()
    {
        frame.setVisible(true);
    }

    /**
     * Serves to test statistic parameters. 
     */
    public static void battleDiag()
    {
        double hp = 0;
        double ap = 0;
        double mana = 0;
        double mr;
        double ad;
        double surge;

        for (int level = 10; level > 0; level--)
        {
            surge = ((2 * level) / (Math.pow(Math.E, level))) + 0.2;
            hp =  1000 * surge;
            ap =  100 * surge;
            mana = 500 * surge;
            mr = 60 * surge;
            ad = 40 * surge;

            System.out.println("Level  " + (11 - level) + " HP: " + hp);
            System.out.println("\t" + " Mana: " + mana);
            System.out.println("\t" + " AP: " + ap);
            System.out.println("\t" + " MR: " + mr);
            System.out.println("\t" + " AD: " + ad);

            System.out.println();
        }

        Player arwen = new Player("Arwen", 5);
        System.out.println(arwen.getName() + " (Level " + arwen.getLvl() + "): "
            + arwen.getHealth());
    }

    /**
     * This method initializes elements of the the battle phase, 
     * not limited to buttons and panels. 
     */
    public void initComponents()
    {

        String test = "PLAYER";
        String test2 = "FURGLE";

        JPanel jpTop = new JPanel();
        JPanel jpBottom = new JPanel();
        JPanel jpPlayer = new JPanel();
        JPanel jpButton = new JPanel();
        JPanel jpOpFor = new JPanel();

        //Instantiates result label & sets its name

        JLabel playerInfo = new JLabel(test); 
        JLabel opForInfo = new JLabel(test2);

        playerInfo.setName("Player Stats");
        opForInfo.setName("Enemy Stats");

        //Adds result label to 'jpTop' panel


        jpPlayer.add(playerInfo);
        jpOpFor.add(opForInfo);

        jpBottom.add(jpPlayer);
        jpBottom.add(jpButton);
        jpBottom.add(jpOpFor);

        //assigns "GridLayout" to panels
        jpButton.setLayout(new GridLayout(4,0));
        jpPlayer.setLayout(new GridLayout(4,0));
        setCalignment(playerInfo);

        jpOpFor.setLayout(new GridLayout(4,0));
        setCalignment(opForInfo);

        jpBottom.setLayout(new GridLayout(0,3));

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

    public class Codex {
        private ArrayList<Monster> bestiary = new ArrayList<Monster>();

        public Codex() {
        }

        public void addMonster(Monster e)
        {
            bestiary.add(e);
        }
    }

    public void setCalignment(JLabel b) {
        b.setHorizontalAlignment(JLabel.CENTER);
        b.setVerticalAlignment(JLabel.CENTER);
    }

    public static void main(String[] args)
    {
        //new Interact();
        battleDiag();
    }

}



//Getters and Setters

