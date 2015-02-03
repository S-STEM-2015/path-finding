public class SeedTile {

        // Bottom-right Tile (Seed)
        private int[][] brTile;
        
        // Bottom-left Tile (Seed)
        private int[][] blTile;
        
        // Top-right Tile (Seed)
        private int[][] trTile;
        
        // Top-left Tile (Seed)
        private int[][] tlTile;
        
        public final static int SIZE = 5;

        public SeedTile()
        {   
            brTile = new int[SIZE][SIZE];
            blTile = new int[SIZE][SIZE];
            trTile = new int[SIZE][SIZE];
            tlTile = new int[SIZE][SIZE];
            
            
            topLeft();
            topRight();
            bottomLeft();
            bottomRight();
        } 
        
        public void topLeft()
        {
            for (int i = 0; i < tlTile.length; i++)
            {
                for (int j = 0; j < tlTile[i].length; j++)
                {
                //Needs Adjustment
                    
                    
                    if (i%2 == 1)
                    {
                        tlTile[i][j] = 1;
                    }
                    if (j%2 == 1)
                    {
                        tlTile[i][j] = 1;
                        
                    }
                    
                    tlTile[0][j] = 0;
                    tlTile[i][0] = 0;
  

                }
            }
        }
        
        public void topRight()
        {
        	for (int i = 0; i < trTile.length; i++)
            {
                for (int j = 0; j < trTile[i].length; j++)
                {
                //Needs Adjustment
                    
                    
                    if (i%2 == 0)
                    {
                        trTile[i][j] = 1;
                    }
                    if (j%2 == 1)
                    {
                        trTile[i][j] = 1;
                        
                    }
                    
                    trTile[i][trTile[i].length - 1] = 1;
                    trTile[0][i] = 0;
  
                }
            }
        }
        
        public void bottomLeft()
        {
            for (int i = 0; i < blTile.length; i++)
            {
                for (int j = 0; j < blTile[i].length; j++)
                {
                //Needs Adjustment
                    if (i%2 == 1 && j%2 == 1)
                    {
                        blTile[i][j] = 1;
                    }
                    else
                    {
                        blTile[i][j] = 1;
                    }
                }
            }
        }
        
        public void bottomRight()
        {
            for (int i = 0; i < brTile.length; i++)
            {
                for (int j = 0; j < brTile[i].length; j++)
                {
                //Needs Adjustment
                    if (i%2 == 1 && j%2 == 1)
                    {
                        brTile[i][j] = 1;
                    }
                    else
                    {
                        brTile[i][j] = 0;
                    }
                }
            }  
        }
         
// Getters-and-setters are below.
        
        public int[][] getBrTile()
        {
            return brTile;
        }

        public void setBrTile(int[][] brTile)
        {
            this.brTile = brTile;
        }

        public int[][] getBlTile()
        {
            return blTile;
        }

        public void setBlTile(int[][] blTile)
        {
            this.blTile = blTile;
        }

        public int[][] getTrTile()
        {
            return trTile;
        }

        public void setTrTile(int[][] trTile)
        {
            this.trTile = trTile;
        }

        public int[][] getTlTile()
        {
            return tlTile;
        }

        public void setTlTile(int[][] tlTile)
        {
            this.tlTile = tlTile;
        }
        
// "Print" and "toString" methods are here.

        public void printTile(int[][] tile)
        {
            for (int i = 0; i < tile.length; i++)
            {
                for (int j = 0; j < tile[i].length; j++)
                {
                    System.out.print(tile[i][j] + " ");
                }
                System.out.println();
            }
        }



    }

