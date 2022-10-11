package via.radiator;

public class OffState implements RadiatorState {
	
	private static final int POWER = 0;
	
	
	public void turnUp ( Radiator radiator )
	{
		radiator.setPowerState( new Power1State());
		System.out.println("Power turned to 1");
	}
	
	public void turnDown ( Radiator radiator )
	{
		System.out.println("Power is turned off");
	}

	@Override
	public int getPower() 
	{
		return POWER;
	}
}
