package annahack.dglconnection;

import org.apache.commons.net.telnet.*;
import java.net.SocketException;
import java.io.IOException;
import org.apache.commons.net.telnet.InvalidTelnetOptionException;
import annahack.telnetconnection.*;

abstract class GeneralDGLConnector
{
	ApacheBasedTelnetInterface connection;
	
	public GeneralDGLConnector()
		throws SocketException, IOException, InvalidTelnetOptionException
	{
		TelnetClient tc;
		tc = new TelnetClient();

        TerminalTypeOptionHandler ttopt = new TerminalTypeOptionHandler("VT100", false, false, true, false);
        EchoOptionHandler echoopt = new EchoOptionHandler(true, false, true, false);
        SuppressGAOptionHandler gaopt = new SuppressGAOptionHandler(true, true, true, true);

        tc.addOptionHandler(ttopt);
        tc.addOptionHandler(echoopt);
        tc.addOptionHandler(gaopt);
        
		tc.connect(server(), 23);
		
		connection=new ApacheBasedTelnetInterface(tc);
	}
	
	abstract String server();
	
	public boolean inGame()
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
	
	public boolean spectating()
	{
		//TODO
		return false;
	}
	
	public void startGame()
	{
		//TODO
	}
	
	public boolean watch(String name)
	{
		//TODO
		return false;
	}
}
