package VatPrimeReverse;

import static VatPrimeReverse.Config.VATPORT;
import static VatPrimeReverse.Config.PRPORT;

import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

public class VPRClient {

	public static void main( String[] args )
	{
		new VPRClient().run();
	}
	
	
	private String vatIp;
	private String primeReverseIp;
	//declaring the two private Strings for the vatIp and the primeReverseIp.
	
	
	public void run()
	{
		vatIp = JOptionPane.showInputDialog( null, "VAT IP" );
		if( vatIp == null || vatIp.length() == 0 )
			return;
		//this returns nothing if the value of the ip-adress is a null or if the length is 0 characters. 
		//this is the vat-ip 
			
		primeReverseIp = JOptionPane.showInputDialog( null, "Prime/Reverse IP" );
		if( primeReverseIp == null || primeReverseIp.length() == 0 )
			return;
		//this is the primeReverseIp
		//same as with the vatIp.
			
		System.out.println( "VAT of 100: " + vat( 100 ) );
		System.out.println( "VAT of 250: " + vat( 250 ) );
		System.out.println( "VAT of 350: " + vat( 350 ) );
		System.out.println( "VAT of 450: " + vat( 450 ) );
		System.out.println( "VAT of 505: " + vat( 505 ) );
		//predetermines what the vat is. 
		//what would you have to do to this prorgram to be able to have the user type in a number and then get 25% of that?
	
		for( long n = 40; n < 50; ++n ) //i don't get this statement?
			if( isPrime( n ) )
				System.out.println( "Prime: " + n ); //if the number is a prime, then print n
		System.out.println();
		
		System.out.println( "Reverse Vandal: " + reverse( "Vandal" ) );
		System.out.println( "Reverse Anthon Winther: " + reverse( "Anthon Winther" ) );
		
		//again, what would it take to make this possible for the user to input? 
	}
	
	
	public double vat( double amount )
	{
		try {
			Socket socket = new Socket( vatIp, VATPORT );
			ObjectOutputStream out = new ObjectOutputStream( socket.getOutputStream() );

			out.writeObject( new VATRequest( amount ) );

			ObjectInputStream in = new ObjectInputStream( socket.getInputStream() ) ;
			
			AbstractResponse response = (AbstractResponse) in.readObject();
			socket.close();
			
			if( response instanceof VATResponse )
				return ((VATResponse) response).getVat();
			else {
				System.out.println( "Unexpected response" );
				
				return -1.0;
			}
		} catch( Exception ex ) {
			ex.printStackTrace();
			
			return -1.0;
		}
	} // i don't understand what is going on here.
		
	
	public boolean isPrime( long n )
	{
		try {
			Socket socket = new Socket( primeReverseIp, PRPORT );
			ObjectOutputStream out = new ObjectOutputStream( socket.getOutputStream() );

			out.writeObject( new PrimeRequest( n ) );

			ObjectInputStream in = new ObjectInputStream( socket.getInputStream() ) ;
			
			AbstractResponse response = (AbstractResponse) in.readObject();
			socket.close();
			
			if( response instanceof PrimeResponse )
				return ((PrimeResponse) response).getPrime();
			else {
				System.out.println( "Unexpected response" );
				
				return false;
			}
		} catch( Exception ex ) {
			ex.printStackTrace();
			
			return false;
		}
	}
		
	
	public String reverse( String s )
	{
		try {
			Socket socket = new Socket( primeReverseIp, PRPORT );
			ObjectOutputStream out = new ObjectOutputStream( socket.getOutputStream() );

			out.writeObject( new ReverseRequest( s ) );

			ObjectInputStream in = new ObjectInputStream( socket.getInputStream() ) ;
			
			AbstractResponse response = (AbstractResponse) in.readObject();
			socket.close();
			
			if( response instanceof ReverseResponse )
				return ((ReverseResponse) response).getTxet();
			else {
				System.out.println( "Unexpected response" );
				
				return "";
			}
		} catch( Exception ex ) {
			ex.printStackTrace();
			
			return "";
		}
	}
}
