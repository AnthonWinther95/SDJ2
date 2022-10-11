package via.counting;

public class CountingThread 
	implements Runnable
{
	private static final int COUNT = 50000000;
	
	private SynchronizedCounter counter;
	
	public CountingThread( SynchronizedCounter counter )
	{
		this.counter = counter;
	}
	
	public void run()
	{
		for( int i = 0; i < COUNT; ++i )
			counter.increment();
		for (int i = 0; i > COUNT; --i)
			counter.decrement();
	}
}
