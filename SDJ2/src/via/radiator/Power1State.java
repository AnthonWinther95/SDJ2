package via.radiator;

public class Power1State implements RadiatorState {
	
	private static final int POWER = 1;
	
	public void turnUp(Radiator radiator)
	{
		radiator.setPowerState(new Power2State());
		System.out.println("Power is turned up to state 2");
	}

	public void turnDown(Radiator radiator)
	{
		radiator.setPowerState(new OffState());
		System.out.println("Power is turned off");
	}
	
	public int getPower()
	{
		return POWER;
	}
}
