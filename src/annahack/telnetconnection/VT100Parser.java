package annahack.telnetconnection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
import java.util.LinkedList;

public class VT100Parser implements Runnable
{
	private InputStream consoleData;
	private Thread parsebot;
	private boolean running;
	private Queue<ConsoleInstruction> instrbuf;
	
	public VT100Parser(InputStream consoleData)
	{
		instrbuf=new LinkedList<ConsoleInstruction>();
		this.consoleData=consoleData;
		parsebot=new Thread(this);
		parsebot.run();
	}
	
	public boolean instructionWaiting()
	{
		return instrbuf.isEmpty();
	}
	
	public ConsoleInstruction nextInstruction()
	{
		return instrbuf.poll();
	}
	
	public void update()
	{
		
	}
	
	public void startThread()
	{
		if (!running)
		{
			running=true;
			parsebot.run();
		}
	}
	
	public void stopThread() throws InterruptedException
	{
		if (running)
		{
			running=false;
			parsebot.join();
		}
	}
	
	public void run()
	{
		if (parsebot==Thread.currentThread())
		{
			try
			{
				while (running)
				{
					while ((consoleData.available())>0)
					{
						update();
					}
					try
					{
						Thread.sleep(10);
					}catch (InterruptedException e)
					{
						e.printStackTrace();
						running=false;
					}
				}
			}catch (IOException e)
			{
				e.printStackTrace();
				running=false;
			}
		}
	}
}
