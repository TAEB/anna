package annahack.telnetconnection;

import java.io.IOException;

public interface TelnetInterface
{
	public void send(byte[] s) throws IOException;
	public void send(char c) throws IOException;
	
	public int getdimx();
	public int getdimy();
	
	public TerminalSymbol peek(int x, int y) throws IOException;
	public char[] peekLine(int x) throws IOException;
	
	public void processData(String data);
	
	public int getcursorx();
	public int getcursory();
}
