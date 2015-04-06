import java.awt.Color;

/** 
 * Entity.java
 * 
 * Used to be an Interface; now a Superclass.
 */
public abstract class Entity
{
    public static final int EXP_CAP = 936;
    public static final int LVL_CAP = 10;

    private String name;
    private int health;
    private int mana;
    private double exp;
    private double ad;
    private double ap;
    private double mr;
    private Color color;
    private int level;

    public Entity()
    {
        this.name = "???";
        setLevel(1);
    }
    
    public Entity(String name, int level)
    {
        this.name = name;
        setLevel(level);
    }

    public void increaseExp()
    {
        if ((getExp() == 0) || getExp() % EXP_CAP != getExp())
        {
            setExp(expPerLevel(getLevel() + 1));
        }
        else
        {
            setLevel(getLevel() + 1);
        }
    }
    
    public int getMaxHealth()
    {
        return (int) Math.round(1000 * expPerLevel(11 - getLevel()));
    }
    
    public int getMaxMana()
    {
        return (int) Math.round(500 * expPerLevel(11 - getLevel()));
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
        else
        {  
            this.level = level;
            
            setHealth(getMaxHealth());
            setMana(getMaxMana());
            setAp(100 * expPerLevel(11 - getLevel()));
            setMr(60 * expPerLevel(11 - getLevel()));
            setAd(40 * expPerLevel(11 - getLevel()));
            setExp(0.0);
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

    public void setHealth(double health)
    {
        this.health = (int) Math.round(health);
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
        return (int) exp;
    }
    
    public void setExp(double exp)
    {
        this.exp = Math.round(1000 * exp);
    }

    public double getAd()
    {
        return ad;
    }

    public void setAd(double ad)
    {
        this.ad = ad;
    }

    public double getAp()
    {
        return ap;
    }

    public void setAp(double ap)
    {
        this.ap = ap;
    }

    public double getMr()
    {
        return mr;
    }

    public void setMr(double mr)
    {
        this.mr = mr;
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }
    
    public abstract double expPerLevel(double level);
}
