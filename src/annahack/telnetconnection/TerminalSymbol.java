package annahack.telnetconnection;

public class TerminalSymbol
{
	public TerminalSymbol()
	{
		this((byte)' ');	
	}
	
	public TerminalSymbol(byte c)
	{
		this(c, (byte)7);
	}
	public TerminalSymbol(byte c, byte fg)
	{
		this(c, fg, (byte)0);
	}
	public TerminalSymbol(byte c, byte fg, byte bg)
	{
		this(c, fg, bg, false);
	}
	public TerminalSymbol(byte c, byte fg, byte bg, boolean inverted)
	{
		this.c=c;
		this.fg=fg;
		this.bg=bg;
		this.inverted=false;
		this.inverted=inverted;
	}
	//ANSI codes are 0-7, +8 for bright
	private byte fg;	//character color
	private byte bg;	//background color
	private byte c;
	private boolean inverted;
	public byte getChar()
	{
		return c;
	}
	public byte getFg()
	{
		return fg;
	}
	public byte getBg()
	{
		return bg;
	}
	public boolean inverted()
	{
		return inverted;
	}
}
