package via.grill.socketProgramming;

public class Cook implements Runnable {
	//a thread making burgers 
	//also copied from the previous exercise.
	
	private static final long PRODUCTION_TIME = 6000L;


    private int cookNo;
    private Grill grill;


    public Cook( int cookNo, Grill grill )
    {
        this.cookNo = cookNo;
        this.grill = grill;
    }


    @Override
    public void run()
    {
        System.out.println( "Cook #" + cookNo + " is ready" );

        while( true ) {
            grill.startProducing();

            System.out.println( "Cook #" + cookNo + " starts producing a burger" );

            try {
                Thread.sleep( PRODUCTION_TIME );
            } catch( InterruptedException ex ) {
            }

            System.out.println( "Cook #" + cookNo + " has produced a burger and is ready" );

            grill.burgerCompleted();
        }
    }

}
