package via.grill;

import java.util.Random;


public class Customer
	implements Runnable
{
	private static final int MAX_TIME_BEFORE_ARRIVAL = 120000; // Two minutes
	private static final int MAX_PURCHASE = 3; // Max number of burgers a customers is allowed to buy
	
	
	private static final Random random = new Random();
	
	
	private int custNo;
	private Grill grill;
	
	
	public Customer( int custNo, Grill grill )
	{
		this.custNo = custNo;
		this.grill = grill;
	}
	
	
	@Override
	public void run()
	{
		// Customers arrive randomly distributed
		
		try {
			Thread.sleep( random.nextInt( MAX_TIME_BEFORE_ARRIVAL ) );
		} catch( InterruptedException ex ) {
		}
		
		int noOfBurgers = 1 + random.nextInt( MAX_PURCHASE );
		
		System.out.println( "Customer #" + custNo + " wants to buy " + noOfBurgers + " burger(s)" );
		
		grill.buyBurgers( noOfBurgers );
		
		System.out.println( "Customer #" + custNo + " got the burger(s)" );
	}
}
