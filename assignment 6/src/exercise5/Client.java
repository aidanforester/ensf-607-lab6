package exercise5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Ahmed Iqbal, Aidan Forester
 * The client class that communicates with the server via sockets.
 */
public class Client {
	private PrintWriter socketOut;
	private Socket palinSocket;
	private BufferedReader stdIn;
	private BufferedReader socketIn;
	private String line;
	private String response;

	private GUI gui;
	private GUIAction action;
	
	/**
	 * Constructor
	 * @param serverName
	 * @param portNumber
	 */
	public Client(String serverName, int portNumber) {
		try {
			palinSocket = new Socket(serverName, portNumber);
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			socketIn = new BufferedReader(new InputStreamReader(
					palinSocket.getInputStream()));
			socketOut = new PrintWriter((palinSocket.getOutputStream()), true);
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
	}
	
	/**
	 * Reads inputline
	 */
	private void serverReadLine() {
		line = "";
		response = "";
		try {
			response = socketIn.readLine();
			if (response != null) {
			    System.out.println(response);
			    line = stdIn.readLine();
			    socketOut.println(line);
			}    
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Communicates with the server via sockets 
	 */
	public void communicate () {
		
		serverReadLine();
		while (!response.equals("GAME OVER")) {
			try {
				response = socketIn.readLine();  
				if (!response.equals("GAME OVER"))
				    System.out.println(response);
				if (response.contains("Please enter the")) {
					line = stdIn.readLine();
					socketOut.println(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 	
		}
		closeSocket();	
	}
	
	/**
	 * Closes the sockets used in communicate
	 */
	private void closeSocket () { //function for closing the sockets
		try {
			stdIn.close();
			socketIn.close();
			socketOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	

	public static void main(String[] args) throws IOException  {
		Client aClient = new Client("localhost", 8200);
		aClient.communicate();
		aClient.gui = new GUI();
		aClient.action = aClient.gui.getAction();
		
		
		
		
	}
}