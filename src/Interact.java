import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

 
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
    private JPanel panel;
    private JLabel jlMStats;
    private JLabel jlDialog;
    private JLabel jlIcon;

    private Player player;
    private Monster monster;

    public Interact()
    {
        this.setPlayer(new Player("Melkor", 2));
        this.monster = new Monster();
        
        initComponents();
        battleState(true, 0);
    }
    
    public Interact(Player player)
    {
		this.setPlayer(player);
		this.monster = new Monster();
		
		initComponents();
		battleState(true, 0);
    }

    /**
     * Perhaps create a Battle state machine, eventually. This 
     * would permit "Boss" battles.
     */
    public void battleState(boolean execute, long timeMillis)
    {  
        if (execute) {
            battleState(false, 0);
        }
        else {
            battleState(true, 0);
        }
    }
    
    /*
     * This method initializes elements of the the battle phase, 
     * not limited to buttons and panels. 'Should only be called 
     * within constructor.
     */
    public void initComponents()
    {
        panel = new JPanel(new GridLayout(3,1));
        jlMStats = new JLabel("", JLabel.CENTER);
        jlDialog = new JLabel("", JLabel.CENTER);
        jlIcon = new JLabel("", JLabel.CENTER);

        
        addDisplay();
        addInteractPanel();
        
        frame = new JFrame();
        frame.setLocation(100, 100);
        frame.setSize(800, 400);
        frame.setTitle("Interact");
        frame.add(panel);
        frame.setVisible(true);
    }
    
    public void addInteractPanel()
    {   
        JPanel jpA = new JPanel(new GridLayout(1,2));
        JPanel jpB = new JPanel(new GridLayout(4,0));
        JButton attack = new JButton("ATTACK");
        JButton blizzard = new JButton("BLIZZARD");
        JButton discern = new JButton("DISCERN");
        JButton heal = new JButton("HEAL");
        
        jlDialog.setText("<html>\"This is a test.\"</html>"); 
        


        attack.addActionListener(new ActionListener()
        { 
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO Auto-generated method stub
            }

        });
        
        blizzard.addActionListener(new ActionListener()
        { 
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO Auto-generated method stub
            }

        });
        
        discern.addActionListener(new ActionListener()
        { 
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO Auto-generated method stub
            }
        });
        
        heal.addActionListener(new ActionListener()
        { 
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO Auto-generated method stub
            }

        });
        
        jpB.add(blizzard);
        jpB.add(attack);
        jpB.add(discern);
        jpB.add(heal);
        jpA.add(jlDialog);
        jpA.add(jpB);
        panel.add(jpA);
    }
    
    public void addDisplay()
    {
        JPanel jpS = new JPanel(new GridLayout(1,1));
        jlMStats.setText("<html><center><br?>???<br>"
        		+ "<br>HP  ??? / ???<br><br>Mana  ??? "
        		+ "/ ???<br><br></center></html>");
        //ImageIcon icon = new ImageIcon("image/knight3-512.png","Player");
        jpS.add(jlMStats);
        jlIcon.setIcon(new ImageIcon("image/assassin2-512.png","Monster"));
        
        panel.add(jlIcon);
        panel.add(jpS);
 
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

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}