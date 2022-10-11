package via.grill.socketProgramming;

public class Grill { //this is a monitor 
	//the methods is from via.grill
	
	private int maxBurgers;
	private int burgersInStock = 0;
	private int burgersInProduction = 0;
	
	public Grill ( int maxBurges )
	{
		this.maxBurgers = maxBurgers;
	}
	
	public synchronized void buyBurgers( int noBurgers )
    // Pre: 1 <= noBurgers <= 3
    {
        while( noBurgers > burgersInStock )
            try {
                wait();
            } catch( InterruptedException ex ) {
            }

        burgersInStock -= noBurgers;

        notifyAll();
    }
	
	public synchronized void startProducing()
    {
        while( burgersInStock + burgersInProduction >= maxBurgers )
            try {
                wait();
            } catch( InterruptedException ex ) {
            }

        ++burgersInProduction;
    }


    public synchronized void burgerCompleted()
    {
        ++burgersInStock;
        burgersInProduction--;

        notifyAll();
    }

}