package SimpleTCP.simpletcp;

import java.net.Socket;

import static TCP.SimpleTCPConfig.PORTNO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import javax.swing.JOptionPane;

public class SimpleTCPClient {
	
	public static void main( String[] args) 
	{
		new SimpleTCPClient().run();
	}
	
	private String ip;
	
	private void run()
	{
		ip = JOptionPane.showInputDialog(null, "IP address");
		
		if( ip == null || ip.length() == 0)
			return;
		//if the ip adress is null or the length of the ip adress is null.
		
		
		
	}

}
