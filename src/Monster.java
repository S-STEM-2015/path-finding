public class Monster extends Entity
{
    public Monster()
    {
        super();
    }

    public Monster(String name, int lvl)
    {
        super(name, lvl);
    }
    
    // a rather lethargic "Surge Function"
    public double expPerLevel(double level)
    {
        return ((2 * level) / Math.pow(Math.E, level)) + 0.2
    }
}
