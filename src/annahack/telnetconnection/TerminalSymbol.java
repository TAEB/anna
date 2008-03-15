package annahack.telnetconnection;

public class TerminalSymbol
{
	
	public TerminalSymbol(byte c)
	{
		this.c=c;
		this.fg=7;
		this.bg=0;
		this.inverted=false;
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
	public TerminalSymbol(byte c, byte fg, byte bg, boolean inverted)
	{
		this(c, fg, bg);
		this.inverted=inverted;
	}
	//ANSI codes are 0-7, +8 for bright
	private byte fg;	//character color
	private byte bg;	//background color
	private byte c;
	private boolean inverted;
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
	boolean inverted()
	{
		return inverted;
	}
}
