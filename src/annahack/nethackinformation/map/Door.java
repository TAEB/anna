package annahack.nethackinformation.map;

public class Door extends Fixture 
{
	private boolean open;
	private boolean locked;
	
	public Door(boolean open)
	{
		this.open=open;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}
}
