package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import chatserver.ChatServer;
import javafx.application.Platform;
import javafx.scene.control.TextArea;

	public abstract class ModelManager implements Model
	{
	
		private ChatServer client;
	
	
	public ModelManager() throws IOException
	{
		client.connect();
	}
	
	
	/*@Override
	public String convert(String source) throws IOException
	{
		String reply = client.convert(source);
		return reply;

	}
	*/
	}

	
