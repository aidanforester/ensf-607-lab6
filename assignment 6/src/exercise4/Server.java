package exercise4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Constants{
	private Socket aSocket;
	private ServerSocket serverSocket;
	private PrintWriter socketOut;
	private BufferedReader socketIn;
	int count=0;
	private Player xPlayer, oPlayer;
	private String xName, oName;
	
	private ExecutorService pool;

	public Server() {
		try {
			serverSocket = new ServerSocket(8200);
			pool = Executors.newFixedThreadPool(2);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void runServer() {
		try {
			while (true) {
				aSocket = serverSocket.accept();
				System.out.println("Console at Server side says: Connection accepted by the server!");
				socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
				socketOut = new PrintWriter(aSocket.getOutputStream(), true);
				
				count++; //increases when a new client is added
				
				if (count % 2 == 1) {
					socketOut.println("What is the name for X player?");
					xName = socketIn.readLine();
					xPlayer = new Player(xName, LETTER_X);
				    xPlayer.setSocket(socketIn, socketOut);
				}
				else if(count % 2 == 0) {
					socketOut.println("What is the name for O player?");
					oName = socketIn.readLine();
				    oPlayer = new Player(oName, LETTER_O);
				    xPlayer.getSocketOut().println("connected opponent " + oName);
				    oPlayer.setSocket(socketIn, socketOut);
				    Game theGame = new Game(xPlayer, oPlayer);
				    
					pool.execute(theGame);
					System.out.println("New game instance started in one thread");
				}
			
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		pool.shutdown();
		
		try {
			socketIn.close();
			socketOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
	
	public static void main(String[] args) throws IOException {

		Server myServer = new Server();
		myServer.runServer();
		System.out.println("Server is running.");
	}


}
