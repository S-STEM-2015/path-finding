public class BranchTile extends SeedTile
{
    private int[][] tile;
    
    public BranchTile()
    { 
        generateTile(0, SIZE);
    }
    
    /*
     * Generates the dungeon tile. Note: I wouldn't 
     * use recursion here. We must fix it 
     * later.
     * 
     * @param x  input
     * @param y  limit of recursion
     */
    public void generateTile(int x, int y)
    {
        
        for (int i = x; i < y; i++)
        {
            for (int j = x; j < y; j++)
            {
                if ((i == x - 1) || (i == y))
                {
                    tile[i][j] = 1;
                }
        
                    
                    if (i == x + 1)
                    {
                        if (j % 2 == 0)
                        {
                            tile[i][j] = 1;
                        }
                    
                    if (y%2 == 1)
                    {
                        if (j % 2 == 0)
                        {
                            tile[i][j] = 1;
                        }
                    }
                    
                    
                }
                if ((j == y - 1) || (j == x))
                {
                    tile[i][j] = 1;
                }

                if (x < y)
                {
                    generateTile(x + 2, y - 2);
                }

            }

        }
        
            tile[tile.length/2][tile[0].length/2] = 8;
        
    }
    
    /*
     * This returns a tile piece in guise of 
     * a two-dimensional array. 
     * 
     * @return tile  a generated tile.
     */
    public int[][] getTile() {
        return tile;
    }

    public void setTile(int[][] tile) {
        this.tile = tile;
    }
}
