package via.radiator;

public class Power3State implements RadiatorState {

	private static final int POWER = 3;
	
	public void turnUp(Radiator radiator)
	{
		
	}
	
	public void turnDown(Radiator radiator)
	{
		radiator.setPowerState(new Power2State());
		System.out.println("Power turned down to state 2");
	}
	
	public int getPower()
	{
		return POWER;
	}
}
