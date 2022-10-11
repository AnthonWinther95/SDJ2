package via.radiator;

public class Power2State implements RadiatorState {
	
	private static final int POWER = 2;
	
	public void turnUp(Radiator radiator)
	{
		radiator.setPowerState(new Power3State());
		System.out.println("Power is turned up to state 3");
	}
	
	public void turnDown(Radiator radiator)
	{
		radiator.setPowerState(new Power1State());
		System.out.println("Power is turned down to state 1");
	}
	
	public int getPower()
	{
		return POWER;
	}

}
