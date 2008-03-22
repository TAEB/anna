package annahack.nethackinformation.nethackcreatures;

import annahack.nethackinformation.nethackplayer.*;

public class TheHero implements NetHackHero 
{
	private byte align;
	private PlayerClass pClass;
	private PlayerRace pRace;
	private boolean isFem;
	private boolean hasGender;
	
	public TheHero()
	{
		this(new PlayerClass(), new PlayerRace((byte)'v'), true, (byte)1);
	}
	
	public TheHero(PlayerClass pclass, PlayerRace race, boolean isFemale, byte alignment)
	{
		pClass=pclass;
		pRace=race;
		isFem=isFemale;
		hasGender=true;
		align=alignment;
	}
	
	public boolean isFemale()
	{
		return isFem;
	}
	
	public boolean hasGender()
	{
		return hasGender;
	}
	
	public PlayerClass getPlayerClass()
	{
		return pClass;
	}
	
	public PlayerRace getPlayerRace()
	{
		return pRace;
	}
	
	public byte alignment()
	{
		return align;
	}
}
