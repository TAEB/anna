package annahack.utils;

public class StringFunctions 
{
	public static char[] bytesToChars(byte[] in)
	{
		char[] out=new char[in.length];
		for (int i=0; i<in.length; i++)
			out[i]=(char)in[i];
		return out;
	}
}
