package dglconnection;

public interface DGLServer
{
	public boolean loggedIn();	// user is logged in
	
	public boolean mainMenu();  // at main dgl menu
	
	public boolean inGame();    // control is with nethack
	public boolean spectating();// spectating menu or watching game
	
	public void startGame();	// called when mainMenu(), presses p
	
	public boolean watch(String name); // watches a game
		//return false if target is not playing
		//(other errors should be an exception)
}
