import java.util.LinkedList;
import java.util.Queue;
import java.util.ListIterator;

public class pathfinder
{
    int[][] dungeon;
    LinkedList<int[]> coords;
    int[] start;
    public pathfinder()
    {
        Dungeon d = new Dungeon();
        dungeon = d.getDungeon();
        coords = new LinkedList<int[]>();
        int[] end = new int[] {
            24, 23, 0
        };
        start = new int[] {
            0, 1, 0
        };
        coords.addFirst(end);
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

    public void findNext()
    {
        //1 is path 0 is block
        int[] temp = coords.getFirst();
        LinkedList<int[]> next = new LinkedList<int[]>();
        next.add(up(temp));
        next.add(down(temp));
        next.add(left(temp));
        next.add(right(temp));
        ListIterator<int[]> li = next.listIterator();
        while(li.hasNext())
        {

        }
    }

    public void findPosPaths()
    {
        int[] last = coords.getLast();
        while(true)
        {
            findNext();
        }
    }
}

