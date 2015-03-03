import java.awt.Color;


public interface Entity
{
    int getHealth();
    void setHealth(int health);
    
    int getAD();
    void setAD(int AD);
    
    int getAP();
    void setAP(int AP);
    
    int getArmor();
    void setArmor(int armor);
    
    int getMR();
    void setMR(int MR);

    Color getColor();
    void setColor(Color c);
    
    int getMana();
    void setMana(int mana);
}
