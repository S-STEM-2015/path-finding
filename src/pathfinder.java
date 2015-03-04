import java.util.LinkedList;
import java.util.Queue;
import java.util.ListIterator;
import java.util.Arrays;

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

    public boolean isWall(int[] a)
    {
        if(a[0] >= 24 || a[0] < 0 || a[1] >= 24 || a[1] < 0)
        {
            return true;
        }
        return false;
    }

    //a must be the value from coords b must be the value from next
    //returns true if the value should be removed from the list
    public boolean compareCoords(int[] a, int[] b)
    {
        if(a[0] == b[0] && a[1] == b[1] && a[2] >= b[2])
        {
            return true;
        }
        return false;
    }

    public boolean findNext()
    {
        //1 is path 0 is block
        int[] firstCoord = coords.getFirst();
        LinkedList<int[]> next = new LinkedList<int[]>();
        next.add(up(firstCoord));
        next.add(down(firstCoord));
        next.add(left(firstCoord));
        next.add(right(firstCoord));
        ListIterator<int[]> li = next.listIterator();
        while(li.hasNext())
        {
            int[] currentCoord = li.next();
            if(compareCoords(firstCoord, currentCoord) || isWall(firstCoord))
            {
                li.remove();
            }
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

