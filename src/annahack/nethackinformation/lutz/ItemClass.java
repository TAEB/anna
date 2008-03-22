package annahack.nethackinformation.lutz;

public interface ItemClass
{
	public byte mapCharacter();
	
	public boolean quaffable();
	public boolean edible();
	public boolean applyable();	//potion of oil can shove it
	public boolean wearable();
	public boolean putonable();
}
