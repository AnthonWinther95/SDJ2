package via.grill.socketProgramming;
 
import static via.grill.socketProgramming.Config.PORT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Random;

import javax.swing.JOptionPane;

import com.google.gson.Gson;


public class Client
{
    private static final int MAX_WAIT = 20000; // 20 seconds
    private static final int MAX_BURGERS = 3;


    public static void main( String[] args )
    {
        new Client().run();
    }


    private String id;
    private String ip;
    private Gson gson = new Gson();
    private static final Random rand = new Random();


    private void run()
    {
        id = JOptionPane.showInputDialog( null, "Client ID" );
        if( id == null || id.length() == 0 )
            return;

        ip = JOptionPane.showInputDialog( null, "IP address" );
        if( ip == null || ip.length() == 0 )
            return;
        
      //asks for a ip adress.

        while( true ) {//sleep sometime randomly,
            try {
                Thread.sleep( rand.nextInt( MAX_WAIT ) );
            } catch( Exception ex ) {
            }

            serverCall( id, 1 + rand.nextInt( MAX_BURGERS ) );
        }
    }


    private void serverCall( String id, int noOfBurgers )
    {
        try {
            System.out.println( "Ordering " + noOfBurgers + " burger(s)");

            Socket socket = new Socket( ip, PORT );

            OutputStreamWriter out = new OutputStreamWriter( socket.getOutputStream() );
            BufferedReader in = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );

            String message = gson.toJson( new Request( id, noOfBurgers ) );
            System.out.println( "SENDING: " + message );

            out.write( message + "\n" ); // write to server
            out.flush();

            message = in.readLine(); // read from server
            System.out.println( "RECEIVED: " + message );

            Response response = gson.fromJson( message, Response.class );

            socket.close();

            if( response.getStatus() )
                System.out.println( "Burger(s) arrived");
            else
                System.out.println( "*** Something went wrong ***" );
        } catch( Exception ex ) {
            ex.printStackTrace();

            System.exit( 1 );
        }
    }
}

	
	
	
	
	

