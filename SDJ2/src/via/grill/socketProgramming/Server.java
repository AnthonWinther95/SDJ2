package via.grill.socketProgramming;

import static via.grill.socketProgramming.Config.PORT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

public class Server {
	
	private static final int NO_COOKS = 3;
	private static final int MAX_BURGERS_IN_GRILL = 6;
	
	public static void main( String [] args)
	{
		new Server().run();
	}
	
	private Gson gson = new Gson();
	
	private void run()
	{
        try {
            Grill grill = new Grill( MAX_BURGERS_IN_GRILL );

            for( int i = 0; i < NO_COOKS; ++i ) {
                Thread c = new Thread( new Cook( i, grill ) );
                c.start();
            }

            ServerSocket welcomeSocket = new ServerSocket( PORT );
            //define a socket where clients can contact the server. 

            System.out.println( "Server listening on " + InetAddress.getLocalHost().getHostAddress() );

            while( true ) {
                Socket clientSocket = welcomeSocket.accept();

                new Thread( new ServerThread( clientSocket, grill ) ).start();
                //sooner or later will call the doWork?
            }
        } catch( Exception ex ) {
            ex.printStackTrace();
        }
    }
	
	private void doWork( Socket clientSocket, Grill grill )
            throws Exception
    {
        BufferedReader in = new BufferedReader(
                new InputStreamReader( clientSocket.getInputStream() ) );

        OutputStreamWriter out =
                new OutputStreamWriter( clientSocket.getOutputStream() );

        String message = in.readLine();
        System.out.println( "RECEIVED: " + message );

        Request request = (Request) gson.fromJson( message, Request.class );
        Response response;

        grill.buyBurgers( request.getBurgersWanted() );

        response = new Response( request.getId(), true );

        message = gson.toJson( response );
        System.out.println( "SENDING: " + message );
        out.write( message + "\n" );
        out.flush();

        clientSocket.close();
    }
	
	 	private class ServerThread //this makes the system multithreaded.
 		implements Runnable
 		{	
		 private Socket clientSocket;
		 private Grill grill;


		 public ServerThread( Socket clientSocket, Grill grill )
		 {
			 this.clientSocket = clientSocket;
			 this.grill = grill;
 	}


		 public void run()
		 {
			 try {
				 doWork( clientSocket, grill );
     } 	catch( Exception ex ) {
    	 ex.printStackTrace();
     }
 }
}
	
}	













