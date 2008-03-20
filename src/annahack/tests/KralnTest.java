package annahack.tests;

import annahack.dglconnection.KralnServer;

public class KralnTest 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Throwable //I'm a bad person
	{
		KralnServer server=new KralnServer();
		if(server.login())
		{
			if(server.startGame())
			{
				System.out.println("Victory");
				server.watch("Jesus");
			}
			else
			{
				System.err.println("startGame failed");
			}
		}
		else
		{
			System.err.println("login failed");
		}
		
	}
}
