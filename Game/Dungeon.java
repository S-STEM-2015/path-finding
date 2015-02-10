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
    //Simply put, this is an ArrayList of Board Tiles/Seeds.
    private ArrayList<ArrayList<int[][]>> board = new ArrayList<ArrayList<int[][]>>();   

    /*
     * This constructor fills the 'board' ArrayList.
     */
    public Dungeon()
    { 
        for (int x = 0; x < 5; x++)
        {
            board.add(new ArrayList<int[][]>());
            if (x == 0)
            {
                board.get(x).add(TLTILE);
                board.get(x).add(BLANKTILE);
                board.get(x).add(BLANKTILE);
                board.get(x).add(BLANKTILE);
                board.get(x).add(TRTILE);
            }
            else if (x == 4)
            {
                board.get(x).add(BLTILE);
                board.get(x).add(BLANKTILE);
                board.get(x).add(BLANKTILE);
                board.get(x).add(BLANKTILE);
                board.get(x).add(BRTILE);
            }
            else
            {
                board.get(x).add(BLANKTILE);
                board.get(x).add(BLANKTILE);
                board.get(x).add(BLANKTILE);
                board.get(x).add(BLANKTILE);
                board.get(x).add(BLANKTILE);
            }
        }

    }

    //Getters and setters for fields are here.

    public ArrayList<ArrayList<int[][]>> getBoard()
    {
        return board;
    }

    public void setBoard(ArrayList<ArrayList<int[][]>> board)
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
    public void printBoard(ArrayList<ArrayList<int[][]>> board)
    {
        this.board = board;
        int[][] tile;
  
     for (int q = 0; q < SIZE; q++)
     {
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
            {
                for (int x = 0; x < SIZE; x++)
                {
                    tile = board.get(q).get(j);
                    System.out.print(tile[i][x] + " ");
                }
            }
            System.out.println();
        }
      }
    }   
}
