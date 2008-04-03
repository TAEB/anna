package annahack.utils;

import java.util.ArrayList;

public class DiceSet 
{
	private double average, stdDev;
	private ArrayList<Dice> dice=new ArrayList<Dice>();
	public DiceSet(String d) throws BadDiceException
	{
		String set=d;
		String[] a=d.split("\\+");
		
		int min=0;
		int max=0;
		int sum=0;
		int rolls=1;
		for(int i=0; i<a.length; i++)
		{
			dice.add(new Dice(a[i]));
		}
		
		for(int i=0; i<dice.size(); i++)
		{
			for(int k=0; k<dice.get(i).getNum(); k++)
			{
				min+=1;
				max+=dice.get(i).getMax();
				rolls*=dice.get(i).getMax();
			}
		}
		
		int[] bins = new int[max+1]; //It will be easier this way, I swear
		bins[0] = 1;
		//Begin Dirty Hack (a la Chris)
		for(int i=0; i<dice.size(); i++)
		{
			for(int j=0; j<dice.get(i).getNum(); j++)
			{
				int[] temp = new int[max+1];
				
				for(int k=1; k<=dice.get(i).getMax(); k++)
				{
					for(int aa = 0; aa < max+1-k;aa++)
					{
						temp[aa+k] += bins[aa];
					}
				}
				
				bins = temp;
			}
		}
		//End Dirty Hack
		
		for(int i=0; i<bins.length; i++)
		{
			System.out.println(bins[i]);
		}
		System.out.println();
		System.out.println(min);
		System.out.println(max);
		System.out.println(rolls);
	}
}
