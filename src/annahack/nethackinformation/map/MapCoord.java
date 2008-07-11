package annahack.nethackinformation.map;

public class MapCoord 
{
	private int x,y;
	
	public MapCoord(int xpos, int ypos)
	{
		if(xpos>79||xpos<0||ypos>19||ypos<0)
		{
			throw new RuntimeException();
		}
		x = xpos;
		y = ypos;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}
