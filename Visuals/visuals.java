/* cd $HOME/git/Preston/Path-Finding/Visuals
 * git add .
 * git commit -m 'description of change'
 * git push origin HEAD:Preston
 * 
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
        int count = 0;
        while (count < howMuch)
        {
            map = new int[5][5];
            map[0][0] = 1;
            map[4][0] = 1;
            map[0][4] = 1;
            map[4][4] = 1;
            for (int i = 1; i < map.length - 1; i++)
            {
                for (int j = 1; j < map[i].length - 1; j++)
                {
                    map[i][j] = r.nextInt(2);
                }
            }
            maps.add(map);
            count++;
        }
        
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
    public static void main(String[] args)
    {
        Visuals v = new Visuals();
        v.AssignMaps(3);
        v.printMaps();
    }
    
}