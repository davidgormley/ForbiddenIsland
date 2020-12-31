package play;

import java.util.Scanner;
import gameboard.Board;
import player.Adventurers;

/**
 * This class handles manages to running of the game, including player turns
 * and checking of win/lose conditions.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201230
 * @version: 1.0
 */

public class GameController {
	//===========================================================
    // Variable Setup
    //===========================================================
	private static GameController 	GC;
	
	Adventurers players = 			Adventurers.getInstance();
	Board board = 					Board.getInstance();
	Scanner 						in;
	private boolean 				Win;
	private boolean					Lose;
	
	//===========================================================
    // Constructor
    //===========================================================
	private GameController() {
		this.Win = false;
		this.Lose = false;
	}
	
	//===========================================================
    // Get Instance
    //===========================================================
	public static GameController getInstance() {
		if (GC == null) {
			GC = new GameController();
		}
		return GC;
	}
	
	//===========================================================
    // Methods
    //===========================================================
	/**
	 * Main game loop method.
	 * @param in Scanner
	 */
	public void playGame(Scanner in) {
		while (Win == false && Lose == false) {
			for (int p = 1; p <= players.numPlayers(); p++) {
				Turn turn = new Turn(in,p);
				Win = turn.doTurn();
				
				// deal cards and check water meter lose condition
				if (Win == false) {
					Lose = dealTreasureCards();
					
					// deal cards and check flood lose conditions
					if (Lose == false) {
						Lose = dealFloodCards();
					}
				}
			}
		}
		
		if (Win == true) {
			doWinGame();
		}
		else if(Lose == true) {
			doLoseGame();
		}
	}
	
	/**
	 * Deal two treasure cards to player after turn.
	 */
	private boolean dealTreasureCards() {
		//TODO
	}
	
	/**
	 * Deal flood cards according to water level.
	 */
	private boolean dealFloodCards() {
		//TODO
	}
	
	/**
	 * End game with Win condition.
	 */
	private void doWinGame() {
		//TODO
	}
	
	/**
	 * End game with Lose condition.
	 */
	private void doLoseGame() {
		//TODO
	}
	
	/**
	 * Method for testing the losing conditions.
	 * @return
	 */
	private boolean checkLose() {
		// Check if Water meter has reached level 5.
		
		// Check if both related Island Tiles for a given treasure have sunk
		// before the treasure could be captured.
		
		// Check if Fool's Landing has sunk.
		
		// Check if a player has drowned.
	}
}
