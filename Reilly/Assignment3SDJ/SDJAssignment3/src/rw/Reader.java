/*
 * 04.11.2019 Original version
 */


package rw;


import java.util.Random;


public class Reader
	extends Thread
{
	private static final int MAX_WAIT_TIME = 10000; // 3 seconds
	private static final int MAX_WORK_TIME = 5000; // 2 seconds
	
	
	private static final Random random = new Random();
	
	private int no;
	private RWMonitor monitor;
	private Treasureroom resource;
	
	
	public Reader( int no, RWMonitor monitor, Treasureroom resource )
	{
		this.no = no;
		this.monitor = monitor;
		this.resource = resource;
	}
	
	
	public void run()
	{
		while( true ) {
			try {
				sleep( random.nextInt( MAX_WAIT_TIME ) );
			} catch( InterruptedException ex ) {
			}
			
			System.out.println( "Reader #" + no + " trying to read" );
			
			monitor.acquireRead();
			
			System.out.println( "Reader #" + no + " got read access" );
			
			try {
				sleep( random.nextInt( MAX_WORK_TIME ) );
			} catch( InterruptedException ex ) {
			}
			
			System.out.println( "Reader #" + no + " read " + resource.getValueRead() );
			
			monitor.releaseRead();
		}
	}
}
