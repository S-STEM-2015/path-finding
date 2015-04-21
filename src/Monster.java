public class Monster extends Entity
{
    private int status;
    
    public Monster()
    {
        super();
        status = 0;
    }

    public Monster(String name, int lvl)
    {
        super(name, lvl);
    }
    
    public void setStatus(int status)
    {
        this.status = status;
    }
    
    public int getStatus()
    {
        return status;
    }
    
}
