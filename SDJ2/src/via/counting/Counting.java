package via.counting;

public class Counting {

	public static void main( String[] args )
	{
		SynchronizedCounter counter = new SynchronizedCounter();
		
		// Creating two Threads, that executes the same code 
		
		Thread c1 = new Thread( new CountingThread( counter) );
		Thread c2 = new Thread( new CountingThread( counter) );
		
		c1.start();
		c2.start();
		
		
		try {
			c1.join(); //waits for the c1 thread to end 
			c2.join();	
		} catch( InterruptedException ex ) {
			ex.printStackTrace();
		}
		
		System.out.println( counter.getCount() );
	}
}
