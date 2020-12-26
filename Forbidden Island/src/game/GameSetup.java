package game;

import gameboard.Board;
import java.util.Scanner;

/**
 * Class to set up the game for Forbidden Island.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201223
 * @version: 1.0
 */


public class GameSetup {
	// ===========================================================
	// Variable Setup
	// ===========================================================
	private static GameSetup	fIsland;
	
	private SetPlayers 			playerCtrl;
	private SetDecks			deckCtrl;
	private Board				boardCtrl;
	
	public Scanner 				in;
	
	//===========================================================
    // Constructor
    //===========================================================
	private GameSetup() {
		this.in = 			new Scanner(System.in);
		this.boardCtrl = 	Board.getInstance();
		this.playerCtrl = 	new SetPlayers(in);
		this.deckCtrl = 	new SetDecks();
	}
	
	//===========================================================
    // Get Instance
    //===========================================================
	public static GameSetup getInstance() {
		if (fIsland == null) {
			fIsland = new GameSetup();
		}
		return fIsland;
	}
	
	
	// Deal treasure cards to players
	
	// Deal flood cards
	
	// Assign player roles
	
	// Set water level
	
}
