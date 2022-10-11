

package via.grill.socketProgramming;

public class Request 
{
	private String id; // ask if these are the "messages"?
	//telling who the user is.
	private int burgersWanted;
	//and how many burgers they want.
	
	public Request( String id, int burgersWanted )
	{
		this.id = id;
		this.burgersWanted = burgersWanted;
	}
	
	public String getId()
	{
		return id;
	}
	
	public int getBurgersWanted()
	{
		return burgersWanted;
	}
	
}
