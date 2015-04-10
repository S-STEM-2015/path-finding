import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
 
 /**
  * Interact.java
  *
  * Interactive Player vs. Monster display.
  * 
  * @author Wilt Latham
  * @version 0.40
  */
public class Interact implements ActionListener
{
    private JFrame frame;
    private ArrayList<JLabel> jl = new ArrayList<JLabel>();
    private JPanel panel;
    private JPanel panel2; 
    private Player player;

    private Monster monster;

    public Interact()
    {
        this.player = new Player("Melkor", 2);
        this.monster = new Monster();
        
        initComponents();
        battleState(true);
    }
    
    public Interact(Player player)
    {
		this.player = player;
		this.monster = new Monster();
		
		initComponents();
		battleState(true);
    }

    /**
     * Perhaps create a Battle state machine, eventually. This 
     * would permit "Boss" battles.
     */
    public void battleState(boolean execute)
    {  
        if (execute) {
            battleState(false);
        }
        else {
            battleState(true);
        }
    }
    
    /*
     * This method initializes elements of the the battle phase, 
     * not limited to buttons and panels. 'Should only be called 
     * within constructor.
     */
    public void initComponents()
    {
        
        panel = new JPanel(new GridLayout(2,1));
        panel2 = new JPanel(new GridLayout(1,2));
        
        
        addDisplay();
        addStats();
        addButtons();
        
        panel.add(panel2);
        
        frame = new JFrame();
        frame.setLocation(100, 100);
        frame.setSize(800, 400);
        frame.setTitle("Interact");
        frame.add(panel);
        frame.setVisible(true);
    }
    
    public void addStats()
    {
        JPanel jpPs = new JPanel(new GridLayout(4, 0));
        
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
        
        for (int i = 0; i < 4; i++)
        {
            jpPs.add(jl.get(i));
        }
        
        panel2.add(jpPs);
        
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
        panel2.add(jpB);
    }
    
    public void addDisplay()
    {
        JPanel jpD = new JPanel();
        jpD.setLayout(new GridLayout(5, 1,8,8));
        //ImageIcon icon = new ImageIcon("image/knight3-512.png","Player");
        ImageIcon icon2 = new ImageIcon("image/assassin2-512.png","Monster");
        //jpD.add(new JLabel(icon));
        jl.add(new JLabel(icon2));
        jl.add(new JLabel(monster.getName(), JLabel.CENTER));
        jl.add(new JLabel(" HP    ??? / ???", JLabel.CENTER));
        jl.add(new JLabel(" Mana  ??? / ???", JLabel.CENTER));
        jl.add(new JLabel(">>", JLabel.CENTER));
        
        for (int i = 4; i < 6; i++)
        {
            jpD.add(jl.get(i));
        }
        
        panel.add(jpD);
 
    }
    
    public class Action
    {
        private boolean playerControlled = true;
        public Action()
        {
        }
        
        public void execute()
        {
            
        }

        public boolean isPlayerControlled()
        {
            return playerControlled;
        }

        public void setPlayerControlled(boolean playerControlled)
        {
            this.playerControlled = playerControlled;
        }
    }
    
    public class AIAction extends Action
    {
        public AIAction()
        {
           super();
           setPlayerControlled(false);
        }
        
        public void execute()
        {
            
        }
    }

    public static void main(String[] args)
    {
        new Interact();
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        // TODO Auto-generated method stub
        
    }
    
  //Getters and Setters
    
    public Monster getmonster()
    {
        return monster;
    }

    public void setmonster(Monster monster)
    {
        this.monster = monster;
    }
}





