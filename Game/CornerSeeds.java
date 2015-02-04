/* CornerSeeds.java
 * 
 * Interface class holds hard coded 
 * "seed" corner map tiles. 
 * 
 * @author Wilton Latham
 * @version 0.18
 * @date 02-03-2015
 * 
 */
interface CornerSeeds {
    
        // Top-left Tile (Seed)
        static final int[][] TLTILE = 
        {{0,0,0,0,0},
         {0,1,1,1,1},
         {0,1,0,1,0},
         {0,1,1,1,1},
         {0,1,0,1,0}};
        
        // Top-right Tile (Seed)
        static final int[][] TRTILE = 
        {{0,0,0,0,0},
         {1,1,1,1,0},
         {0,1,0,1,0},
         {1,1,1,1,0},
         {0,1,0,1,0}};
        
        // Bottom-left Tile (Seed)
        static final int[][] BLTILE = 
        {{0,1,0,1,0},
         {0,1,1,1,1},
         {0,1,0,1,0},
         {0,1,1,1,1},
         {0,0,0,0,0}};
        
        // Bottom-right Tile (Seed)
        static final int[][] BRTILE =
        {{0,1,0,1,0},
         {1,1,1,1,0},
         {0,1,0,1,0},
         {1,1,1,1,0},
         {0,0,0,0,0}};
        
        // Standardized size for every board and tile.
        static final int SIZE = 5;
    }

