package annahack.telnetconnection;

import org.apache.commons.net.telnet.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

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
		
		TelnetInterface connection=new ApacheBasedTelnetInterface(tc);
		
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		while (true)
		{
			while (!connection.waiting())
			{
				System.out.println("not waiting...");
				Thread.sleep(100);
			}
			for (int i=0; i<24; i++)
				System.out.println(new String(connection.peekLine(i)));
			String input=in.readLine();
			connection.send(input.getBytes());
		}
	}

}
