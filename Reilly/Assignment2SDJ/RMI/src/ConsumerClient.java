import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Random;
import model.mediator.RecipeReader;
import model.mediator.RecipeProvider;
import java.rmi.Remote;

public class ConsumerClient extends Thread {
	
	private static final Random random = new Random();

	private producerClient createBurger;
		
		@Override
		public void run()
		{
			while( true ) {
				try {
					sleep( random.nextInt( 5000 ) );
				} catch( InterruptedException ex ) {
				}
				
				try {
					sleep( random.nextInt( 10000 ) );
				} catch( InterruptedException ex ) {
				}
			}
		}
		
		public static void main( String[] args) throws MalformedURLException, RemoteException, NotBoundException {
			
			HelloService service = (HelloService) Naming.lookup("rmi://localhost:5000/hello");
			System.out.println("---" + service.echo("Hey Server") + " " + service.getClass().getName());
		}
}
