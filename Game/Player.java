import java.awt.Color;


public class Player implements Entity
{
    String name;
    int health;
    int AD;
    int AP;
    int armor;
    int MR;
    Color c;
    int mana;

    public Player()
    {
        health = 100;
	AD = 10;
	AP = 0;
	armor = 0;
	MR = 0;
	c = Color.BLUE;
	mana = 100;
    }
    @Override
    public int getHealth()
    {
        return 0;
    }

    @Override
    public void setHealth(int health)
    { 
        
    }

    @Override
    public int getAD()
    {         
        return 0;
    }

    @Override
    public void setAD(int AD)
    {         
        
    }

    @Override
    public int getAP()
    {         
        return 0;
    }

    @Override
    public void setAP(int AP)
    {         
        
    }

    @Override
    public int getArmor()
    {        
        return 0;
    }

    @Override
    public void setArmor(int armor)
    {    
        
    }

    @Override
    public int getMR()
    {    
        return 0;
    }

    @Override
    public void setMR(int MR)
    {    
        
    }

    @Override
    public int getColor()
    {    
        return 0;
    }

    @Override
    public void setColor(Color c)
    {    
        
    }

    @Override
    public int getMana()
    {    
        return 0;
    }

    @Override
    public void setMana(int mana)
    {    
        
    }

}
