package via.grill.socketProgramming.Observer;

import java.util.ArrayList;

public abstract class StandarSubject implements Subject{

	//subject implementation part 
	
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	@Override
	public synchronized void attachObserver( Observer observer)
	{
		observers.add( observer );
	}
	
	@Override
    public synchronized void detachObserver( Observer observer)
    {
        observers.remove( observer );
    }


    @Override
    public void notifyObservers()
    {
        for( Observer o: observers )
            o.update();
    }
	
}
