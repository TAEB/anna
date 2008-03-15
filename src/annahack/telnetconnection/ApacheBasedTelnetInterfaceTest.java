package annahack.telnetconnection;

import org.apache.commons.net.telnet.*;
import java.io.IOException;

public class ApacheBasedTelnetInterfaceTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
		throws InvalidTelnetOptionException, IOException
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
	}

}
