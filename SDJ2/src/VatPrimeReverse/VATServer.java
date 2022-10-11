package VatPrimeReverse;

import static VatPrimeReverse.Config.VATPORT;

import java.net.ServerSocket;
import java.net.Socket;


import java.net.InetAddress;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class VATServer {
	
	private static final double VATRATE = 0.25;//setting the VATRATE for 25%. used to output 25% of the input. 
	
	public static void main( String [] args)
	{
		new VATServer().run();
	}
	
	private void run()
	{
		try {
			ServerSocket welcomeSocket = new ServerSocket( VATPORT );
			
			System.out.println( "VAT Server listening on " + InetAddress.getLocalHost().getHostAddress() ); 
			//this comes up in a pop-up vindue to enter the ip-adress that are given by the client or server (can't remember rn)
		
			while( true ) { //so while the the socket accepts, this runs. 
				Socket clientSocket = welcomeSocket.accept();
				
				new Thread( new ServerThread( clientSocket ) ).start();
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

		AbstractRequest request = (AbstractRequest) in.readObject();
		
		if( request instanceof VATRequest ) //if the request if an instance of VATRequest, then do the below. 
			out.writeObject( new VATResponse( VATRATE * ((VATRequest) request).getAmount() ) );
		else
			System.out.println( "Unexpected request" );
			
		clientSocket.close();
	}
	
	
	private class ServerThread
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
