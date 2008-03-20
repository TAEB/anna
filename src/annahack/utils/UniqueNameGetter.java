package annahack.utils;

import java.util.ArrayList;
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
}
