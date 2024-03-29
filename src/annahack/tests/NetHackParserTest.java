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

		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		{
			String input="!done";
			boolean repeat=false;
			
			while (!input.equals("done"))
			{
				Thread.sleep(1000);
				do
				{
					while (connection.timeSinceUpdate()<1000)	//this is high
					{
						System.out.println(connection.timeSinceUpdate());
						System.out.println("not waiting...");
						Thread.sleep(100);
					}
					
					switch (nhp.checkMessages())
					{
					case 1:
						while (nhp.hasMessages())
							System.out.println(nhp.popMessage());
					case 0:
						repeat=false;
						break;
					case 2:
						while (nhp.hasMessages())
							System.out.println(nhp.popMessage());
						connection.send(' ');
						repeat=true;
						break;
					case 3:
						while (nhp.hasMessages())
							System.out.println(nhp.popMessage());
						System.out.print("Your answer: ");
						connection.send((in.readLine()+"\n").getBytes());
						repeat=true;
						break;
					}
					
				} while (repeat);

				for (int i=0; i<24; i++)
				{
					for (int j=0; j<80; j++)
						System.out.print((char)(connection.peek(i, j).getChar()));
					System.out.println();
				}
				
				input=in.readLine();
				System.out.println("read.");
				if (input.startsWith("\\n"))
					connection.send('\n');
				else
					connection.send(input.getBytes());
			}
		}
		
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
