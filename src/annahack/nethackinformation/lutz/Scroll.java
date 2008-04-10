package annahack.nethackinformation.lutz;

public class Scroll extends GeneralItem implements ItemClass 
{
	protected int weight=5;
	
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
		return '?';
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
		return true;
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
