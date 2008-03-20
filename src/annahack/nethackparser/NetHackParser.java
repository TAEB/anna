package annahack.nethackparser;

import annahack.telnetconnection.*;
import java.util.Queue;

public class NetHackParser
{
	private TelnetInterface com;
	private Queue<String> messageBuf;
	
	public NetHackParser(TelnetInterface com)
	{
		this.com=com;
		messageBuf=new java.util.LinkedList<String>();
	}
	
}
