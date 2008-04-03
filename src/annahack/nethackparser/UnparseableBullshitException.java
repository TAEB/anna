package annahack.nethackparser;

public class UnparseableBullshitException extends RuntimeException
{
	public UnparseableBullshitException(String probLine)
	{
		super("Could not parse: "+probLine);
	}
}
