package annahack.dglconnection;

import annahack.telnetconnection.TelnetInterface;

public interface DGLServer
{
	/**
	 * is the user logged in?
	 */
	public boolean loggedIn();
	
	/**
	 * is the user at the main DGL menu?
	 */
	public boolean mainMenu();  // at main dgl menu
	
	/**
	 * control is with nethack
	 */
	public boolean inGame();    // control is with nethack
	
	/**
	 * spectating menu or watching game
	 */
	public boolean spectating();// spectating menu or watching game
	
	/**
	 * Returns false if unable to login
	 */
	public boolean login();		//returns false if unable to login
	
	/**
	 * called when loggedIn && mainMenu(), presses p
	 * @return
	 */
	public boolean startGame();	// called when loggedIn() && mainMenu(), presses p
	
	/**
	 * watches a game
	 * returns false is target is not playing
	 */
	public boolean watch(String name) throws Exception; // watches a game
		//return false if target is not playing
		//(other errors should be an exception)
	
	/** This should give it's internal TelnetInterface,
	 *	only if (loggedIn() && inGame() || spectating()),
	 *  and return null elsewise
	 * It should remove it internally, and all future
	 *  calls to the functions should fail (NullPointerException is fine)
	 *
	 * This way, after using this class to log in, it can be deallocated.
	 */
	public TelnetInterface dumpInterface();
	
}
