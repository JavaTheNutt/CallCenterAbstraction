public abstract class Call
{
    protected String callId;
    protected int numMinutes;
    protected String callStatus;
    protected boolean callBackCustomer;
    protected String callAnsweredBy;
    protected int customerSatisfactionRating;
    protected static int suggestedLengthofCall = 2;
    protected String callType;

    public Call(String callId, int numMinutes, String callStatus, boolean callBackCustomer, String callAnsweredBy, int customerSatisfactionRating, String callType) {
        this.callId = callId;
        this.numMinutes = numMinutes;
        this.callStatus = callStatus;
        this.callBackCustomer = callBackCustomer;
        this.callAnsweredBy = callAnsweredBy;
        this.customerSatisfactionRating = customerSatisfactionRating;
        this.callType = callType;
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public int getNumMinutes() {
        return numMinutes;
    }

    public void setNumMinutes(int numMinutes) {
        this.numMinutes = numMinutes;
    }

    public String getCallStatus() {
        return callStatus;
    }

    public void setCallStatus(String callStatus) {
        this.callStatus = callStatus;
    }

    public boolean isCallBackCustomer() {
        return callBackCustomer;
    }

    public void setCallBackCustomer(boolean callBackCustomer) {
        this.callBackCustomer = callBackCustomer;
    }

    public String getCallAnsweredBy() {
        return callAnsweredBy;
    }

    public void setCallAnsweredBy(String callAnsweredBy) {
        this.callAnsweredBy = callAnsweredBy;
    }

    public int getCustomerSatisfactionRating() {
        return customerSatisfactionRating;
    }

    public void setCustomerSatisfactionRating(int customerSatisfactionRating) {
        this.customerSatisfactionRating = customerSatisfactionRating;
    }

    public static int getSuggestedLengthofCall() {
        return suggestedLengthofCall;
    }

    public static void setSuggestedLengthofCall(int suggestedLengthofCall) {
        Call.suggestedLengthofCall = suggestedLengthofCall;
    }
    public  String getCallType(){
        return callType;
    }
    public void setCallType(String callType){
        this.callType = callType;
    }


    @Override
    public String toString ()
    {
	    String callbackCustomerStatus;
	    if(callBackCustomer)
	    {
		    callbackCustomerStatus = "Yes";
	    } else {
		    callbackCustomerStatus = "No";
	    }
        return "\n\nCall Id:\t" + callId +
		        "\nLength of Call:\t" + numMinutes +
		        "\nCall Status:\t" + callStatus +
		        "\nDoes the customer require a callback:\t" + callbackCustomerStatus+
		        "\nAgent Name:\t" + callAnsweredBy +
		        "\tCustomer Satisfaction Rating:\t" + customerSatisfactionRating +
		        "\nCall Type:\t" + callType;
    }
}
