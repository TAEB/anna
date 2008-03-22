package annahack.nethackinformation.lutz;

import annahack.telnetconnection.TerminalSymbol;

public interface Item
{
	public TerminalSymbol mapCharacter();
	
	public ItemClass itemClass();
	
}
