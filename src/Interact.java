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
public class Interact extends Thread implements ActionListener 
{
	private JFrame frame;
	private JPanel panel;
	private JLabel jlMStats;
	private JLabel jlDialog;
	private JLabel jlIcon;
	private boolean playerControlled;
	private int currentLevel;

	private Player player;
	private Monster monster;

	public Interact()
	{
		this.setPlayer(new Player("Melkor", 2));
		this.monster = new Monster("The Assassin", 2);
		this.playerControlled = true;
		this.currentLevel = getPlayer().getLevel();
		initComponents();
	}


	public Interact(Player player)
	{
		this.setPlayer(player);
		this.monster = new Monster();
		this.currentLevel = getPlayer().getLevel();

		initComponents();
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
				if (isPlayerControlled() && getMonster().getHealth() > 0){
					getMonster().setHealth(getMonster().getHealth() 
							- getPlayer().getAp());
				}

				update();

			}

		});

		blizzard.addActionListener(new ActionListener()
		{ 
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (isPlayerControlled() && getMonster().getHealth() > 0){
					getMonster().setHealth(getMonster().getHealth() 
							- getPlayer().getAp() + 10);
				}

			}

		});

		discern.addActionListener(new ActionListener()
		{ 
			@Override
			public void actionPerformed(ActionEvent e)
			{

				if (isPlayerControlled() && getPlayer().getMana() != 0){

					getMonster().setStatus(getMonster().getStatus() + 1);
					getPlayer().setMana(getPlayer().getMana() - 75);
				}

				update();
			}
		});

		heal.addActionListener(new ActionListener()
		{ 
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (isPlayerControlled() && getPlayer().getMana() != 0){
					getPlayer().setMana(getPlayer().getMana() - 75);
				}
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

	public void run()
	{
		try
		{
			setPlayerControlled(false);
			jlDialog.setText("<html>\"Victory!\"</html>");
			setCurrentLevel(player.getLevel());

			getPlayer().setExp(getPlayer().getExp() 
					+ getPlayer().getExpByLevel(getPlayer().getLevel()));

			sleep(3000);
			jlDialog.setText("<html>You've earned " 
					+ getPlayer().getExpByLevel(getPlayer().getLevel()) + " EXP</html>");

			if (getCurrentLevel() != getPlayer().getLevel())
			{
				sleep(2000);
				jlDialog.setText("<html>Level Up!</html>");

			}

		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void update()
	{
		// TODO Auto-generated method stub

		switch (getMonster().getStatus())
		{
		case 1:
			jlMStats.setText("<html><center><br>" 
					+ getMonster().getName() + "<br>"
					+ "<br>HP  ??? / ???<br><br>Mana  ??? "
					+ "/ ???<br><br></center></html>");
			break;
		case 2:
			jlMStats.setText("<html><center><br>"
					+ getMonster().getName() + "<br>"
					+ "<br>HP " + getMonster().getHealth() 
					+ " / " + getMonster().getMaxHealth() 
					+ "<br><br>Mana  ??? "
					+ "/ ???<br><br></center></html>");
			break;
		case 3:
			jlMStats.setText("<html><center><br>"
					+ getMonster().getName() + "<br>"
					+ "<br>HP " + getMonster().getHealth() 
					+ " / " + getMonster().getMaxHealth() 
					+ "<br><br>Mana " + getMonster().getMana()
					+ " / " + getMonster().getMaxMana() 
					+ "<br><br></center></html>");
			break;
		default:
			break;          
		}

		if (isPlayerControlled() && getMonster().getHealth() != 0
				&& getPlayer().getHealth() != 0)
		{
			setPlayerControlled(false);
			getPlayer().setHealth(getPlayer().getHealth() 
					- getMonster().getAp());
			setPlayerControlled(true);	
		}


		if (getPlayer().getHealth() <= 0)
		{ 
			jlDialog.setText("<html>\"You have perished.\"</html>");
			setPlayerControlled(false);
		}
		else if (getMonster().getHealth() <= 0)
		{
			if (isPlayerControlled())
			{
				start();
			}
		}
	}

	public static void main(String[] args)
	{
		new Interact();
	}

	@Override
	public void actionPerformed(ActionEvent e){}

	//Getters and Setters
	public int getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	public Monster getMonster()
	{
		return monster;
	}

	public void setMonster(Monster monster)
	{
		this.monster = monster;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
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
