 package annahack.dglconnection;

import org.apache.commons.net.telnet.InvalidTelnetOptionException;
import java.io.IOException;
import java.net.SocketException;

public class KralnServer extends GeneralDGLConnector implements DGLServer
{
	public KralnServer() throws InvalidTelnetOptionException, SocketException, IOException
	{
		super();
	}
	public String server()
	{
		return "nethack.kraln.com";
	}
	public boolean login()
	{
		if(super.login())
		{
			try
			{
				connection.send('1');
				loggedIn=true;
				return true;
			}
			catch(IOException e)
			{
				loggedIn=false;
				return false;
			}
		}
		else
		{
			return false;
		}
	}
}
