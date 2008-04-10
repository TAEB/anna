package annahack.nethackinformation.lutz;

public class Potion extends GeneralItem implements ItemClass
{
	public boolean applyable() 
	{
		return false;
	}

	public boolean dipinable()
	{
		return true;
	}
	
	public boolean edible() 
	{
		return false;
	}

	public byte mapCharacter() 
	{
		return '!';
	}

	public boolean putonable() 
	{
		return false;
	}

	public boolean quaffable() 
	{
		return true;
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
