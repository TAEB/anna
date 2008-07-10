package annahack.nethackinformation.map;

import annahack.nethackinformation.lutz.Item;
import java.util.ArrayList;

public class Tile 
{
	private byte type; //this is the character for the tile
					   //i.e. a floor tile's type is #
					   //'?' is unknown
	
	private ArrayList<Item> lutz; //Stuff piled atop the square
	private boolean lutzKnown;
	
	public Tile()
	{
		lutzKnown=false;
		type='?';
		lutz=new ArrayList<Item>();
	}
	
	public Tile(byte tipe, boolean areLutzKnown, ArrayList<Item> items)
	{
		lutzKnown = areLutzKnown;
		type=tipe;
		lutzKnown=areLutzKnown;
	}
}
