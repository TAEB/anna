package annahack.telnetconnection;

public class TerminalSymbol
{
	
	public TerminalSymbol(char c)
	{
		this.c=c;
		this.fg=7;
		this.bg=0;
	}
	public TerminalSymbol(char c, byte fg)
	{
		this(c);
		this.fg=fg;
	}
	public TerminalSymbol(char c, byte fg, byte bg)
	{
		this(c, fg);
		this.bg=bg;
	}
	//ANSI codes are 0-7, +8 for bright
	private byte fg;	//character color
	private byte bg;	//background color
	private char c;
	char getChar()
	{
		return c;
	}
	Color getFg()
	{
		return fg;
	}
	Color getBg()
	{
		return bg;
	}
}
