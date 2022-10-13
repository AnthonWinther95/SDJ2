/*
 * 04.11.2019 Original version
 */


package rw;


import java.util.Random;


public class Writer
	extends Thread
{
	private static final int MAX_WAIT_TIME = 20000;
	private static final int MAX_WORK_TIME = 10000;
	
	
	private static final Random random = new Random();
	
	private int no;
	private RWMonitor monitor;
	private Treasureroom resource;
	
	
	public Writer( int no, RWMonitor monitor, Treasureroom resource )
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
			
			System.out.println( "Writer #" + no + " trying to update" );
			
			monitor.acquireWrite();
			
			System.out.println( "Writer #" + no + " got write access" );
			
			try {
				sleep( random.nextInt( MAX_WORK_TIME ) );
			} catch( InterruptedException ex ) {
			}
			
			resource.updateValue(null);
			
			System.out.println( "Writer #" + no + " updated" );
			
			monitor.releaseWrite();
		}
	}
}
