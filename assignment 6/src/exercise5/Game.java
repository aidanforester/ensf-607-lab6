package exercise5;
import java.io.*;

//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 


/**
 * @author Ahmed Iqbal, Aidan Forester
 * class game sets up the game mechanics for creating the referee and is the class that runs the program
 */
public class Game implements Constants, Runnable{ //had to remove implements constants in order to implement runnable
	/**
	 * creates variables theBoard of type board
	 * creates theRef of type Referee
	 */
	
	private Board theBoard;
	private Referee theRef;
	private Player xPlayer, oPlayer;

	
	/**
	 * creates a new board object in constructor
	 */
	public Game(Player xPlayer, Player oPlayer) {
        theBoard  = new Board();
    
        this.xPlayer = xPlayer;
        this.oPlayer = oPlayer;

	}
	
	/**
	* referee starts the game
	* @param r
	* @throws IOException
	*/
	public void appointReferee(Referee r){
	    theRef = r;
	  	theRef.runTheGame();
    }
	/**
	 * runs the program
	 * takes user input for the players names and where they want to place their marks on the board
	 * @param args
	 */
	
	@Override
	public void run() {
		startGame();
	}
	
	/**
	 * Sets up the actual game - to be called in run()
	 */
	public void startGame() {
		xPlayer.setBoard(theBoard);
		oPlayer.setBoard(theBoard);
			
		theRef = new Referee();
		theRef.setoPlayer(oPlayer);
		theRef.setxPlayer(xPlayer);
	    appointReferee(theRef); 
	}
}	

