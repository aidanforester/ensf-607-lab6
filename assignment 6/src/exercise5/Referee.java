package exercise5;
import java.io.IOException;
//No real changes to this class
/**
 * @author Ahemd Iqbal, Aidan Forester
 * class Referee sets the opponents the players and decides whose turn it is
 * 
 */

public class Referee {
	/**
	 * creates xPlayer and oPlayer of type Player
	 * creates board var of type Board
	 */
	private Player xPlayer;
	private Player oPlayer;
	private Board board;
	
	/**
	 * starts the game by setting each player as the opponents for the other and then displays a blank board
	 * @throws IOException
	 */
	public void runTheGame(){
		oPlayer.setOpponent(xPlayer);
		xPlayer.setOpponent(oPlayer);
		
		xPlayer.play();
	}

	/**
	 * sets player x
	 * @param xPlayer
	 */
	public void setxPlayer(Player xPlayer) {
		this.xPlayer = xPlayer;
	}

	/**
	 * sets player o
	 * @param oPlayer
	 */
	public void setoPlayer(Player oPlayer) {
		this.oPlayer = oPlayer;
	}

	/**
	 * sets the board
	 * @param board
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
	
	
	
	
}
