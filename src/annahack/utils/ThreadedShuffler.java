package annahack.utils;

import java.util.Random;

public class ThreadedShuffler<T> implements Runnable
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
