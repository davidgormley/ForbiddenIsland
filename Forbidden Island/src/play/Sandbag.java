package play;

import java.util.Scanner;

import gameboard.Board;
import player.Adventurers;
import cards.Flooded;

/**
 * This class handles the sandbag action for players.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201230
 * @version: 1.0
 */

public class Sandbag {
	//===========================================================
    // Variable Setup
    //===========================================================
	Adventurers 	players = Adventurers.getInstance(); 
	Board 			board = Board.getInstance();
	Scanner 		in;
	int 			P1 = 0;
	
	//===========================================================
    // Constructor
    //===========================================================
	/**
	 * Create Sandbag object
	 */
	public Sandbag(Scanner in) {
		this.in = in;
		doSandbag();
	}
	
	//===========================================================
    // Methods
    //===========================================================
	/**
	 * Method to read user input and select which player will perform
	 * the action. As these cards can be played at any time, the 
	 * intention here is that if another player would like to play
	 * the card outside their turn then they can be temporarily
	 * made the active player and control should then be given to that player.
	 */
	private void selectPlayer() {
		System.out.println("\nWhich Player will use a Sandbag card?");
		players.printList();
		
		do {
			P1 = in.nextInt();
		} while(P1 < 1 || P1 > players.numPlayers());
	}
	
	/**
	 * Checks whether player has a sandbag card.
	 * @return Boolean Checks if the card is Sandbag
	 */
	private boolean checkCard() {
		if (players.getPlayer(P1).hasCard("Sandbag") == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Checks whether tile can be shored up
	 * @return Boolean True if Tile is flooded
	 */
	private boolean checkTile() {
		int[] loc = players.getPlayer(P1).getPawnPosition();
		
		if (board.getState(loc[0],loc[1]) == Flooded.FLOODED) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Performs player selection, checks and sandbag action.
	 */
	public void doSandbag() {
		selectPlayer();

		int[] loc = players.getPlayer(P1).getPawnPosition();
		
		if (checkCard() == true) {
			if (checkTile() == true) {
				board.shoreUp(loc[0],loc[1]);
				System.out.println(board.getTileName(loc[0],loc[1]) + " is now dry.");
			}else {
				System.out.println("Tile isn't flooded.");}
		}else {
			System.out.println(players.getPlayer(P1).getName() + " doesn't have a sandbag card");}
		
	}
}
