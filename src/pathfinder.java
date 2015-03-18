import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Arrays;

public class pathfinder
{
    char[][] dungeon;
    LinkedList<int[]> coords;
    int[] start;

    public pathfinder()
    {
        Dungeon d = new Dungeon();
        dungeon = d.dungeonToChar();
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

    public boolean isStart(int[] a)
    {
        if(a[0] == 0
           && a[1] == 1)
        {
            return true;
        }
        return false;
     }

    public boolean isWall(int[] a)
    {
        int x = a[0];
        int y = a[1];
        if(dungeon[x][y] == '*')
        {
            return true;
        }
        return false;
    }

    public LinkedList<int[]> makeCopy(LinkedList<int[]> a)
    {
        LinkedList<int[]> temp = new LinkedList<int[]>();
        ListIterator<int[]> coordsIterator = a.listIterator();
        ListIterator<int[]> temp = temp.listIterator();
        while(coordsIterator.hasNext())
        {
            int[] coordsNext = coordsIterator.next();
            for(int i = 0; i < 3; i++)
            {
                int[] val;
                a[i] = coordsNext[i];
                temp.add(val);
            }
        }
        return temp;
    }
    
    public void generatePaths()
    {
        LinkedList<int[]> directions = new LinkedList<int[]>();
        ListIterator<int[]> directionsIterator = directions.listIterator();
        ListIterator<int[]> coordsIterator = coords.listIterator();
        boolean reachedStart = false;
        while(coordsIterator.hasNext() || !reachedStart)
        {
            int[] coordsNext = coordsIterator.next();
            directions.add(up(coordsNext));
            directions.add(down(coordsNext));
            directions.add(left(coordsNext));
            directions.add(right(coordsNext));
            while(directionsIterator.hasNext())
            {
                int[] nextDirection = directionsIterator.next();
                if(isStart(nextDirection))
                {
                    reachedStart = true;
                    break;
                }
                if(isWall(nextDirection))
                {
                    directionsIterator.remove();
                }
            }
            coords.addAll(directions);
            directions.clear();
        }

        LinkedList<int[]> temporary = makeCopy(coords);
        ListIterator<int[]> tempIterator = temporary.listIterator();
        coordsIterator = coords.listIterator();
        while(coordsIterator.hasNext())
        {
            int[] coordsNext = coordsIterator.next();
             
            while(tempIterator.hasNext())
            {
                int[] tempNext = tempIterator.next();
                if(tempNext[0] == coordsNext[0]
                    && tempNext[1] == coordsNext[0]
                    && tempNext[2] >= coordsNext[2])
                {
                    coords.remove();
                }
            }
        }
    }

    public void selectPath()
    {
        
    }
}

