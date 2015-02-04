import java.util.ArrayList;

/*
 * This class should create the dungeon by matching tiles
 * of various properties.
 * 
 * @author Wilton Latham, et. al.
 * @version 0.1
 */
public class Dungeon implements CornerSeeds
{
    private ArrayList<int[][]> board = new ArrayList<int[][]>();
    
    /*
     * This constructor fills the 'board' ArrayList.
     */
    public Dungeon()
    { 
        board.add(TLTILE);
        for (int x = 0; x < 3; x++)
        {
            board.add(TLTILE);
        }
        board.add(TRTILE);
        for (int x = 0; x < 15; x++)
        {
            board.add(TLTILE);
        }
        board.add(BLTILE);
        for (int x = 0; x < 3; x++)
        {
            board.add(TLTILE);
        }
        board.add(BRTILE);

    }

    public ArrayList<int[][]> getBoard()
    {
        return board;
    }

    public void setBoard(ArrayList<int[][]> board)
    {
        this.board = board;
    }
    
 // "Print" and "toString" methods are here.
    
    public void printTile(int[][] tile)
    {
        for (int i = 0; i < tile.length; i++)
        {
            for (int j = 0; j < tile[i].length; j++)
            {
                System.out.print(tile[i][j] + " ");
            }
            System.out.println();
        }
    }
    /*
     * This method will only print a single tile for now.
     */
    public void printBoard(ArrayList<int[][]> board)
    {
        this.board = board;
        int[][] tile;
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
            {
                
                for (int x = 0; x < SIZE; x++)
                {
                    tile = board.get(j);
                    System.out.print(tile[i][x] + " ");
                }
            }
            System.out.println();
        }
    }   
}
