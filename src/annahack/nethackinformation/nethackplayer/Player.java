package annahack.nethackinformation.nethackplayer;

import annahack.nethackinformation.nethackcreatures.Creature;

public class Player extends Creature implements NetHackHero 
{
	private PlayerClass pClass;
	private PlayerRace pRace;
	private boolean isFem;
	private boolean hasGender;
	
	Player()
	{
		this(new PlayerClass(), new PlayerRace((byte)'v'), true, (byte)1);
	}
	
	Player(PlayerClass pclass, PlayerRace race, boolean isFemale, byte alignment)
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
