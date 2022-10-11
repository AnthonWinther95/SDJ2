package via.counting;

// small utility class for used for counting.

public class SynchronizedCounter 
{
	private long value = 0L;
	
	public synchronized void increment()
	{
		++value;
	}
	
	public synchronized void decrement ()
	{
		--value;
	}
	
	public synchronized long getCount()
	{
		return value;
	}
}
