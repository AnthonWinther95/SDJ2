package via.clock;

public class UpdateTimer
	implements Runnable
{
	private static final int SECONDS_BETWEEN_UPDATE = 1;
	
	private static final long MILLISECONDS = 1000L;
	
	private Time time;
	
	public UpdateTimer( Time time )
	{
		this.time = time;
	}
	
	public void run()
	{
		while( true ) {
			time.increment();
			
			try {
				Thread.sleep(SECONDS_BETWEEN_UPDATE * MILLISECONDS);
			} catch( InterruptedException ex ) {
			}
		}
	}
}
