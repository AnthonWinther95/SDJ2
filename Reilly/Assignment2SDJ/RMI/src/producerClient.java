import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import model.mediator.RecipeReader;
import model.domain.Burger;
import model.domain.Recipe;
import model.mediator.RecipeProvider;
import java.util.List;
import java.util.Random;

import collection.ArrayList;

import java.rmi.Remote;

public class producerClient extends Thread {
	
	List<Recipe> recipe = (List<Recipe>) new ArrayList<Recipe>();

	public static void main( String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		HelloService service = (HelloService) Naming.lookup("rmi://localhost:5000/hello");
		System.out.println("---" + service.echo("Hey Server") + " " + service.getClass().getName());
		
	}
	
	private static final Random random = new Random();

	private Recipe recipes;
	private String name;
	private String[] ingredients;

public producerClient( Recipe recipes, String name, String[] ingredients)
{
	this.recipes = recipes;
	this.name = name;
	this.ingredients = ingredients;
}

	
	@Override
	public void run()
	{
		while( true ) {
			try {
				sleep( random.nextInt( 5000 ) );
			} catch( InterruptedException ex ) {
			}
			
			System.out.println( "Thread #" + name + " wants a burger");
			
			Burger Burger = Recipe.createBurger();
			
			System.out.println( "Thread #" + name + " got a burger " + Burger );
			
			try {
				sleep( random.nextInt( 10000 ) );
			} catch( InterruptedException ex ) {
			}
			
			System.out.println( "Thread #" + name + " returns the burger " + Burger );
			
		}
}
}
