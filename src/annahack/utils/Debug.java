package annahack.utils;

import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Timestamp;

public class Debug 
{
	private static PrintStream p;
	public static void writeLine(String s)
	{
		if(p==null)
		{
			try{p = new PrintStream(new FileOutputStream("anna.log", true));}
			catch(FileNotFoundException e)
			{
				System.err.println(e);
			}
		}
		p.println (new Timestamp(System.currentTimeMillis())+": "+s);
	}
	public static void close()
	{
		if(p!=null)
		{
			p.close();
		}
	}
}
