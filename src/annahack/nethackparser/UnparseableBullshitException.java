package annahack.nethackparser;

public class UnparseableBullshitException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7598228959723408767L;

	public UnparseableBullshitException(String probLine)
	{
		super("Could not parse: "+probLine+"\nIt is bullshit.");
	}
}
