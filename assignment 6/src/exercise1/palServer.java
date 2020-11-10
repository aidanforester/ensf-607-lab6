package exercise1;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class palServer {

	
	private Socket aSocket;
	private ServerSocket serverSocket;
	private PrintWriter socketOut;
	private BufferedReader socketIn;
	
	
	public palServer() {
		try {
			serverSocket = new ServerSocket(8099);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void palindrome() {
		String line = null;
		String rev = "";
		while(true) {
			try {
				line = socketIn.readLine();
				if(line == null) {
					line = "please enter another word";
					socketOut.println(line);
					break;
				}
				else if(line.equals("QUIT")) {
					line = "good bye!";
					socketOut.println(line);
				}else {
					int length = line.length();
					for(int i = length -1; i >=0; i--) {
						rev += line.charAt(i);
					}
					if(line.equals(rev))
						socketOut.println( line + " is a palindrome");
					else
						socketOut.println(line + " is not a palindrome");
					
				}
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
				
	}
	
	public static void main(String[] args) {
		
		
		palServer myServer = new palServer();
		try {
			System.out.println("server is running.....");
			myServer.aSocket = myServer.serverSocket.accept();
			System.out.println("connections accepted by the server....");
			myServer.socketIn = new BufferedReader(new InputStreamReader(myServer.aSocket.getInputStream()));
			myServer.socketOut = new PrintWriter (myServer.aSocket.getOutputStream(), true);
			myServer.palindrome();
			
			
			myServer.socketIn.close();
			myServer.socketOut.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
