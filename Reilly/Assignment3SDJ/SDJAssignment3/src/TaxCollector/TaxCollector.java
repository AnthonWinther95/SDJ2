package TaxCollector;
import java.util.Random;

import Catalog.Catalog;
import rw.Treasureroom;

public class TaxCollector extends Thread implements Runnable {

	private static final int MAX_WAIT_TIME = 20000;
	private static final int MAX_WAIT_TIME2 = 50000;
	private static final Random random1 = new Random();
	
	@Override
	public void run() {
		while(true) {
		Random rand = new Random();
		for(int i=50; i<200; i++) {
			int randomInteger = rand.nextInt();
		}
		System.out.println("Random Integers: " + rand); 
		
		try {
			sleep(random1.nextInt( MAX_WAIT_TIME ) );
		} catch( InterruptedException ex ) {
		}
		
		TreasureRoom.acquireWrite();
		try {
			sleep(random1.nextInt( MAX_WAIT_TIME2 ) );
		} catch( InterruptedException ex ) {
		}
		
		Catalog.getInstance().addLog("The TaxCollector added valuables").

		TreasureRoom.releaseWrite();
	}	
}
}
