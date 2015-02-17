import java.util.ArrayList;
import java.util.Random;

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
    private Visuals tileRegistry = new Visuals();
    private Random randomVal = new Random();
    private ArrayList<int[][]> maps;
    private int[][] dungeon;

    /*
     * This constructor fills the 'board' ArrayList.
     */
    public Dungeon()
    { 
        maps = tileRegistry.getMaps();
        tileRegistry.AssignMaps(10);
        dungeon = new int[25][25];
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
    public void generateDungeon()
    {
    	 int[][] tile;
         boolean first = true;

      for (int q = 0; q < SIZE; q++)
      {
         for (int i = 0; i < SIZE; i++)
         {
             for (int j = 0; j < SIZE; j++)
             {
                 for (int x = 0; x < SIZE; x++)
                 {
                     if (board.get(q).get(j).equals(BLANKTILE))
                     {
                             tile = maps.get(randomVal.nextInt(9));
                     }
                     else
                     {
                        tile = board.get(q).get(j);
                     }
                     
                     //Fills edges with zeroes.
                     if (i == 0 && first)
                     {
                         System.out.print(0 + " ");
                     } 
                     else if (i == SIZE - 1 && q == SIZE - 1)
                     {
                     	System.out.print(0 + " ");
                     }
                     else if (x == 0 && j == 0)
                     {
                     	System.out.print(0 + " ");
                     }
                     else if (x == SIZE -1 && j == SIZE -1)
                     {
                     	System.out.print(0 + " ");
                     }
                     //This will proceed to print the map.
                     else
                     {
                         System.out.print(tile[i][x] + " ");
                     }
                     
                     
                 }
             }
             System.out.println();
         }
         first = false;
       }
    }
    
    public String toString()
    {
    	return null;
    }
    
    /*
     * This method will only print a single tile for now.
     */
    public int[][] getDungeon()
    {
     
     return dungeon;
     
    }   
}
