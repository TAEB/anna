package annahack.dglconnection;

import java.io.IOException;

public interface DGLServer
{
	public boolean loggedIn();	// user is logged in
	
	public boolean mainMenu();  // at main dgl menu
	
	public boolean inGame();    // control is with nethack
	public boolean spectating();// spectating menu or watching game
	
	public boolean login();		//returns false if unable to login
	public boolean startGame();	// called when loggedIn() && mainMenu(), presses p
	
	public boolean watch(String name) throws IOException; // watches a game
	
	
		//return false if target is not playing
		//(other errors should be an exception)
}
