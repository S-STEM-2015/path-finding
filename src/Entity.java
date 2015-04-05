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
    private int lvl;

    public Entity()
    {
        this.name = "???";
        setLvl(1);
    }
    
    public Entity(String name, int lvl)
    {
        this.name = name;
        setLvl(lvl);
    }

    public void increaseExp()
    {
        if ((getExp() == 0) || getExp() % EXP_CAP != getExp())
        {
            setExp(getExp() + ((2 * getLvl() + 1) 
                / (Math.pow(Math.E, getLvl() + 1))) + 0.2);
        }
        else
        {
            setLvl(getLvl() + 1);
        }
    }

    public int getLvl()
    {
        return lvl;
    }

    public void setLvl(int lvl)
    {
        double surge;
        
        if (lvl > LVL_CAP)
        {
            this.lvl = LVL_CAP;
        }
        else
        {  
            this.lvl = lvl;
            
            //an awesome surge function
            surge = ((2 * (11 - getLvl())) 
                / (Math.pow(Math.E, 11 - getLvl()))) + 0.2;
            
            setHealth(1000 * surge);
            setAp(100 * surge);
            setMana(500 * surge);
            setMr(60 * surge);
            setAd(40 * surge);
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
