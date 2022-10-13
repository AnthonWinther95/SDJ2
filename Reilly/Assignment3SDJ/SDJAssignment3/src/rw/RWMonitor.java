/*
 * 04.11.2019 Original version
 */


package rw;


public interface RWMonitor
{
	public void acquireRead();
	
	public void releaseRead();
	
	public void acquireWrite();
	
	public void releaseWrite();
}
