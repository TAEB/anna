package annahack.tests;

import org.apache.commons.net.telnet.*;
import annahack.telnetconnection.*;
import annahack.nethackparser.*;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class NetHackParserTest
{
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
		
		NetHackParser nhp=new NetHackParser(connection);
	}
}
