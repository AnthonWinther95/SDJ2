/*
 * 04.11.2019 Original version
 */


package rwreadersfirst;


import rw.RWMonitor;


public class RWMonitorReadersFirst
	implements RWMonitor
{
	private int noReaders = 0;
	private int noWriters = 0;
	private int noReadersWaiting = 0;
	

	@Override
	public synchronized void acquireRead()
	{
		++noReadersWaiting;
		
		while( noWriters > 0 )
			try {
				wait();
			} catch( InterruptedException ex ) {
			}
		
		noReadersWaiting--;
		++noReaders;
	}
	
	
	@Override
	public synchronized void releaseRead()
	{
		noReaders--;
		notifyAll();
	}
	
	
	@Override
	public synchronized void acquireWrite()
	{
		while( noWriters > 0 || noReaders > 0 || noReadersWaiting > 0 )
			try {
				wait();
			} catch( InterruptedException ex ) {
			}
		
		++noWriters;
	}
	
	
	@Override
	public synchronized void releaseWrite()
	{
		noWriters--;
		notifyAll();
	}
}
