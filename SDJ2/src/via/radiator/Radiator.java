package via.radiator;

public class Radiator {
	
	
	
	private RadiatorState currentState = new OffState();
	
	
	public void turnUp()
	{
		System.out.println( "Turn up complete" );
		
		currentState.turnUp (this);
	}

	
	public void turnDown()
	{
		System.out.println( "Turning down" );
		
		currentState.turnDown(this);
	}
	
	public void getPower() 
	{
		System.out.println("Current power level is: " + currentState.getPower());
	}
	
	void setPowerState (RadiatorState state)
	{
		currentState = state;
	}
	
}

