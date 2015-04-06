import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Interact implements ActionListener
{
    private JFrame frame;
    private ArrayList<JLabel> jl = new ArrayList<JLabel>();
    private JPanel pane0 = new JPanel();
    private JPanel pane1 = new JPanel();
    private JPanel pane2 = new JPanel();
    private Player player;
    private Monster monster;

    public Interact()
    {
        this.player = new Player("Melkor", 2);
        this.setmonster(new Monster());
        
        initComponents();

    }

    public void battlePhase()
    {
    }
    
    /**
     * This method initializes elements of the the battle phase, 
     * not limited to buttons and panels. 
     */
    public void initComponents()
    {
        frame = new JFrame();
        frame.setLayout(new GridLayout(3,0,8,8));
        getPane0().setLayout(new GridLayout(0,1));
        getPane1().setLayout(new GridLayout(0,1));
        getPane2().setLayout(new GridLayout(0,2));
        frame.setLocation(100, 100);
        frame.setSize(400, 400);
        frame.setTitle("Interact");
        
        addDisplay();
        addStats();
        addButtons();
        
        frame.add(getPane0());
        frame.add(getPane1());
        frame.add(getPane2());
        frame.setVisible(true);
    }
    
    public void addStats()
    {
        JPanel jpPs = new JPanel(new GridLayout(4, 0));
        JPanel jpMs = new JPanel(new GridLayout(4, 0));
        
        jl.add(new JLabel(player.getName() + " (Level " 
            + player.getLevel() + ")", JLabel.CENTER)); 
        
        jl.add(new JLabel(" EXP   " 
            + Integer.toString(player.getExp()) 
            + " / " + Entity.EXP_CAP + "   "));
        
        jl.add(new JLabel(" HP    " 
            + Integer.toString(player.getHealth()) 
            + " / " 
            + Integer.toString(player.getMaxHealth()) + " "));
        
        jl.add(new JLabel(" Mana  " 
            + Integer.toString(player.getMana())
            + " / " + Integer.toString(player.getMaxMana()) 
            + " "));
        
        jl.add(new JLabel(monster.getName(), JLabel.CENTER));
        jl.add(new JLabel(" HP    ??? / ???", JLabel.CENTER));
        jl.add(new JLabel(" Mana  ??? / ???", JLabel.CENTER));
        jl.add(new JLabel(">>", JLabel.CENTER));
        
        
        for (int i = 0; i < 4; i++)
        {
            jpPs.add(jl.get(i));
            jpMs.add(jl.get(i + 4));
        }
        
        getPane1().add(jpMs);
        getPane2().add(jpPs);
        
    }
 
    
    public void addButtons()
    {
        JPanel jpB = new JPanel();
        
        JButton attack = new JButton("ATTACK");
        
        attack.addActionListener(new ActionListener()
        { 
            int counter = 0;
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO Auto-generated method stub
                
                if (counter < 4)
                {
                    jl.get(7).setText(jl.get(7).getText() + "  [ATTACK]  ");
                    counter++;
                }
                
            }

        });
       
        JButton blizzard = new JButton("BLIZZARD");
        
        blizzard.addActionListener(new ActionListener()
        { 
            int counter = 0;
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO Auto-generated method stub
                
                if (counter < 4)
                {
                    jl.get(7).setText(jl.get(7).getText() + "  [BLIZZARD]  ");
                    counter++;
                }
                
            }

        });
        
        JButton discern = new JButton("DISCERN");
        
        discern.addActionListener(new ActionListener()
        { 
            int counter = 0;
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO Auto-generated method stub
                
                if (counter < 4)
                {
                    jl.get(7).setText(jl.get(7).getText() + "  [DISCERN]  ");
                    counter++;
                }
                
            }

        });
        
        JButton heal = new JButton("HEAL");
        
        heal.addActionListener(new ActionListener()
        { 
            int counter = 0;
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO Auto-generated method stub
                
                if (counter < 4)
                {
                    jl.get(7).setText(jl.get(7).getText() + "  [HEAL]  ");
                    counter++;
                }
                
            }

        });
        
        jpB.setLayout(new GridLayout(4, 0));
        jpB.add(blizzard);
        jpB.add(attack);
        jpB.add(discern);
        jpB.add(heal);
        getPane2().add(jpB);
    }
    
    public void addDisplay()
    {
        JPanel jpD = new JPanel();
        jpD.setLayout(new GridLayout(0, 1,8,8));
        //ImageIcon icon = new ImageIcon("image/knight3-512.png","Player");
        ImageIcon icon2 = new ImageIcon("image/assassin2-512.png","Monster");
        //jpD.add(new JLabel(icon));
        jpD.add(new JLabel(icon2));
        
        getPane0().add(jpD);
 
    }

    public void setCalignment(JLabel b) {
        b.setHorizontalAlignment(JLabel.CENTER);
    }

    public static void main(String[] args)
    {
        new Interact();
    }
    
  //Getters and Setters

    public Player getplayer()
    {
        return player;
    }

    public void setplayer(Player player)
    {
        this.player = player;
    }

    public Monster getmonster()
    {
        return monster;
    }

    public void setmonster(Monster monster)
    {
        this.monster = monster;
    }

    public JPanel getPane0()
    {
        return pane0;
    }

    public void setPane0(JPanel pane0)
    {
        this.pane0 = pane0;
    }

    public JPanel getPane1()
    {
        return pane1;
    }

    public void setPane1(JPanel pane1)
    {
        this.pane1 = pane1;
    }

    public JPanel getPane2()
    {
        return pane2;
    }

    public void setPane2(JPanel pane2)
    {
        this.pane2 = pane2;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // TODO Auto-generated method stub
        
    }

}





