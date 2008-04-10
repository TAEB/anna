package annahack.nethackinformation.lutz;

import annahack.utils.DiceSet;

public class Weapon extends GeneralItem implements ItemClass
{
	protected DiceSet dmg;

	public DiceSet damage()
	{
		return dmg;
	}
	public boolean applyable() 
	{
		return false;
	}

	public boolean dipinable() 
	{
		return false;
	}

	public boolean edible() 
	{
		return false;
	}

	public byte mapCharacter() 
	{
		return ')';
	}

	public boolean putonable() 
	{
		return false;
	}

	public boolean quaffable() 
	{
		return false;
	}

	public boolean readable() 
	{
		return false;
	}

	public boolean wearable() 
	{
		return false;
	}

	public boolean zappable() 
	{
		return false;
	}
}
