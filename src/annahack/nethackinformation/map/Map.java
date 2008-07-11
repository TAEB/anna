package annahack.nethackinformation.map;

import java.util.ArrayList;

public class Map 
{
	private Tile[][] tiles;
	private ArrayList<MapCoord> staircases, fountains, sinks, traps, interesting;
	
	
	public Map()
	{
		tiles = new Tile[80][20];
		staircases = new ArrayList<MapCoord>();
		fountains = new ArrayList<MapCoord>();
		sinks = new ArrayList<MapCoord>();
		traps = new ArrayList<MapCoord>();
	}
	
	public Tile getTile(MapCoord mc)
	{
		return tiles[mc.getX()][mc.getY()];
	}
	
	public void setTile(MapCoord mc, Tile tile)
	{
		tiles[mc.getX()][mc.getY()]=tile;
		
		//does the tile have a fixture?
		if(tile.getFixture()!=null)
		{
			interesting.add(mc);
			String type = tile.getFixture().getClass().getName();
			if(type.equals("Staircase"))
			{
				staircases.add(mc);
			}
			else if(type.equals("Fountain"))
			{
				fountains.add(mc);
			}
			else if(type.equals("Trap"))
			{
				traps.add(mc);
			}
			else if(type.equals("Sinks"))
			{
				sinks.add(mc);
			}
		}
	}

	public ArrayList<MapCoord> getStaircases() {
		return staircases;
	}

	public ArrayList<MapCoord> getFountains() {
		return fountains;
	}

	public ArrayList<MapCoord> getSinks() {
		return sinks;
	}

	public ArrayList<MapCoord> getTraps() {
		return traps;
	}
	
	public ArrayList<MapCoord> getInteresting()
	{
		return interesting;
	}
}
