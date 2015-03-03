import java.util.ArrayList;
import java.util.Random;

/*
 * Dungeon.java
 *
 * This class generates dungeons by conjugating tiles
 * of various properties.
 * 
 * @author Wilton Latham, et. al.
 * @version 1.0
 */
public class Dungeon implements CornerSeeds
{
    /**
     * Simply put, this is an ArrayList of dungeon Tiles.
     * 
     * "You're asking me for Inception.
     *  I hope you do understand the gravity of that request. " - Cobb, Inception
     */
    private ArrayList<ArrayList<int[][]>> board;  
    
    private Visuals centerTiles;
    private boolean rogueMode;
    private Random randomVal;
    private int[][] dungeon;

    /*
     * This constructor fills the 'board' ArrayList.
     */
    public Dungeon()
    { 
        board = new ArrayList<ArrayList<int[][]>>(); 
        centerTiles = new Visuals();
        randomVal = new Random();
        dungeon = new int[25][25];
        
        centerTiles.AssignMaps(10);
        
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
        generateDungeon();

    }

    public ArrayList<ArrayList<int[][]>> getBoard()
    {
        return board;
    }

    public void setBoard(ArrayList<ArrayList<int[][]>> board)
    {
        this.board = board;
    }

    public void rogueMode()
    {
        rogueMode = true;
    }
    
    public void normalMode()
    {
        rogueMode = false;
    }

    public void generateDungeon()
    { 
        //These variables define the indices for 'int[][] dungeon'. 
        int xLim = 0; 
        int yLim = 0; 

        int[][] tile;
        boolean first = true;

        //Vertically traverses between "horizontally" conjugate 5x25 tiles
        for (int q = 0; q < SIZE; q++)
        {
            //Vertically traverses between rows within "horizontally" conjugate 25x5 tile
            for (int i = 0; i < SIZE; i++)
            {
                //Horizontally traverses between 5x5 tiles
                for (int j = 0; j < SIZE; j++)
                {
                    //Horizontally traverses indices of 5x5 tiles
                    for (int x = 0; x < SIZE; x++)
                    {
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
                    }

                }
    
                //Boundary dependent upon change in 'i'
                xLim++;
            }
            first = false;
        }
        
        //hard coded start/finish points, respectively
        dungeon[0][1] = 3;
        dungeon [24][23] = 4;
    } 
    
    public String toString()
    {
        String total = "";

        if (rogueMode)
        {
            for (int i = 0; i < 25; i++)
            {
                for (int j = 0; j < 25; j++)
                {  
                    if ((i == 0 || i == 24) && dungeon[i][j] != 1)
                    {
                        total += "- ";
                    }    
                    else if (j == 24 || j == 0 && dungeon[i][j] != 1)
                    {
                        total += "| ";
                    }
                    else
                    {
                        if (dungeon[i][j] == 0)
                        {
                            total += "# ";
                        }
                        else
                        {
                            total += ". ";
                        }    
                        //total += dungeon[i][j] + " "; 
                    }
                   
                }   
                total += "\n";
            }
            return total;
        }
        else
        { 
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
    }
   
    //Getters and setters for fields are here.
    public int[][] getDungeon()
    {
        return dungeon;
    }   
}
