
    /* cd $HOME/git/Preston/Path-Finding/Visuals
     * git add .
     * git commit -m 'description of change'
     * git push origin HEAD:Preston
     * 
     */
    import java.util.ArrayList;
    import java.util.Random;
    public class Visuals
    {
        
        private Random r = new Random();
        private int[][] map;
        private ArrayList<int[][]> maps = new ArrayList<int[][]>();

        public void AssignMaps(int howMuch)
        {
            //neighbor chooses a random neighbor for each inner index (not 1st or last columns/rows).
            Random neighbor = new Random();
            int count = 0;
            while (count < howMuch)
            {
                map = new int[5][5];
                map[0][0] = 1;
                map[4][0] = 1;
                map[0][4] = 1;
                map[4][4] = 1;
                for (int i = 1; i < map.length - 1; i++)
                {
                    for (int j = 1; j < map[i].length - 1; j++)
                    {
                    		map[i][j] = r.nextInt(2);
                    }
                }
                for (int i = 1; i < map.length - 1; i++)
                {
                    for (int j = 1; j < map[i].length - 1; j++)
                    {
                        int[] innerMap = {map[i + 1][j], map[i - 1][j], map[i][j + 1], map[i][j - 1]};
                        if (map[i + 1][j] + map[i][j + 1] + map[i][j - 1] + map[i - 1][j] == 0)
                        {
                            int index = neighbor.nextInt(innerMap.length);
                            innerMap[index] = 1;
                            map[i + 1][j] = innerMap[0];
                            map[i - 1][j] = innerMap[1];
                            map[i][j + 1] = innerMap[2];
                            map[i][j - 1] = innerMap[3];
                        }
                        if ((i == 3 && j == 3) && map[i][j + 1] == 0 && map[i + 1][j] == 0)
                        {
                            int test = new Random().nextInt(2);
                            if (test == 1)
                            {
                                map[i][j + 1] = 1;
                            }    
                            else
                            {
                                map[i + 1][j] = 1;
                            }
                           
                        }
                        if ((i == 1 && j == 1) && map[i][j - 1] == 0 && map[i - 1][j] == 0)
                        {
                            int test = new Random().nextInt(2);
                            if (test == 1)
                            {
                                map[i][j - 1] = 1;
                            }    
                            else
                            {
                                map[i - 1][j] = 1;
                            }
                           
                        }
                        if ((i == 1 && j == 3) && map[i][j + 1] == 0 && map[i - 1][j] == 0)
                        {
                            int test = new Random().nextInt(2);
                            if (test == 1)
                            {
                                map[i][j + 1] = 1;
                            }    
                            else
                            {
                                map[i - 1][j] = 1;
                            }
                           
                        }
                        if ((i == 3 && j == 1) && map[i][j - 1] == 0 && map[i + 1][j] == 0)
                        {
                            int test = new Random().nextInt(2);
                            if (test == 1)
                            {
                                map[i][j - 1] = 1;
                            }    
                            else
                            {
                                map[i + 1][j] = 1;
                            }
                           
                        }
                    }
                }
                maps.add(map);
                count++;
            }
            
        }
        
        public void printMaps()
        {
            int count = 0;
            while (count < maps.size())
            {
                int[][] array = maps.get(count);
                for (int i = 0; i < array.length; i++)
                {
                    for (int j = 0; j < array[i].length; j++)
                    {
                        System.out.print(array[i][j] + " ");
                    }
                    System.out.println("");
                }
                System.out.println("");
                count++;
            }
            
        }
        
        //Getters-and-Setters 
        public ArrayList<int[][]> getMaps()
        {
            return maps;
        }

        public void setMaps(ArrayList<int[][]> maps)
        {
            this.maps = maps;
        }
        
        public static void main(String[] args)
        {
            Visuals v = new Visuals();
            v.AssignMaps(10);
            v.printMaps();
        }
        
    }

