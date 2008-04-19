package annahack.tests;

import org.apache.commons.net.telnet.*;
import annahack.telnetconnection.*;
import annahack.nethackinformation.nethackplayer.Player;
import annahack.nethackparser.*;
import annahack.dglconnection.*;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class NetHackParserTest
{
	public static void main(String[] args) throws Exception
	{
		//NetHackParser nhp=new NetHackParser(getLoggedInInterface());
		
		TelnetInterface connection = getLoggedInInterface();
		Thread.sleep(10000);
		printInterface(connection);
		NetHackMetagamingFunctions.createCharacter(connection);
		Thread.sleep(1000);
		printInterface(connection);
		NetHackParser nhp=new NetHackParser(connection);
		Thread.sleep(1000);
		printInterface(connection);
		Player p = nhp.getPlayer();
		System.out.println(p.getHp());
		
		//NetHackMetagamingFunctions.quitGame(connection);
	}
	
	/*
	 * A method like this might be useful outside of testing,
	 * but it would require modification to be more robust
	 */
	private static TelnetInterface getLoggedInInterface() throws Exception
	{
		DGLServer kraln=new KralnServer();
		if (!kraln.login())
		{
			System.out.println("Login failed!");
			return null;
		}
		if (!kraln.startGame())
		{
			System.out.println("Game start failed!");
			return null;
		}
		return kraln.dumpInterface();
	}
	
	

}
