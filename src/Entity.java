import java.awt.Color;
import java.util.Random;

/**
 * Entity.java
 *
 * Used to be an Interface (by Elijah Hursey),
 * now a Superclass.
 *
 * @author Wilton Latham
 * @author Elijah Hursey
 * @version 1.0
 */
public abstract class Entity
{
    public static final int EXP_CAP = 936;
    public static final int LVL_CAP = 10;

    private String name;
    private int health;
    private int mana;
    private int exp;
    private double ad;
    private Color color;
    private int level;
    private Random rand;

    public Entity()
    {
        this.name = "???";
        this.rand = new Random();
        setLevel(1);
        setHealth(getMaxHealth());
        setMana(getMaxMana());
        
    }
    
    public Entity(String name, int level)
    {
        this.name = name;
        setLevel(level);
        setHealth(getMaxHealth());
        setMana(getMaxMana());
    }

    // Includes a rather lethargic 'Surge Function'
    public int getExpByLevel(int level)
    {
        return (int) (1000 * ((2 * level) / Math.pow(Math.E, level)) 
            + 0.2);
    }
    
    public int genStat(int factor)
    {
        return (int) factor * (getExpByLevel(11 - getLevel()));
    }
    
    public int getMaxHealth()
    {
        return genStat(1000);
    }
    
    public int getMaxMana()
    {
        return genStat(100);
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {   
        if (level > LVL_CAP)
        {
            this.level = LVL_CAP;
        }
        else if (level == 0)
        {  
            this.level = 1;
        }
        else
        {
            this.level = level;
        }
    }
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public int getMana()
    {
        return mana;
    }

    public void setMana(int mana)
    {
        this.mana = mana;
    }

    public int getExp()
    {
        return exp;
    }
    
    public void setExp(int exp)
    {
        this.exp = exp;
    }

    public double getAd()
    {
        return ad;
    }

    public void setAd(double ad)
    {
        this.ad = ad;
    }

    public int getAp()
    {
        return rand.nextInt(genStat(100)) + 1;
    }
    
    public double getMp()
    {
    	return rand.nextInt(genStat(50)) + 1;
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }
}
