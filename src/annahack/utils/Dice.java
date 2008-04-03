package annahack.utils;

//This is a dirty hack, don't hurt me Alex
public class Dice 
{
	private int num;
	private int max;
	public Dice(String d) throws BadDiceException
	{
		String[] a=d.split("d");
		try
		{
			num=Integer.parseInt(a[0]);
			max=Integer.parseInt(a[1]);
		}
		catch(Exception e)
		{
			throw new BadDiceException();
		}
	}
	
	public int getMax()
	{
		return max;
	}
	
	public int getNum()
	{
		return num;
	}
}
