import java.util.ArrayList;

/*
 * This class should create the dungeon by matching tiles
 * of various properties.
 * 
 *   @author Wilton Latham, et. al.
 *   @version 1.0
 */
public class Dungeon
{
    private ArrayList<SeedTile> board;
    
    public Dungeon()
    {
        board = new ArrayList<SeedTile>();
        
    }

    public ArrayList<SeedTile> getBoard()
    {
        return board;
    }

    public void setBoard(ArrayList<SeedTile> board)
    {
        this.board = board;
    }
}
