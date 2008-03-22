package annahack.nethackinformation.lutz;

public interface ItemClass
{
	public byte mapCharacter();
	
	public boolean dipinable();
	public boolean quaffable();
	public boolean edible();
	public boolean applyable();	//potion of oil can shove it
	public boolean wearable(); //As in armor
	public boolean putonable(); //As in jewelry
	public boolean readable();
	public boolean zappable();
}
