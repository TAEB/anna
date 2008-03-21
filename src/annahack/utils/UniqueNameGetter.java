package annahack.utils;

import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UniqueNameGetter
{
	private ThreadedShuffler<String> names;
	public UniqueNameGetter() throws FileNotFoundException, IOException
	{
		{
			//Read in names from file
			BufferedReader fread=new BufferedReader(new FileReader("names"));
			ArrayList<String> namestmp=new ArrayList<String>();
			while (fread.ready())
				namestmp.add(fread.readLine());
			names=new ThreadedShuffler<String>(
				namestmp.toArray(new String[namestmp.size()]));
		}
	}
	
	public String getName()
	{
		String s=makeSuffix(names.getShuffleCount());
		return names.getNext()+s;
	}
	
	private String makeSuffix(int i)
	{
		if (i==0)
			return "";
		else
			return new Integer(i).toString();
	}
	
	private class ThreadedShuffler<T> implements Runnable
	{
		private T[] target;
		private int shufflei;
		private int geti;
		private int shufflecount;
		private Thread shuffler;
		private Random rand;
		
		public ThreadedShuffler(T[] target)
		{
			this.target=target;
			shufflei=0;
			shufflecount=0;
			shuffler=new Thread(this);
			shuffler.start();
			rand=new Random();
		}
		
		private void makeThread()
		{
			shuffler=new Thread(this);
			shuffler.start();
		}
		
		private T tswap;
		private int swapi;
		public void run()
		{
			for (shufflei=0; shufflei<target.length-1; shufflei++)
			{
				swapi=shufflei+rand.nextInt(target.length-shufflei);
				
				tswap=target[shufflei];
				target[shufflei]=target[swapi];
				target[swapi]=tswap;
			}
		}
		
		public T getNext()
		{
			while (geti>=shufflei-1) //Block while waiting for an available item
			{
				try
				{
					Thread.sleep(10);
				}catch(InterruptedException e)
				{
				}
			}
			
			T ret=target[geti++];
			
			//Start another sort if we have expended this array
			if (geti==target.length)
			{
				geti=0;
				shufflei=0;
				shufflecount++;
				makeThread();
			}
			
			return ret;
		}
		
		public int getShuffleCount()
		{
			return shufflecount;
		}
	}
}
