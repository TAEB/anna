package annahack.telnetconnection;

public class TerminalSymbol
{
	
	public TerminalSymbol(byte c)
	{
		this.c=c;
		this.fg=7;
		this.bg=0;
	}
	public TerminalSymbol(byte c, byte fg)
	{
		this(c);
		this.fg=fg;
	}
	public TerminalSymbol(byte c, byte fg, byte bg)
	{
		this(c, fg);
		this.bg=bg;
	}
	//ANSI codes are 0-7, +8 for bright
	private byte fg;	//character color
	private byte bg;	//background color
	private byte c;
	byte getChar()
	{
		return c;
	}
	byte getFg()
	{
		return fg;
	}
	byte getBg()
	{
		return bg;
	}
}
