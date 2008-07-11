package annahack.nethackinformation.map;

import annahack.nethackinformation.lutz.Item;
import java.util.ArrayList;

public class Tile 
{
	private Fixture fixture; //this is the character for the tile
					   //i.e. a floor tile's type is #
					   //'?' is unknown
	
	private ArrayList<Item> lutz; //Stuff piled atop the square
	private boolean lutzKnown, fixtureKnown;
	
	public Tile()
	{
		lutzKnown=false;
		fixtureKnown=false;
		fixture=null;
		lutz=new ArrayList<Item>();
	}
	
	public Tile(boolean isFixtureKnown, Fixture fixture, boolean areItemsKnown, ArrayList<Item> items)
	{
		lutzKnown = areItemsKnown;
		fixtureKnown=isFixtureKnown;
		this.fixture = fixture;
		lutz = items;
	}

	public Fixture getFixture() {
		return fixture;
	}

	public void setFixture(Fixture fixture) {
		this.fixture = fixture;
	}

	public boolean isFixtureKnown() {
		return fixtureKnown;
	}

	public void setFixtureKnown(boolean fixtureKnown) {
		this.fixtureKnown = fixtureKnown;
	}

	public ArrayList<Item> getLutz() {
		return lutz;
	}

	public void setLutz(ArrayList<Item> lutz) {
		this.lutz = lutz;
	}

	public boolean isLutzKnown() {
		return lutzKnown;
	}

	public void setLutzKnown(boolean lutzKnown) {
		this.lutzKnown = lutzKnown;
	}

	
}
