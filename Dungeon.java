import java.util.Random;

public class Dungeon {
	
	private int width;
	private int height;
	
	// Eventually... change the array type to object!
	private int[][] dungeon;
	
	
	public Dungeon(int width, int height)
	{
		this.width = width;
		this.height = height;
		dungeon = new int[width][height];
		
		for (int i = 0; i < dungeon.length; i++)
		{
			for (int j = 0; j < dungeon[i].length; j++)
			{
				dungeon[i][j] = 0;
			}
		}
	}

	public void generateDungeon(int wid, int hei)
	{
		
		
		for (int i = wid; i < dungeon.length; i++)
		{
			for (int j = hei; j < dungeon[i].length; j++)
			{

				
					dungeon[i][wid] = 1;
					dungeon[wid][j] = 1;
					dungeon[dungeon.length - 1][j] = 1;
					dungeon[i][dungeon[i].length - 1] = 1;
					

			}
			

		}
		
	    if (wid < 3)
	    {
		     generateDungeon(wid + 2, hei);
	    }
		
	}
	public void printDungeon()
	{
		for (int[] val0 : dungeon)
		{
			for (int val : val0)
			{
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
	
	public void populateDungeon()
	{
		
	}
}
