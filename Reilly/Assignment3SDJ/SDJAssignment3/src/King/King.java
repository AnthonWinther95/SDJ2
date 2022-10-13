package King;
import java.util.Random;

import Catalog.Catalog;
import ValuableFactory.Valuable;
import rw.Treasureroom;

public class King extends Thread{

	private static final Random random2 = new Random();
	
	@Override
	public void run() {
		Random rand = new Random();
		for(int i=50; i<150; i++) {
			
		//	Treasureroom.acquireWrite();
			
			
		}
		

		public synchronized String getValuables()
		{
			if( Valuable.size() == 0 )
				return null; // no colors available -- return null;
			else {
				return Valuable.remove(0); // remove and return the first color
			}
		}
		
		
		public synchronized void returnValuables( String c )
		{
			valuables.add( c ); // put a color back in the pool
		}
	
		
		//Get and put in an ArrayList
		//look through list and retrieve
		//if takes to much, then put back in the arrayList
		//Sleep method
		//If the kings random number is 100 for example and he gets valuables worth 100, then he will hold a party
		
		//if( Random == Kings valuables)
		//System.out.println("The king has enough valuables to hold the party" + );
		
		//else{ put valuables back and cancel party
		//System.out.println("The party has been cancelled")
		
		//System.out.println (TreasureRoom.get(i).getValuable());
		
		
		Catalog.getInstance().addLog("The King is holding a party").
		
		Treasureroom.releaseWrite();
	}	
}

