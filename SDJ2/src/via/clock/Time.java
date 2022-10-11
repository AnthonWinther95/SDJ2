package via.clock;

public class Time {

	private int time = 0;
	
	public void display() 
	{
		System.out.println( "The time is now " + time);
	}
	
	public void increment()
	{
		++time;
	}
	
	public void setTime( int time )
	{
		this.time = time;
		display();
	}
}
