package VatPrimeReverse;

public class ReverseResponse 
	implements AbstractResponse
{
	private String txet;
	
	
	public ReverseResponse( String txet )
	{
		this.txet = txet;
	}
	
	
	public String getTxet()
	{
		return txet;
	}
}
