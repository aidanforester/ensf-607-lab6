
package exercise4;
import java.io.*;

/**
 *Methods and variables for the player class
 * 
 * @author Ahmed Iqbal
 * @version 1.0
 * @since October 1, 2020
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
    /*
    public void play(){
    	printBoard();
    	int temp =  board.checkWinner(this.mark);
        boolean check = false;
        if (temp == 1){
	        if (board.xWins()){
	            check = true;
	            socketOut.print("Player X has won!");
	            opponent.socketOut.print("Player X has won!");
	        }
	        if (board.oWins()){
	            check = true;
	            socketOut.print("Player O has won!");
	            opponent.socketOut.print("Player O has won!");
	        }
	        if (board.isFull()){
	            check = true;
	            socketOut.print("Board is full! No winner!");
	            opponent.socketOut.print("Board is full! No winner!");
	        }
        } else {
            this.makeMove();
            printBoard();
            opponent.play();
        }
    }
    */
    
    public void play() {
    	printBoard();

        while (!isWinner()){
            this.makeMove();
            printBoard();

            if(!isWinner())
            	opponent.play();
        }
    }
    
    public boolean isWinner(){
        boolean winner = false;
        boolean tie = board.isFull();
        boolean xWins = board.xWins();
        boolean oWins = board.oWins();
        if (tie || xWins || oWins){
            winner = true;
            if (tie) {
            	socketOut.println("GAME OVER!!! \nA TIE GAME");
            	opponent.socketOut.println("GAME OVER!!! \nA TIE GAME");
            }   
            else {
            	socketOut.println("GAME OVER!!! \n" + this.name + " wins");
            	opponent.socketOut.println("GAME OVER!!! \n" + this.name + " wins");
            }
            //System.out.println("Game between " + this.getName() + " and " + opponent.getName() + " is over! Thread is free");
            socketOut.println("GAME OVER");
            opponent.socketOut.println("GAME OVER");
        }
        return winner;
    }
    
    /** 
     * method for actually making a move 
     * @param (char)stdin.read();if((board.getMark(row
     * @param (board.getMark(row
     * @param LETTER_X))board.addMark(row
     * @param col
     * @param mark
     * @throws IOExceptionBufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));System.out.print("\nPlease enter the row between 0-2: ");int row = Integer.parseInt(stdin.readLine());System.out.print("\nPlease enter the col between 0-2: ");int col = Integer.parseInt(stdin.readLine());System.out.print("\nPlease enter either X or O: ");char mark = (char)stdin.read();if((board.getMark(row
     * @throws col) != LETTER_O) && (board.getMark(row
     * @throws col) != LETTER_X))board.addMark(row
     * @throws col
     * @throws mark);+} else
     */
    public void makeMove() { // asks player to make a move by entering the row and column numbers
        int row;
        int col;
   
		socketOut.print("\nPlease enter the row and column between 0-2");
		
		try {
			String[] rowCol = socketIn.readLine().split(" ");
			row = Integer.parseInt(rowCol[0]);
			col = Integer.parseInt(rowCol[1]);

	        if((board.getMark(row, col) == SPACE_CHAR)) { //checks if its empty
	            board.addMark(row, col, mark);
	        } else {
	           //ocketOut.println("This spot has been taken");
	            makeMove();
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
    
    public void printBoard() {
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