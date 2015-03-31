import java.util.ArrayList;
//test

public class pathfinder
{
    boolean[][] walls;
    int[][] path;
    int[][] instructions;
    int startx = 0;
    int starty = 1;
    int endx = 24;
    int endy = 23;
    public pathfinder(Dungeon d)
    {    
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
            }
        }
        path[endx][endy] = 0;
        writePaths();
    }

    
    public void writePaths()
    {
        int count = 1;
        boolean infinite = false;
        
        while(path[startx][starty] == -1 || !infinite)
        {
            for(int i = 0; i < path.length; i++)
            {
                for(int j = 0; j < path[i].length; j++)
                {
                	infinite = true;
                    if(path[i][j] == count - 1)
                    {
                        //left
                        if(i > 0)
                        {
                            if(path[i - 1][j] == -1 && !walls[i - 1][j])
                            {
                                infinite = false;
                                path[i - 1][j] = count;
                            }
                        }
                        //right
                        if(i < path.length - 1)
                        {
                            if(path[i + 1][j] == -1 && !walls[i + 1][j])
                            {
                            	infinite = false;
                                path[i + 1][j] = count;
                            }
                        } 
                        //down
                        if(j > 0)
                        {
                            if(path[i][j - 1] == -1 && !walls[i][j - 1])
                            {
                            	infinite = false;
                                path[i][j - 1] = count;
                            }
                        }
                        //up
                        if(j < path[i].length - 1)
                        {
                            if(path[i][j + 1] == -1 && !walls[i][j + 1])
                            {
                            	infinite = false;
                                path[i][j + 1] = count;
                            }
                        }
                    }
                }
            }
            count++;
            
        }
        instructions = new int[count][2];
        instructions[0][0] = startx;
        instructions[0][1] = starty;
        int i = 0;
        while(instructions[i][0] != endx && instructions[i][1] != endy)
        {
            int x = instructions[i][0];
            int y = instructions[i][1];
            if(x < 0 || x > path.length || y < 0 || y > path.length)
            {
            	
            	break;
            }
            i++;
            if(path[x + 1][y] == path[x][y] - 1)
            {
                instructions[i][0] = x + 1;
                instructions[i][1] = y;
            }

            else if(path[x - 1][y] == path[x][y] - 1)
            {
                instructions[i][0] = x - 1;
                instructions[i][1] = y;
            }

            else if(path[x][y + 1] == path[x][y] - 1)
            {
                instructions[i][0] = x;
                instructions[i][1] = y + 1;
            }

            else if(path[x][y - 1] == path[x][y] - 1)
            {
                instructions[i][0] = x;
                instructions[i][0] = y - 1;
            }
        }
    }

    public int[][] getInstructions()
    {
        return instructions;
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

        for(int i = 0; i < instructions.length; i++)
        {
            for(int j = 0; j < instructions[i].length; j++)
            {
                System.out.print(instructions[i][j] + " ");
            }
            System.out.println();
        }
    }
}
