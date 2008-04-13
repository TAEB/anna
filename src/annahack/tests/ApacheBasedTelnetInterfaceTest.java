package annahack.tests;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.apache.commons.net.telnet.EchoOptionHandler;
import org.apache.commons.net.telnet.InvalidTelnetOptionException;
import org.apache.commons.net.telnet.SuppressGAOptionHandler;
import org.apache.commons.net.telnet.TelnetClient;
import org.apache.commons.net.telnet.TerminalTypeOptionHandler;

import annahack.telnetconnection.ApacheBasedTelnetInterface;
import annahack.telnetconnection.TelnetInterface;

public class ApacheBasedTelnetInterfaceTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
		throws InvalidTelnetOptionException, IOException, InterruptedException
	{
		TelnetClient tc;
		tc = new TelnetClient();

        TerminalTypeOptionHandler ttopt = new TerminalTypeOptionHandler("VT100", false, false, true, false);
        EchoOptionHandler echoopt = new EchoOptionHandler(true, false, true, false);
        SuppressGAOptionHandler gaopt = new SuppressGAOptionHandler(true, true, true, true);

        tc.addOptionHandler(ttopt);
        tc.addOptionHandler(echoopt);
        tc.addOptionHandler(gaopt);
        
		tc.connect("nethack.kraln.com", 23);
		OutputStream os=tc.getOutputStream();
		
		TelnetInterface connection=new ApacheBasedTelnetInterface(tc);
		
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
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
}
