import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CallCenter
{
	private Call [] calls;
	private int total;

	public CallCenter ()
	{
		calls = new Call[30];
		total = 0;
	}

	public int getTotal()
	{
		return total;
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
	public boolean removeCall(String idIn)
	{
		int index = search(idIn);
		if(index == -999){
			return false;
		} else{
			for(int i = index; i <= total -2; i++){
				calls[i] = calls[i+ 1];
			}
			total --;
			return true;
		}
	}
	public boolean isFull()
	{
		if(total == calls.length) {
			return true;
		}
		return false;
	}
	public boolean isEmpty()
	{
		if(total == 0){
			return true;
		}
		return false;
	}
	public String listAll()
	{
		String list = "";
		if(!(isEmpty())){
			for(int i = 0; i < total; i++){
				list += calls[i].toString();
			}
		} else {
			list = "Call list empty";
		}
		return list;
	}

	public  Call getItem(String idIn){
		int index = search(idIn);
		if(index == -999){
			return null;
		}
		return calls[index];
	}
	public boolean updateStatus(String idIn, String statusIn)
	{
		Call callToBeUpdated = getItem(idIn);
		if(callToBeUpdated != null){
			callToBeUpdated.setCallStatus(statusIn);
			return true;
		}
		return false;
	}
	public Call longestCall()
	{
		int tempLongest = 0;
		Call tempCall = null;
		for(int i = 0; i < total; i++) {
			if(calls[i].getNumMinutes() >= tempLongest){
				tempLongest = calls[i].getNumMinutes();
				tempCall = calls[i];
			}
		}
		return tempCall;
	}
	public Call shortestCall()
	{
		int tempShortest = 1000;
		Call tempCall = null;
		for(int i = 0; i < total; i++) {
			if(calls[i].getNumMinutes() <= tempShortest){
				tempShortest = calls[i].getNumMinutes();
				tempCall = calls[i];
			}
		}
		return tempCall;
	}
	public String listCallsAboveSuggestedLength()
	{
		String tempList  = "";
		for(int i = 0; i < total; i++) {
			if(calls[i].getNumMinutes() > Call.getSuggestedLengthofCall()){
				tempList += calls[i].toString();
			}
		}
		return tempList;
	}
	public ObservableList<Call> getCalls()
	{
		ObservableList<Call> callList = FXCollections.observableArrayList();
		for(int i = 0; i < total; i++) {
			callList.add(calls[i]);
		}
		return callList;
	}
	public  ObservableList<Call> getCalls(String idIn)
	{
		ObservableList<Call> callList = FXCollections.observableArrayList();
		if(idIn.equalsIgnoreCase("sales") || idIn.equalsIgnoreCase("support")){
			System.out.println(idIn);
			for(int i = 0; i < total; i++) {
				String tempType = calls[i].getCallType();
				if(tempType.equals(idIn)){
					System.out.println(calls[i].toString());
					callList.add(calls[i]);
				}
			}
		} else {
			for(int i = 0; i < total; i++) {
				if(calls[i].getCallId().equals(idIn)){
					callList.add(calls[i]);
				}
			}
		}
		return callList;
	}
	private int search(String idIn)
	{
		for(int i = 0; i < total; i++) {
			Call tempCall = calls[i];
			String tempId = tempCall.getCallId();
			if(tempId.equals(idIn)){
				return i;
			}
		}
		return -999;
	}
}
