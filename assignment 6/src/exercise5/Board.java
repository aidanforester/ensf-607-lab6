package exercise5;

import java.io.PrintWriter;

//This class was not changed much other than the socket
/**
 * 
 * @author Ahmed Iqbal, Aidan Forester
 * board class creates the game board that is displayed in the console
 */

public class Board implements Constants {
	/**
	 * creates theBoard variable of type char
	 * creates markCount of type int
	 */
	private char theBoard[][];
	private int markCount;
	private PrintWriter socket; //need this socket variable to communicate 
	
	/**
	 * constructor creates board and fills board with blank spaces
	 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}
	public PrintWriter getSocket() {
		return socket;
	}
	public void setSocket(PrintWriter socket) {
		this.socket = socket;
	}
	/**
	 *  gets the current mark on that position on the board
	 * @param row
	 * @param col
	 * @return
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}
	/**
	 * checks if there is any open spaces to play, max nine
	 * @return
	 */
	public boolean isFull() {
		return markCount == 9;
	}
	/**
	 * checks if player x is the winner
	 * @return
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}
	/**
	 * checks if player o is the winner
	 * 
	 * @return
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}
	/**
	 * displays the board
	 */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			socket.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				socket.print("|  " + getMark(row, col) + "  ");
			socket.println("|");
			addSpaces();
			addHyphens();
		}
	}
	/**
	 * adds a mark based on the which player moves
	 * @param row
	 * @param col
	 * @param mark
	 */
	public void addMark(int row, int col, char mark) {
		
		theBoard[row][col] = mark;
		markCount++;
	}
	/**
	 * clears the board of any marks and replaces the marks with the space char
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}
	/**
	 * checks to see if there are 3 marks of the same kind in a straight lines
	 * @param mark
	 * @return
	 */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}
	/**
	 * shows the column numbers
	 */
	void displayColumnHeaders() {
		socket.print("          ");
		for (int j = 0; j < 3; j++)
			socket.print("|col " + j);
		socket.println();
	}
	/**
	 *  adds the hyphens for the board
	 */
	void addHyphens() {
		socket.print("          ");
		for (int j = 0; j < 3; j++)
			socket.print("+-----");
		socket.println("+");
	}
	/**
	 * properly spaces out the board
	 */
	void addSpaces() {
		socket.print("          ");
		for (int j = 0; j < 3; j++)
			socket.print("|     ");
		socket.println("|");
	}
	public void removeMark(int row, int col) {
		theBoard[row][col] = SPACE_CHAR;
		markCount--;
	}
}
