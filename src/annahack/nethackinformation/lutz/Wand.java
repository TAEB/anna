package annahack.nethackinformation.lutz;

public class Wand extends GeneralItem implements ItemClass 
{
	protected int charges;
	protected int weight=7;
	
	public int getCharges()
	{
		return charges;
	}
	
	public boolean applyable() 
	{
		return true;
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
		return '/';
	}

	public boolean putonable() 
	{
		return false;
	}
	
	public boolean readable()
	{
		return false;
	}
	
	public boolean quaffable() 
	{
		return false;
	}

	public boolean wearable() 
	{
		return false;
	}
	
	public boolean zappable()
	{
		return true;
	}
}
