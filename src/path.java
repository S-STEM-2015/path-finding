
public class path {
	private int x;
	private int y;
	private int cnt;
	public path(int x, int y, int cnt)
	{
		this.x=x;
		this.y=y;
		this.cnt = cnt;
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getCnt() {
		return cnt;
	}
	public path[] getNeighbor(int cnt)
	{
		path[] n = new path[4];
		//get left
		n[0]=new path(x-1,y,cnt);
		//get top
		n[1]=new path(x,y+1,cnt);
		//get right
		n[2]=new path(x+1,y,cnt);
		//get bottom
		n[3]=new path(x,y-1,cnt);
		return n;
	}
	public boolean isWall(int[][] dungeon)
	{
		if( x < 0 || y < 0 || x > dungeon.length-1|| y>dungeon[x].length-1 || dungeon[x][y] == 0 )
			return true;
		return false;
	}
	
	
	public boolean equal(path v)
	{
		if(x==v.getX() && y==v.getY())
			return true;
		return false;
	}
	
}
