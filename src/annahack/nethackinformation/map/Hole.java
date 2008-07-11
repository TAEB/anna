package annahack.nethackinformation.map;

public class Hole extends Fixture
{
	private Tile destinationTile;
	private Map destinationMap;
	
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
	
}
