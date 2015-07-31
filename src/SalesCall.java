/**
 * Created by Joe on 27/07/2015.
 */
public class SalesCall extends Call
{
	private String itemRef;
	private double price;

	public SalesCall (String callId, int numMinutes, String callStatus, boolean callBackCustomer, String callAnsweredBy, int customerSatisfactionRating, String callType, String itemRef, double price)
	{
		super (callId, numMinutes, callStatus, callBackCustomer, callAnsweredBy, customerSatisfactionRating, callType);
		this.itemRef = itemRef;
		this.price = price;
	}

	public String getItemRef ()
	{
		return itemRef;
	}

	public void setItemRef (String itemRef)
	{
		this.itemRef = itemRef;
	}

	public double getPrice ()
	{
		return price;
	}

	public void setPrice (double price)
	{
		this.price = price;
	}

	@Override
	public String toString ()
	{
		return super.toString () + "\nItem Reference Number:\t" + itemRef + "\nCost of item:\t" + price;
	}
}
