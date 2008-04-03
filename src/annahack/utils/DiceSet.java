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
		
		System.out.println(min);
		System.out.println(max);
		System.out.println(rolls);
	}
}
