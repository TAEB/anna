package annahack.nethackinformation.lutz;

public class Armor implements ItemClass
{
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
		return '[';
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
		return true;
	}

	public boolean zappable() 
	{
		return false;
	}
}
