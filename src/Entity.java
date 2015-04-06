import java.awt.Color;

/** 
 * Entity.java
 * 
 * Used to be an Interface; now a Superclass.
 */
public abstract class Entity
{
    private static final double EXP_CAP = 0.936;
    private static final int LVL_CAP = 10;

    private String name;
    private double health;
    private double mana;
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

    //a lethargic 'Surge Function'
    public double expPerLevel(double level)
    {
        return ((2 * level) / Math.pow(Math.E, level)) + 0.2
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {   
        if (lvl > LVL_CAP)
        {
            this.lvl = LVL_CAP;
        }
        else
        {  
            this.lvl = lvl;
            
            setHealth(1000 * expPerLevel(11 - getLevel()));
            setAp(100 * expPerLevel(11 - getLevel()));
            setMana(500 * expPerLevel(11 - getLevel()));
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

    public double getHealth()
    {
        return health;
    }

    public void setHealth(double health)
    {
        this.health = health;
    }

    public double getMana()
    {
        return mana;
    }

    public void setMana(double mana)
    {
        this.mana = mana;
    }

    public double getExp()
    {
        return exp;
    }
    
    public void setExp(double exp)
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
}
