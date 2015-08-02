/**
 * Created by Joe on 27/07/2015.
 */
public class CallCenter
{
	private Call [] calls;
	private int total;

	public CallCenter ()
	{
		calls = new Call[5];
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
