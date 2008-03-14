package telnetconnection;

import org.apache.commons.net.telnet.EchoOptionHandler;
import org.apache.commons.net.telnet.SuppressGAOptionHandler;
import org.apache.commons.net.telnet.TelnetClient;
import org.apache.commons.net.telnet.TerminalTypeOptionHandler;
import java.net.SocketException;

import org.apache.commons.net.telnet.InvalidTelnetOptionException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;

public class ApacheBasedTelnetInterface implements TelnetInterface
{
	private TelnetClient tc;
	private OutputStream outstr;
	private InputStream instr;
	
	public ApacheBasedTelnetInterface(String server)
		throws SocketException, InvalidTelnetOptionException, IOException
	{
		tc = new TelnetClient();

        TerminalTypeOptionHandler ttopt = new TerminalTypeOptionHandler("VT100", false, false, true, false);
        EchoOptionHandler echoopt = new EchoOptionHandler(true, false, true, false);
        SuppressGAOptionHandler gaopt = new SuppressGAOptionHandler(true, true, true, true);

        tc.addOptionHandler(ttopt);
        tc.addOptionHandler(echoopt);
        tc.addOptionHandler(gaopt);
        
		tc.connect(server, 23);
		
		outstr = tc.getOutputStream();
		instr = tc.getInputStream();
	}
	
	private TerminalSymbol[][] screen=new TerminalSymbol[80][24];
	private int cursorx, cursory;
	
	@Override
	public int getdimx()
	{
		return 24;
	}
	@Override
	public int getdimy()
	{
		return 80;
	}
	@Override
	public int getcursorx()
	{
		return cursorx;
	}
	@Override
	public int getcursory()
	{
		return cursory;
	}

	@Override
	public TerminalSymbol peek(int x, int y) throws IOException
	{
		update();
		return screen[x][y];
	}

	@Override
	public char[] peekLine(int x) throws IOException
	{
		update();
		char[] peek=new char[80];
		for (int y=0; y<80; y++)
		{
			peek[y]=screen[x][y].getChar();
		}
		return peek;
	}

	@Override
	public void send(byte[] s) throws IOException
	{
        outstr.write(s);
        outstr.flush();
	}

	@Override
	public void send(char c) throws IOException
	{
        outstr.write(c);
        outstr.flush();
	}

	@Override
	public void processData(String s)
	{
		// TODO
	}
	
	private void update() throws IOException
	{
		while (instr.available()>0)
		{
			
		}
		// TODO: vt100 stuff goes here!
	}

}
