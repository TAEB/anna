package annahack.tests;

import org.apache.commons.net.telnet.*;
import annahack.telnetconnection.*;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class OSBasedTelnetInterfaceTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
		throws InvalidTelnetOptionException, IOException, InterruptedException
	{
		Process tc=Runtime.getRuntime().exec("telnet nethack.alt.org");
		
		TelnetInterface connection=new OSBasedTelnetInterface(tc);
		
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		connection.send('l');
		
		while (true)
		{
			Thread.sleep(1000);
			while (connection.timeSinceUpdate()<1000)	//this is high
			{
				System.out.println(connection.timeSinceUpdate());
				System.out.println("not waiting...");
				Thread.sleep(100);
			}
			for (int i=0; i<24; i++)
			{
				for (int j=0; j<80; j++)
					System.out.print((char)(connection.peek(i, j).getChar()));
				System.out.println();
			}
			
			String input=in.readLine();
			System.out.println("read.");
			if (input.startsWith("\\n"))
				connection.send('\n');
			else
				connection.send(input.getBytes());
		}
	}
	
	static char[] bytesToChars(byte[] in)
	{
		char[] out=new char[in.length];
		for (int i=0; i<in.length; i++)
			out[i]=(char)in[i];
		return out;
	}

}
