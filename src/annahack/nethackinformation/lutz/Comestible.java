package annahack.nethackinformation.lutz;

public class Comestible extends GeneralItem implements ItemClass
{
	protected int numTurnsToEat;
	
	public int turnsToEat()
	{
		return numTurnsToEat;
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
		return true;
	}

	public byte mapCharacter() 
	{
		return '%';
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

