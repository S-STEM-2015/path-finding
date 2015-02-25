import java.util.LinkedList;
import java.util.Queue;

public class pathfinder
{
    private static final int SIZE = 3;
    int[][] dungeon;
    Queue<int[]> coords;
    public pathfinder()
    {
        Dungeon d = new Dungeon();
        dungeon = d.getDungeon();
        coords = new LinkedList<int[]>();
        int[] temp = {
            24, 23, 0
        };
        coords.add(temp);
    }
    
    public int[] up(int[] coord)
    {
       int[] temp;
       temp[0] = coord[0] + 1;
       temp[1] = coord[1];
       temp[2] = coord[2] + 1;
       return temp;
    }

    public int[] down(int[] coord)
    {
        return null;
    }

    public int[] left(int[] coord)
    {
        return null;
    }

    public int[] right(int[] coord)
    {
        return null;
    }

    public void find()
    {
        
    }
}

