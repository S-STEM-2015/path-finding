import java.util.ArrayList;
import java.util.Random;

/*
 * This class should create the dungeon by matching tiles
 * of various properties.
 * 
 * @author Wilton Latham, et. al.
 * @version 1.0
 */
public class Dungeon implements CornerSeeds
{
<<<<<<< HEAD
    //Simply put, this is an ArrayList of board Tiles/Seeds.
    private ArrayList<ArrayList<int[][]>> board;  
    private Visuals centerTiles;
    private Random randomVal;
    private int[][] dungeon;
=======
    //Simply put, this is an ArrayList of Board Tiles/Seeds.
    private ArrayList<ArrayList<int[][]>> board = new ArrayList<ArrayList<int[][]>>();   
    private Visuals tileRegistry = new Visuals();
    private Random randomVal = new Random();
    private ArrayList<int[][]> maps;
>>>>>>> master

    /*
     * This constructor fills the 'board' ArrayList.
     */
    public Dungeon()
    { 
<<<<<<< HEAD
        board = new ArrayList<ArrayList<int[][]>>(); 
        centerTiles = new Visuals();
        randomVal = new Random();
        dungeon = new int[25][25];
        
        centerTiles.AssignMaps(10);
        
=======
        maps = tileRegistry.getMaps();
        tileRegistry.AssignMaps(10);
>>>>>>> master
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

    public ArrayList<ArrayList<int[][]>> getBoard()
    {
        return board;
    }

    public void setBoard(ArrayList<ArrayList<int[][]>> board)
    {
        this.board = board;
    }

<<<<<<< HEAD
    public void generateDungeon()
    { 
        //These variables define the indices for 'int[][] dungeon'. 
        int xLim = 0; 
        int yLim = 0; 
=======
    // "Print" and "toString" methods are here.

>>>>>>> master

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
<<<<<<< HEAD
        boolean first = true;

        //Vertically traverses between "horizontally" conjugate 25x5 tiles
        for (int q = 0; q < SIZE; q++)
        {
            //Vertically traverses between rows within "horizontally" conjugate 25x5 tile
            for (int i = 0; i < SIZE; i++)
=======
  
     for (int q = 0; q < SIZE; q++)
     {
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
>>>>>>> master
            {
                for (int x = 0; x < SIZE; x++)
                {
                    if (board.get(q).get(j).equals(BLANKTILE))
                    {
<<<<<<< HEAD
                        if (board.get(q).get(j).equals(BLANKTILE))
                        {
                            tile = centerTiles.getMaps().get(randomVal.nextInt(9));
                        }
                        else
                        {
                            tile = board.get(q).get(j);
                        }

                        //Fills edges with zeroes.
                        if (i == 0 && first)
                        {
                            dungeon[xLim][yLim] = 0;
                        } 
                        else if (i == SIZE - 1 && q == SIZE - 1)
                        {
                            dungeon[xLim][yLim] = 0;
                        }
                        else if (x == 0 && j == 0)
                        {
                            dungeon[xLim][yLim] = 0;
                        }
                        else if (x == SIZE -1 && j == SIZE -1)
                        {
                            dungeon[xLim][yLim] = 0;
                        }
                        else
                        {
                            dungeon[xLim][yLim] = tile[i][x];
                        }
                        
                        //Boundary dependent upon change in 'x'
                        yLim++;
                        if (yLim == 25)
                        {
                            yLim = 0;
                        }
=======
                            tile = maps.get(randomVal.nextInt(9));
>>>>>>> master
                    }
                    else
                    {
                        tile = board.get(q).get(j);
                    }
                    
                    System.out.print(tile[i][x] + " ");
                }
<<<<<<< HEAD
    
                //Boundary dependent upon change in 'i'
                xLim++;
            }
            first = false;
        }
        
        //hard coded start/finish points, respectively
        dungeon[0][1] = 1;
        dungeon [24][23] = 1;
    } 

    public String toString()
    {
        String total = "";
        for (int i = 0; i < 25; i++)
        {
            for (int j = 0; j < 25; j++)
            {  
                total += dungeon[i][j] + " "; 
            }
            total += "\n";
        }
        return total;
    }

    //Getters and setters for fields are here.
    public int[][] getDungeon()
    {
        return dungeon;
=======
            }
            System.out.println();
        }
      }
>>>>>>> master
    }   
}
