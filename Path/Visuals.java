
/* cd $HOME/git/Preston/Path-Finding/Visuals
 * git add .
 * git commit -m 'description of change'
 * git push origin HEAD:Preston
 * USE BOTH OF THEM
 */
import java.util.ArrayList;
import java.util.Random;

public class Visuals
{
    
    private Random r = new Random();
    private int[][] map;
    private ArrayList<int[][]> maps = new ArrayList<int[][]>();
    public void AssignMaps(int howMuch)
    {
        //neighbor chooses a random neighbor for each inner index (not 1st or last columns/rows).
        Random neighbor = new Random();
        int count = 0;
        while (count < howMuch)
        {
            map = new int[5][5];      
            for (int i = 0; i < map.length; i++)
            {
                for (int j = 0; j < map[i].length; j++)
                {
                    int numberUsed = r.nextInt(10);
                    if (numberUsed <= 5)
                        map[i][j] = 1;
                    else
                        map[i][j] = 0;
                }
            }
            map[0][0] = 1;
            map[4][0] = 1;
            map[0][4] = 1;
            map[4][4] = 1;
            for (int i = 1; i < map.length - 1; i++)
            {
                for (int j = 1; j < map[i].length - 1; j++)
                {
                    int[] innerMap = {map[i + 1][j], map[i - 1][j], map[i][j + 1], map[i][j - 1]};
                    if (map[i + 1][j] + map[i][j + 1] + map[i][j - 1] + map[i - 1][j] == 0)
                    {
                        int index = neighbor.nextInt(innerMap.length);
                        innerMap[index] = 1;
                        map[i + 1][j] = innerMap[0];
                        map[i - 1][j] = innerMap[1];
                        map[i][j + 1] = innerMap[2];
                        map[i][j - 1] = innerMap[3];
                    }
                    if ((i == 3 && j == 3) && map[i][j + 1] == 0 && map[i + 1][j] == 0)
                    {
                        int test = new Random().nextInt(2);
                        if (test == 1)
                        {
                            map[i][j + 1] = 1;
                        }    
                        else
                        {
                            map[i + 1][j] = 1;
                        }
                       
                    }
                    if ((i == 1 && j == 1) && map[i][j - 1] == 0 && map[i - 1][j] == 0)
                    {
                        int test = new Random().nextInt(2);
                        if (test == 1)
                        {
                            map[i][j - 1] = 1;
                        }    
                        else
                        {
                            map[i - 1][j] = 1;
                        }
                       
                    }
                    if ((i == 1 && j == 3) && map[i][j + 1] == 0 && map[i - 1][j] == 0)
                    {
                        int test = new Random().nextInt(2);
                        if (test == 1)
                        {
                            map[i][j + 1] = 1;
                        }    
                        else
                        {
                            map[i - 1][j] = 1;
                        }
                       
                    }
                    if ((i == 3 && j == 1) && map[i][j - 1] == 0 && map[i + 1][j] == 0)
                    {
                        int test = new Random().nextInt(2);
                        if (test == 1)
                        {
                            map[i][j - 1] = 1;
                        }    
                        else
                        {
                            map[i + 1][j] = 1;
                        }
                       
                    }
                }
            }
            maps.add(map);
            count++;
        }
        
    }
   
    /**
     * @return the r
     */
    public Random getR()
    {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(Random r)
    {
        this.r = r;
    }

    /**
     * @return the map
     */
    public int[][] getMap()
    {
        return map;
    }

    /**
     * @param map the map to set
     */
    public void setMap(int[][] map)
    {
        this.map = map;
    }

    /**
     * @return the maps
     */
    public ArrayList<int[][]> getMaps()
    {
        return maps;
    }

    /**
     * @param maps the maps to set
     */
    public void setMaps(ArrayList<int[][]> maps)
    {
        this.maps = maps;
    }

    public void printMaps()
    {
        int count = 0;
        while (count < maps.size())
        {
            int[][] array = maps.get(count);
            for (int i = 0; i < array.length; i++)
            {
                for (int j = 0; j < array[i].length; j++)
                {
                    System.out.print(array[i][j] + " ");
                }
                System.out.println("");
            }
            System.out.println("");
            count++;
        }
        
    }
    
    public void printRowByRow(int startingPoint)
    {
        int arrayIndex = 0;
        int arrayIndex2 = 0;
        int[][] arrays = new int[5][25];
        for (int h = 0; h < arrays.length; h++)
        {
            arrayIndex2 = 0;
            for (int i = 0; i < 5; i++)
            {
                arrayIndex = 0;
                arrays[h][arrayIndex2] = maps.get(i + startingPoint)[h][arrayIndex];
                arrayIndex++;
                arrayIndex2++;
                arrays[h][arrayIndex2] = maps.get(i + startingPoint)[h][arrayIndex];
                arrayIndex++;
                arrayIndex2++;
                arrays[h][arrayIndex2] = maps.get(i + startingPoint)[h][arrayIndex];
                arrayIndex++;
                arrayIndex2++;
                arrays[h][arrayIndex2] = maps.get(i + startingPoint)[h][arrayIndex];
                arrayIndex++;
                arrayIndex2++;
                arrays[h][arrayIndex2] = maps.get(i + startingPoint)[h][arrayIndex];
                arrayIndex2++;
                    
            }
            
        }
        
        for (int i = 0; i < arrays.length; i++)
        {
            for (int j = 0; j < arrays[i].length; j++)
            {
                System.out.print(arrays[i][j] + " ");
               
            }
            System.out.println();
        }
    }
    
    public void printAll()
    {
        printRowByRow(0);
        printRowByRow(5);
        printRowByRow(10);
        printRowByRow(15);
        printRowByRow(20);
    }

    public static void main(String[] args)
    {
        Visuals v = new Visuals();
        v.AssignMaps(25);
        v.printMaps();
        v.printAll();
    }
}