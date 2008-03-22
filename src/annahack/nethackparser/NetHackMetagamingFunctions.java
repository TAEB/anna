package annahack.nethackparser;

import annahack.telnetconnection.TelnetInterface;
import java.io.IOException;

public class NetHackMetagamingFunctions 
{
	private NetHackMetagamingFunctions(){}
	
	/**
	 * Chooses female, human, lawful valkerie at first menu
	 * @param t is the TelnetInterface used to login through a DGLServer
	 * @return false if fails to create character due to IOException, otherwise true
	 */
	
	public static boolean createCharacter(TelnetInterface t) //Makes a female, human, lawful valkerie
	{
		try
		{
			t.send("nvhl  ".getBytes());
			//'n' create character manually
			//'v' valkarie
			//'h' human
			//'l' lawful
			//' ' skip intro
			//' ' skip intro
			return true;
		}
		catch(IOException e)
		{
			return false;
		}
	}
	
	/**
	 * quits out of an in progress game
	 * @param t is the telnetinterface
	 * @return true if quits, false if IOException 
	 */
	public static boolean quitGame(TelnetInterface t)
	{
		try
		{
			t.send((char)27); //quit out of menus
			t.send((char)27); //just in case
			t.send("#q\nyy y y  ".getBytes());//send #quit
			//Quit the game and show all identified stuffs
			return true;
		}
		catch(IOException e)
		{
			return false;
		}
	}
}
