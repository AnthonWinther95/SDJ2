package via.grill.socketProgramming;

public class Response {
	
	private String id; //changed - to confirm the right burgers go to the right customer (id)
	private boolean status; //to get the status of the kitchen i assume.
	
	public Response( String id, boolean status )
	{
		this.id = id;
		this.status = status;
	}
	
	public boolean getStatus()
	{
		return status;
	}

}
