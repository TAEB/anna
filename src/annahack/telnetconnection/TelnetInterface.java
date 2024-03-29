package annahack.telnetconnection;

import java.io.IOException;

public interface TelnetInterface
{
	public void send(byte[] s) throws IOException;
	public void send(char c) throws IOException;
	
	public int getdimx();
	public int getdimy();
	
	public TerminalSymbol peek(int x, int y) throws IOException;
	public byte[] peekLine(int x) throws IOException;
	
	public int getcursorx();
	public int getcursory();
	
	public long timeSinceUpdate();
	public long getLastUpdate();
	/**
	 * 
	 * @return true if server is ready for input
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public boolean waiting() throws InterruptedException, IOException;
}
