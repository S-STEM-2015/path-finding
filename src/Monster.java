import java.awt.Color;


public class Monster implements Entity
{
    String name;
    int health;
    int AD;
    int AP;
    int armor;
    int MR;
    Color c;
    int mana;

    public Monster()
    {
        health = 100;
	AD = 10;
	AP = 0;
	armor = 0;
	MR = 0;
	c = Color.BLUE;
	mana = 100;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
	this.name = name;
    }

    @Override
    public int getHealth()
    {
        return health;
    }

    @Override
    public void setHealth(int health)
    { 
        this.health = health;
    }

    @Override
    public int getAD()
    {         
        return AD;
    }

    @Override
    public void setAD(int AD)
    {         
        this.AD = AD;
    }

    @Override
    public int getAP()
    {         
        return AP;
    }

    @Override
    public void setAP(int AP)
    {         
        this.AP = AP;
    }

    @Override
    public int getArmor()
    {        
        return armor;
    }

    @Override
    public void setArmor(int armor)
    {    
        this.armor = armor;
    }

    @Override
    public int getMR()
    {    
        return MR;
    }

    @Override
    public void setMR(int MR)
    {    
        this.MR = MR;
    }

    @Override
    public Color getColor()
    {    
        return c;
    }

    @Override
    public void setColor(Color c)
    {    
        this.c = c;
    }

    @Override
    public int getMana()
    {    
        return mana;
    }

    @Override
    public void setMana(int mana)
    {    
        this.mana = mana;
    }

}
