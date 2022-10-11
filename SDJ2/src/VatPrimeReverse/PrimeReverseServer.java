package VatPrimeReverse;

import static VatPrimeReverse.Config.PRPORT;
//important to add a import for the config class, to get the prime port. 

import java.net.ServerSocket;
import java.net.Socket;


import java.net.InetAddress;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PrimeReverseServer { //server class for prime number check and reversing String. 
	
	public static void main ( String[] args)
	{
		new PrimeReverseServer().run(); //run-method for this server-class.
	}
	
	private void run() //run method. 
	{
		try {
			ServerSocket welcomeSocket = new ServerSocket( PRPORT );
			
			System.out.println( "Prime/Reverse Server listening on " + InetAddress.getLocalHost().getHostAddress() ); 
			//this comes up in a pop-up vindue for at indsætte IP-adresse. 
		
			while( true ) {
				Socket clientSocket = welcomeSocket.accept();
				
				new Thread( new ServerThread( clientSocket ) ).start();
				//creating a new serverthread, to i guess have everything happen at at the same time?????
			}
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}
	
	private void doWork( Socket clientSocket )
		throws Exception
		{
		ObjectInputStream in = new ObjectInputStream( clientSocket.getInputStream() ); 
		ObjectOutputStream out = new ObjectOutputStream( clientSocket.getOutputStream() );
		//statement for declaring/creating?? objectInputStream. This allows you to send objects instead of Strings
		//no type conversion.

		AbstractRequest request = (AbstractRequest) in.readObject(); //calling the AbstractRequest interface
		
		if( request instanceof PrimeRequest )
			out.writeObject( new PrimeResponse( isPrime( ((PrimeRequest) request).getN() ) ) );
		//if its a prime number, then get n.
		else if( request instanceof ReverseRequest )
			out.writeObject( new ReverseResponse( reverse( ((ReverseRequest) request).getText() ) ) );
		//if the request is of the instance ReverseRequest (so reverse a String),
		//then reverse and getText.
		else
			System.out.println( "Unexpected request" );
		//if something else than the two above, then print a line with unexpected request.
			
		clientSocket.close();
		}
	
	private boolean isPrime( long n ) //method given by Jan. He said not to worry about what's in it. It determines if a number is a prime.
	{
		if( n <= 3 )
			return n == 2 || n == 3;
		else if( n % 2 == 0 )
			return false;
		else {
			for( long d = 3; d * d <= n; d += 2 )
				if( n % d == 0 )
					return false;
					
			return true;
		}
	}
	
	private String reverse ( String input )//method for reversing String. 
	{
		String output = "";
		
		while( input.length() > 0 ) {
			output = input.substring( 0, 1 ) + output;
			input = input.substring( 1 );
		}
		
		return output;
	}
	
	private class ServerThread //???????
	implements Runnable
{
	private Socket clientSocket;
	
	
	public ServerThread( Socket clientSocket )
	{
		this.clientSocket = clientSocket;
	}
	
	
	public void run()
	{
		try {
			doWork( clientSocket );
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}
}
}
