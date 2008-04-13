package annahack.nethackinformation.nethackcreatures;

public class Creature 
{
	protected int hp, maxhp;
	protected int mp, maxmp;
	protected byte align;
	protected int st, dx, co, ch, wi, in;
	protected boolean isFemale;
	protected boolean isMale;
	
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
	
	public int getSt()
	{
		return st;
	}

	public byte getAlign() {
		return align;
	}

	public int getDx() {
		return dx;
	}

	public int getCo() {
		return co;
	}

	public int getCh() {
		return ch;
	}

	public int getWi() {
		return wi;
	}

	public int getIn() {
		return in;
	}

	public boolean isFemale() {
		return isFemale;
	}

	public boolean isMale() {
		return isMale;
	}
	
	public boolean hasGender()
	{
		return isFemale ^ isMale;
	}
}
