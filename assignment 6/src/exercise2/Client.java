import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	
	private PrintWriter socketOut;
	private Socket palinSocket;
	private BufferedReader stdIn;
	private BufferedReader socketIn;

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

	public void communicate () {
		String line = "";
		String response = "";
		
		while (!line.equals("QUIT")) {
			System.out.println("Enter DATE/TIME:");
			try {
				line = stdIn.readLine();
				socketOut.println(line);
				response = socketIn.readLine();  //read response form the socket
				System.out.println("The response is: "+ response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //reading the input from the user (i.e. the keyboard);
			
		}
		closeSocket ();
	}
	
	private void closeSocket () {
		
		try {
			stdIn.close();
			socketIn.close();
			socketOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) throws IOException  {
		Client aClient = new Client("localhost", 9010);
		aClient.communicate();
	}
}

