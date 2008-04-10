package annahack.nethackinformation.lutz;

public class Amulet extends GeneralItem implements ItemClass 
{
	protected int weight=20;
	protected int value=150;
	
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
		return '\"';
	}

	public boolean putonable() 
	{
		return true;
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
