import java.util.LinkedList;
import java.util.Queue;

public class pathfinder
{
    private static final int SIZE = 3;
    int[][] dungeon;
    Queue<int[]> coords;
    LinkedList<int[]> path;
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
       int[] temp = new int[3];
       boolean valid = true;
       if(coord[0] - 1 > 0)
       {
           temp[0] = coord[0] - 1;
       }
       else
       {
           valid = false;
       }
       temp[1] = coord[1];
       temp[2] = coord[2] + 1;
       return (valid) ? temp : null;
    }

    public int[] down(int[] coord)
    {
        int[] temp = new int[3];
        boolean valid = true;
        if(coord[0] + 1 < dungeon.length)
        {
            temp[0] = coord[0] + 1;
        }
        else
        {
            valid = false;
        }
        temp[1] = coord[1];
        temp[2] = coord[2] + 1;
        return (valid) ? temp : null;
    }

    public int[] left(int[] coord)
    {
        int[] temp = new int[3];
        boolean valid = true;
        temp[0] = coord[0];
        if(coord[1] - 1 > 0)
        {
            temp[1] = coord[1] - 1;
        }
        else
        {
            valid = false;
        }
        temp[2] = coord[2] + 1;
        return (valid) ? temp : null;
    }

    public int[] right(int[] coord)
    {
        int[] temp = new int[3];
        boolean valid = true;
        temp[0] = coord[0];
        if(coord[1] + 1 < dungeon.length)
        {
            temp[1] = coord[1] + 1;
        }
        else
        {
            valid = false;
        }
        temp[2] = coord[2] + 1;
        return (valid) ? temp : null;
    }

    public void findPath()
    {
        int[] temp = coords.poll();
        
    }
}

