package VatPrimeReverse;

public class PrimeResponse 
	implements AbstractResponse 	//implements my interface AbstractRequest, which makes it serializable i guess???

{

	private boolean prime; //declaring boolean for checking if the a given number is a prime number. 
	
	public PrimeResponse (boolean prime) //constructor
	{
		this.prime = prime;
	}
	
	public boolean getPrime() //getter.
	{
		return prime;
	}
}
