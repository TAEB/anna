package annahack.dglconnection;

import org.apache.commons.net.telnet.InvalidTelnetOptionException;
import java.io.IOException;
import java.net.SocketException;

public class KralnServer extends GeneralDGLConnector implements DGLServer
{
	private boolean spectating, mainMenu, inGame, loggedIn;
	
	
	public KralnServer() throws InvalidTelnetOptionException, SocketException, IOException
	{
		super();
		spectating = false;
		mainMenu=false;
		inGame=false;
		loggedIn=true;
	}
	public String server()
	{
		return "nethack.kraln.com";
	}
	public boolean spectating()
	{
		//TODO
		return false;
	}
	public boolean watch(String game)
	{
		//TODO
		return false;	
	}
	public boolean loggedIn()
	{
		//TODO
		return false;
	}
	public boolean mainMenu()
	{
		//TODO
		return false;
	}
	public boolean inGame()
	{
		//TODO
		return false;
	}
	public boolean login()
	{
		//TODO
		return false;
	}
	public void startGame()
	{
		//TODO
		System.err.println("Method not implemented");
	}
}
