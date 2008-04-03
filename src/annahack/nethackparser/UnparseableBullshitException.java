package annahack.nethackparser;

public class UnparseableBullshitException extends Exception
{
	public UnparseableBullshitException(String probLine)
	{
		super("Could not parse: "+probLine);
	}
}
