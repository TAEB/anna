package annahack.nethackinformation.map;

public class Map 
{
	private Tile[][] tiles;
	
	public Map()
	{
		tiles = new Tile[80][20];
	}
	
	public Tile getTile(int x, int y)
	{
		return tiles[x][y];
	}
	
	public void setTile(int x, int y, Tile tile)
	{
		tiles[x][y]=tile;
	}
}
