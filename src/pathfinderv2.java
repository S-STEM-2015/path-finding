public class pathfinderv2
{
    boolean[][] walls;
    int[][] path;
    int startx = 0;
    int starty = 1;
    int endx = 24;
    int endy = 23;
    public pathfinderv2()
    {    
        Dungeon d = new Dungeon();
        int[][] dungeon = d.getDungeon();
        walls = new boolean[dungeon.length][dungeon.length];
        path = new int[dungeon.length][dungeon.length];
        for(int i = 0; i < dungeon.length; i++)
        {
            for(int j = 0; j < dungeon[i].length; j++)
            {
                //-1 is path, -2 is block
                walls[i][j] = dungeon[i][j] == 0 ? true : false;
                path[i][j] = -1;
                //System.out.print(dungeon[i][j]);
            }
            //System.out.println();
        }
        //System.out.println();
        path[endx][endy] = 0;
        writePaths();
        printPath();
    }

    
    public void writePaths()
    {
        int count = 1;
        
        while(path[startx][starty] == -1)
        {
            for(int i = 0; i < path.length; i++)
            {
                for(int j = 0; j < path[i].length; j++)
                {
                    if(path[i][j] == count - 1)
                    {
                        //left
                        if(i > 0)
                        {
                            //System.out.println("left");
                            if(path[i - 1][j] == -1 && !walls[i - 1][j])
                            {
                                
                                path[i - 1][j] = count;
                            }
                        }
                        //right
                        if(i < path.length - 1)
                        {
                            //System.out.println("right");
                            if(path[i + 1][j] == -1 && !walls[i + 1][j])
                            {
                                path[i + 1][j] = count;
                            }
                        } 
                        //down
                        if(j > 0)
                        {
                            //System.out.println("down");
                            if(path[i][j - 1] == -1 && !walls[i][j - 1])
                            {
                                path[i][j - 1] = count;
                            }
                        }
                        //up
                        if(j < path[i].length - 1)
                        {
                            //System.out.println("up");
                            if(path[i][j + 1] == -1 && !walls[i][j + 1])
                            {
                                path[i][j + 1] = count;
                            }
                        }
                    }
                }
            }
            count++;
        }
        
    }

    public void printPath()
    {
        for(int i = 0; i < path.length; i++)
        {
            for(int j = 0; j < path[i].length; j++)
            {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        pathfinderv2 p = new pathfinderv2();
    }
}
