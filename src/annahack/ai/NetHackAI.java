package annahack.ai;

import java.util.Collection;
import annahack.nethackinformation.lutz.Item;

public interface NetHackAI 
{
	public void update(); //Called at the begining of each turn
	public Collection<Item> selectMenuOptions(String menu, Collection<Item> lutz); //choose items given a set thereof
	
}
