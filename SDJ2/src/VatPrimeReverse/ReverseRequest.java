package VatPrimeReverse;

public class ReverseRequest 
	implements AbstractRequest
{
	private String text;
	
	public ReverseRequest( String text )
	{
		this.text = text;
	}
	
	
	public String getText()
	{
		return text;
	}
}
