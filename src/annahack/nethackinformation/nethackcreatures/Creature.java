package annahack.nethackinformation.nethackcreatures;

public class Creature 
{
	protected int hp, maxhp;
	protected int mp, maxmp;
	protected byte align;
	
	public int getHp()
	{
		return hp;
	}
	
	public int getMaxHp()
	{
		return maxhp;
	}
	
	public int getMaxMp()
	{
		return maxmp;
	}
	
	public int getMp()
	{
		return mp;
	}
}
