package annahack.tests;

import org.apache.commons.net.telnet.*;
import annahack.telnetconnection.*;
import annahack.nethackparser.*;
import annahack.dglconnection.*;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class NetHackParserTest
{
	public static void main(String[] args) throws Exception
	{
		NetHackParser nhp=new NetHackParser(getLoggedInInterface());
		
		
	}
	
	/*
	 * A method like this might be useful outside of testing,
	 * but it would require modification to be more robust
	 */
	private static TelnetInterface getLoggedInInterface() throws Exception
	{
		DGLServer kraln=new KralnServer();
		if (!kraln.login())
		{
			System.out.println("Login failed!");
			return null;
		}
		if (!kraln.startGame())
		{
			System.out.println("Game start failed!");
			return null;
		}
		return kraln.dumpInterface();
	}
}
