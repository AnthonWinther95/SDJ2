package via.grill;

public class GrillSimulation
{
	private static final int NO_CUSTOMERS = 8;
	private static final int NO_COOKS = 1;
	private static final int MAX_BURGERS_IN_GRILL = 6;
	
	
	public static void main( String[] args )
	{
		Grill grill = new Grill( MAX_BURGERS_IN_GRILL );
		
		for( int i = 0; i < NO_CUSTOMERS; ++i ) {
			Thread c = new Thread( new Customer( i, grill ) );
			c.start();
		}
		
		for( int i = 0; i < NO_COOKS; ++i ) {
			Thread c = new Thread( new Cook( i, grill ) );
			c.start();
		}
	}
}
