package VatPrimeReverse;

public class VATRequest 
	implements AbstractRequest
{
	private Double amount;
	
	
	public VATRequest( Double amount )
	{
		this.amount = amount;
	}
	
	
	public Double getAmount()
	{
		return amount;
	}
}
