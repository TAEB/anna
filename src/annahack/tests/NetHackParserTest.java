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
		//printInterface(connection);
		
		long lastUpdate=connection.getLastUpdate();
		NetHackMetagamingFunctions.createCharacter(connection);
		while(lastUpdate==connection.getLastUpdate()){Thread.sleep(10);}
		//printInterface(connection);
		lastUpdate=connection.getLastUpdate();
		
		NetHackParser nhp=new NetHackParser(connection);
		waitForServer(connection);
		//printInterface(connection);
		while(lastUpdate==connection.getLastUpdate()){Thread.sleep(10);}
		lastUpdate=connection.getLastUpdate();
		/*while(lastUpdate==connection.getLastUpdate()){Thread.sleep(10);}
		lastUpdate=connection.getLastUpdate();*/
		System.out.println(nhp.debug_parseStatusLine());
		Player p = nhp.getPlayer();
		System.out.println(p.getHp());
		
		
		
		NetHackMetagamingFunctions.quitGame(connection);
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
	
	private static void printInterface(TelnetInterface con)
	{
		try{
		for(int i=0; i<24; i++)
		{
			System.out.println(new String(con.peekLine(i)));
		}}catch(Exception e){System.exit(-1);}
	}
	
	private static void waitForServer(TelnetInterface connection)
	{
		
		try{
			while(!connection.waiting())
			{Thread.sleep(100);
			}
		}catch (Exception e){System.out.println(e);}
	}

}
