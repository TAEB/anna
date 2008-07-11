package annahack.nethackinformation.map;

public class Map 
{
	private Tile[][] tiles;
	
	public Map()
	{
		tiles = new Tile[80][20];
	}
	
	public Tile getTile(MapCoord mc)
	{
		return tiles[mc.getX()][mc.getY()];
	}
	
	public void setTile(MapCoord mc, Tile tile)
	{
		tiles[mc.getX()][mc.getY()]=tile;
	}
}
