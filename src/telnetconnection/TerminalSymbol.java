package telnetconnection;

import java.awt.Color;

public class TerminalSymbol
{
	public TerminalSymbol(char c)
	{
		this.c=c;
		this.fg=Color.GRAY;
		this.bg=Color.BLACK;
	}
	public TerminalSymbol(char c, Color fg)
	{
		this(c);
		this.fg=fg;
	}
	public TerminalSymbol(char c, Color fg, Color bg)
	{
		this(c, fg);
		this.bg=bg;
	}
	private char c;
	private Color fg;	//character color
	private Color bg;	//background color
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
