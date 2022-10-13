package Accountant;
import Catalog.Catalog;
import ValuableFactory.Valuable;
import rw.*;

public class Accountant implements Runnable {

	 public Accountant(String string) {
		// TODO Auto-generated constructor stub
	}

	public void run() {
		 while(true) {
			//TreasureRoom.acquire();
			 Treasureroom.acquireRead();
			 
			 double sum = 0;
			 for(int i = 0; i < Valuable.getValue(); i++)
			     sum += Treasureroom.get(i);
			 return sum;
		 }
	 
	 System.out.println("The total sum of TreasureRoom is " + Thread.currentThread().getName());
	 Catalog.getInstance().addLog("The Accountant calculated the valuables").

	 Treasureroom.releaseRead();
	 }
}