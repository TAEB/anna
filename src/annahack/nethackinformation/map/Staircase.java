package annahack.nethackinformation.map;

public class Staircase extends Fixture
{
	private boolean up;
	private Tile destinationTile;
	private Map destinationMap;
	/**
	 * 
	 * @param goesup- true for up staircases, false for down staircases
	 */
	public Staircase(boolean goesup)
	{
		super();
		up=goesup;
	}
	
	public Tile getDestinationTile() {
		return destinationTile;
	}

	public void setDestinationTile(Tile destinationTile) {
		this.destinationTile = destinationTile;
	}

	public Map getDestinationMap() {
		return destinationMap;
	}

	public void setDestinationMap(Map destinationMap) {
		this.destinationMap = destinationMap;
	}

	public boolean isUp() {
		return up;
	}
	
	
}
