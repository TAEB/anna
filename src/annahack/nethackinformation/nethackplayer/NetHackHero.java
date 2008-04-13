package annahack.nethackinformation.nethackplayer;

public interface NetHackHero
{
	/**
	 * alignment is 0 for neutral, -1 for chaotic, and 1 for lawful
	 **/
	public byte alignment();
	
	/**
	 * Returns true if male or female, false if neither
	 */
	public boolean hasGender();
	
	/**
	 * Returns true if female, false if male or genderless
	 */
	public boolean isFemale();
	
	/**
	 * Returns the player's class
	 */
	public PlayerClass getPlayerClass();

	/**
	 * Returns the player's race
	 */
	public PlayerRace getPlayerRace();
}
