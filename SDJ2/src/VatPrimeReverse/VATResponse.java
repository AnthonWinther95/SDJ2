package VatPrimeReverse;

public class VATResponse 
	implements AbstractResponse
{
	private Double vat;
	
	
	public VATResponse( Double vat )
	{
		this.vat = vat;
	}
	
	
	public Double getVat()
	{
		return vat;
	}
}
