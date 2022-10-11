package via.clock;

public class DisplayTimer 
	implements Runnable 
	{
	private static final int SECONDS_BETWEEN_DISPLAY = 10;
	
	private static final long MILLISECONDS = 1000L;
	
	private Time time;
	
	public DisplayTimer( Time time)
	{
		this.time = time;
	}
	
	public void run()
	{
		while( true ) {
			time.display();
			
			try {
					Thread.sleep(SECONDS_BETWEEN_DISPLAY * MILLISECONDS);
			}	catch( InterruptedException ex) {
			}
		}
	}
	

}
