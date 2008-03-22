package annahack.dglconnection;

import annahack.telnetconnection.TelnetInterface;

public interface DGLServer
{
	public boolean loggedIn();	// user is logged in
	
	public boolean mainMenu();  // at main dgl menu
	
	public boolean inGame();    // control is with nethack
	public boolean spectating();// spectating menu or watching game
	
	public boolean login();		//returns false if unable to login
	public boolean startGame();	// called when loggedIn() && mainMenu(), presses p
	
	public boolean watch(String name) throws Exception; // watches a game
		//return false if target is not playing
		//(other errors should be an exception)
	
	public TelnetInterface dumpInterface();
	/* This should give it's internal TelnetInterface,
	 *	only if (loggedIn() && inGame() || spectating()),
	 *  and return null elsewise
	 * It should remove it internally, and all future
	 *  calls to the functions should fail (NullPointerException is fine)
	 *
	 * This way, after using this class to log in, it can be deallocated.
	 */
}
