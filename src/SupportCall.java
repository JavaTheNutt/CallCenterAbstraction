/**
 * Created by Joe on 27/07/2015.
 */
public class SupportCall extends Call
{
	private String item;
	private String error;
	private String ticketNo;

	public SupportCall (String callId, int numMinutes, String callStatus, boolean callBackCustomer, String callAnsweredBy, int customerSatisfactionRating, String callType, String item, String error, String ticketNo)
	{
		super (callId, numMinutes, callStatus, callBackCustomer, callAnsweredBy, customerSatisfactionRating, callType);
		this.item = item;
		this.error = error;
		this.ticketNo = ticketNo;
	}

	public String getItem ()
	{
		return item;
	}

	public void setItem (String item)
	{
		this.item = item;
	}

	public String getError ()
	{
		return error;
	}

	public void setError (String error)
	{
		this.error = error;
	}

	public String getTicketNo ()
	{
		return ticketNo;
	}

	public void setTicketNo (String ticketNo)
	{
		this.ticketNo = ticketNo;
	}

	@Override
	public String toString()
	{
		return super.toString () +
				"\nItem:\t" + item +
				"\nError:\t" + error +
				"\nTicket Number:\t" + ticketNo;
	}
}
