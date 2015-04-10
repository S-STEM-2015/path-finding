import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Arrays;

import sun.misc.Queue;

public class pathfinder
{
    private int[][] dungeon;
    private path start;
    private path end;
    private ArrayList<path> mainList = new ArrayList<path>();
    private Queue secondList = new Queue();

    public pathfinder(int[][] dungeon)
    {
        this.dungeon = dungeon;
        //look for start
        for(int i = 0; i < dungeon.length;i++)
        	for(int j = 0; j < dungeon[i].length;j++)
        		if(dungeon[i][j] == 3)
        		{
        			start=new path(i,j,0);
        		}
        //look for end
        for(int i = 0; i < dungeon.length;i++)
        	for(int j = 0; j < dungeon[i].length;j++)
        		if(dungeon[i][j] == 4)
        		{
        			end=new path(i,j,-1);

        		}
        if(findPath())
        {
        	printMainList();
        	getPath();
        	
        }
        
    }
    
    private boolean findPath(){
    	int currentI=0;
    	mainList.add(start);
    	while(currentI < mainList.size())
    	{
    		path curPath=mainList.get(currentI);
    		path[] n = curPath.getNeighbor(curPath.getCnt()+1);
    		//TODO: now add to secondList
    		for(int i =0; i < 4; i++)
    		{
    			path obj=n[i];
    			if(!obj.isWall(dungeon) && !isDup(obj)){
    				secondList.enqueue(n[i]);
    			}
    		}
    		while(!secondList.isEmpty())
    		{
    			try {
    				
    				path obj=(path)secondList.dequeue();
						mainList.add(obj);
						if(obj.equal(end))
							return true;
    				
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
    		}
    		
    		currentI++;
    	}
    	return false;
    }
    
    private boolean isDup(path thisV)
    {
    	for(int i = 0; i < mainList.size(); i++)
    	{
    		if(thisV.equal(mainList.get(i)))
    		{
    			return true;
    		}
    	}
    	return false;
    }
    
    private void getPath()
    {
    	ArrayList<path> foundPath = new ArrayList<path>();
    	path obj = mainList.remove(mainList.size()-1);//get the end point
    	int count = obj.getCnt()-1;
    	path[] n = obj.getNeighbor(count);
    	foundPath.add(obj);
    	for(int i = mainList.size()-1;i >= 0; i--)
    	{	
    		
    		obj=mainList.remove(i);
    		if(obj.getCnt()==count)
    		{
    		for(int j = 0; j<4; j++)
    		{
    			if(obj.equal(n[j]))
    			{
    				foundPath.add(obj);
    				count--;
    				n = obj.getNeighbor(count);
    				break;
    			}		
    				
    		}
    		}
    	}
    	mainList = foundPath;
    }
    
    public void printMainList()
    {
    	for(int i = mainList.size()-1; i >= 0; i--)
    	{
    		path obj=mainList.get(i);
    		System.out.println(obj.getX()+" "+obj.getY()+" "+obj.getCnt()+" "+i);
    	
    	}
    }
    
    public ArrayList<path> getMainList(){
    	return mainList;
    }
    

    

}