package exercise5;
import java.io.*;

/**
 * Methods and variables for the player class
 * 
 * @author Ahmed Iqbal, Aidan Forester
 *
 */

public class Player implements Constants{
    String name;
    char mark;
    Board board;
    Player opponent;
    private PrintWriter socketOut;
    private BufferedReader socketIn;
    
    public PrintWriter getSocketOut() {
		return socketOut;
	}

	public void setSocketOut(PrintWriter socketOut) {
		this.socketOut = socketOut;
	}

	public BufferedReader getSocketIn() {
		return socketIn;
	}

	public void setSocketIn(BufferedReader socketIn) {
		this.socketIn = socketIn;
	}

	public void setSocket(BufferedReader socketIn, PrintWriter socketOut) {
    	this.socketIn = socketIn;
    	this.socketOut = socketOut;
    }
	
	/**
	 * Constructor
	 */
	public Player(String name, char letterX) {
        this.name = name;
        this.mark = letterX;
	}
	
    /** 
     * sets board
     * @param theBoard
     */
    public void setBoard(Board theBoard) {
        this.board = theBoard;
    }
    
    
    /** 
     * plays the game - each player makes a move until the game is over
     * @throws IOException
     */

    public void play() {
    	printBoard();

        while (!wins()){
            this.makeMove();
            printBoard();

            if(!wins())
            	opponent.play();
        }
    }
    
    /**
     * Check to see if anyone has won, or tied
     * @return
     */
    public boolean wins(){
        boolean win = false;
        if (board.isFull() || board.xWins() || board.oWins()){
            win = true;
            if (board.isFull()) {
            	socketOut.println("Tie Game");
            	opponent.socketOut.println("Tie Game");
            }   
            else {
            	socketOut.println(this.name + " Wins");
            	opponent.socketOut.println(this.name + " Wins");
            }
            socketOut.println("Game Over");
            opponent.socketOut.println("Game Over");
        }
        return win;
    }
    
    /** 
     * method for actually making a move 
     */
    public void makeMove() { // asks player to make a move by entering the row and column numbers
        int row;
        int col;
   
		socketOut.print("\nPlease enter the row and column between 0-2");
		
		try {
			String[] input = socketIn.readLine().split(" ");
			row = Integer.parseInt(input[0]);
			col = Integer.parseInt(input[1]);

	        if((board.getMark(row, col) == Constants.SPACE_CHAR)) { //checks if its empty
	            board.addMark(row, col, mark);
	        } else {
	            makeMove();
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
    
    /**
     * Prints the board to both players
     */
    public void printBoard() { //prints the board on player and opponents board
    	board.setSocket(socketOut);
    	board.display();
    	board.setSocket(opponent.getSocketOut());
    	board.display();
    }

    
    /** 
     * sets opponent
     * @param p
     */
    public void setOpponent (Player p){
        this.opponent = p;
    }
}