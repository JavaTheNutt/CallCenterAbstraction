/**
 * Created by Joe on 27/07/2015.
 */
public class CallCenter
{
	private Call [] calls;
	private int total;

	public CallCenter (int numberOfCalls)
	{
		calls = new Call[numberOfCalls];
		total = 0;
	}

	public boolean addCall(Call callIn)
	{
		if (!(isFull ()))
		{
			calls[total] = callIn;
			total ++;
			return true;
		}
		return false;
	}

	public boolean isFull()
	{
		if(total == calls.length)
		{
			return true;
		}
		return false;
	}
}
