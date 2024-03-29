package annahack.telnetconnection;

import java.net.SocketException;
import org.apache.commons.net.telnet.InvalidTelnetOptionException;
import java.io.IOException;
import java.io.OutputStream;

public class OSBasedTelnetInterface extends EmulatorVT100 implements TelnetInterface
{
	private OutputStream outstr;
	Thread updater;
	Process tc;
	
	public OSBasedTelnetInterface(Process telnet)
		throws SocketException, InvalidTelnetOptionException, IOException
	{
		super(new TerminalSymbol[24][80], telnet.getInputStream());
		
		for (int i=0; i<24; i++)
			for (int j=0; j<80; j++)
				screen[i][j]=new TerminalSymbol();
		
		this.tc=telnet;
		outstr=this.tc.getOutputStream();
		
		updater=new Thread(this);
		updater.start();
	}
	
	//@Override
	public int getdimx()
	{
		return 24;
	}
	//@Override
	public int getdimy()
	{
		return 80;
	}
	//@Override
	public int getcursorx()
	{
		return x;
	}
	//@Override
	public int getcursory()
	{
		return y;
	}

	//@Override
	public TerminalSymbol peek(int x, int y) throws IOException
	{
		return screen[x][y];
	}

	//@Override
	public byte[] peekLine(int x) throws IOException
	{
		byte[] peek=new byte[80];
		for (int y=0; y<80; y++)
		{
			peek[y]=screen[x][y].getChar();
		}
		return peek;
	}

	//@Override
	public void send(byte[] s) throws IOException
	{
        outstr.write(s);
        outstr.flush();
	}

	public void send(char c) throws IOException
	{
        outstr.write(c);
        outstr.flush();
	}
	
	public boolean waiting() throws InterruptedException, IOException
	{
		return false;
	}
	
	public void startUpdating()
	{
		updater.notify();
	}
	
	public void stopUpdating()
	{
		updater.interrupt();
	}
	
	public long timeSinceUpdate()
	{
		return System.currentTimeMillis()-lastUpdate;
	}
}
