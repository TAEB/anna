package annahack.dglconnection;

import org.apache.commons.net.telnet.InvalidTelnetOptionException;
import java.io.IOException;
import java.net.SocketException;

public class KralnServer extends GeneralDGLConnector implements DGLServer
{
	public KralnServer() throws InvalidTelnetOptionException, SocketException, IOException
	{
	}
	public String server()
	{
		return "nethack.kraln.com";
	}
}
