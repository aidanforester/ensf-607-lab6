package exercise2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class DateClient {

	private PrintWriter socketOut;
	private Socket aSocket;
	private BufferedReader stdIn;
	private BufferedReader socketIn;
	
	
	public DateClient(String serverName, int portNumber) {
		try {
			aSocket = new Socket(serverName, portNumber);
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
			socketOut = new PrintWriter (aSocket.getOutputStream(), true);
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	public void communicate() {
		
		String line = "";
		String response = "";
		boolean isRunning = true;
		
		while(isRunning) {
			System.out.println("please choose either DATE or TIME or enter QUIT to exit: ");
			try {
				line = stdIn.readLine();
				if(!line.equals("QUIT")) {
					response = "exiting ....";
					socketOut.println(response);
					isRunning = false;
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		try {
			stdIn.close();
			socketIn.close();
			socketOut.close();
			
		}catch(IOException e) {
			System.out.println("closing error: " + e.getMessage());
		}
		
		
	}
	
	public static void main(String[] args) {
		
		DateClient client = new DateClient("localhost" ,9090);
		client.communicate();
	}

}
