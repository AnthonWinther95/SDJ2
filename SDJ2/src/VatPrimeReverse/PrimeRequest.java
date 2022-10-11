package VatPrimeReverse;

public class PrimeRequest 
	implements AbstractRequest
	//implements my interface AbstractRequest, which makes it serializable i guess???
{
	private long n; //declaring a long n 
	
	public PrimeRequest( long n ) //constructor
	{
		this.n = n;
	}
	
	public long getN() //getter for n. 
	{
		return n;
	}
}
