package annahack.nethackparser;

import annahack.telnetconnection.*;
import java.util.Queue;
import java.io.IOException;

public class NetHackParser
{
	private TelnetInterface com;
	private Queue<String> messageBuf;
	private Queue<String> itemsBuf;
	
	public NetHackParser(TelnetInterface com)
	{
		this.com=com;
		messageBuf=new java.util.LinkedList<String>();
	}
	
	/**
	 * @return
	 * 0 if there were no messages,
	 * 1 if there were messages
	 * 2 if there were messages and space needs to be sent (--More--)
	 * 3 if the last message is a prompt
	 */
	public byte checkMessages() throws IOException
	{
		String line;
		line=new String(com.peekLine(0));
		
		if (line.equals("                        "))
		{
			//Nothing
			return 0;
		}else{
			//Something
			int search=line.indexOf("--More--");
			if (search!=-1)
			{
				//Messages and --More--
				String[] msgs=line.substring(0, search).split("  ");
				for (int i=0; i<msgs.length; i++)
				{
					messageBuf.add(msgs[i].trim());
				}
			}else{
				//No --More-- on first line
				search=line.indexOf("Things that are here");
				if (search!=-1)
				{
					//Item list
					for (int i=1;
					(line=new String(com.peekLine(i), search, 80-search).trim()).
						indexOf("--More--")==-1; i++)
					{
						itemsBuf.add(line);
					}
					return 2;
				}else{
					
				}
				
			}
		}
		
		return 0;
	}
}
