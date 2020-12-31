package game;

import gameboard.*;
import player.*;

import java.util.Scanner;
import cards.*;
import deck.*;

/**
 * Class to set up the game for Forbidden Island.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    2012230
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
	private WaterLevel			waterCtrl;
	
	public Scanner 				in;
	
	//===========================================================
    // Constructor
    //===========================================================
	/**
	 * Create the game set up logic and structure.
	 */
	private GameSetup() {
		this.boardCtrl = 	Board.getInstance();
		this.deckCtrl = 	new SetDecks();
		this.waterCtrl = 	WaterLevel.getInstance();
	}
	
	//===========================================================
    // Get Instance
    //===========================================================
	/**
	 * Get instance of GameSetup object
	 * @return fIsland GameSetup object
	 */
	public static GameSetup getInstance() {
		if (fIsland == null) {
			fIsland = new GameSetup();
		}
		return fIsland;
	}
	
	//===========================================================
    // Methods
    //===========================================================	
	/**
	 * This method handles the initial dealing of treasure cards
	 * to players and the drawing of six flood cards.
	 */
	private void dealInitialCards() {
		// deal 2 treasure cards to each player
		Adventurers players = Adventurers.getInstance();
		TreasureDeck tdeck = TreasureDeck.getInstance();
		Card ctmp;
		
		for(int p = 1; p <= players.numPlayers(); p++) {
			for (int i = 0; i< 2; i++) {
				ctmp = tdeck.deal(false);
				players.getPlayer(p).giveCard(ctmp);
			}
		}
		
		// deal 6 flood cards
		IslandTile tmp;
		FloodDeck flood = FloodDeck.getInstance();
		FloodDiscard fdiscard = FloodDiscard.getInstance();
		Board board = Board.getInstance();
		
		for (int i = 0; i < 6; i++) {
			tmp = flood.deal();
			board.floodTile(tmp.getName());
			fdiscard.addCard(tmp);
		}
	}
	
	/**
	 * This method handles setting up a new game.
	 * @param in
	 */
	public void setupNewGame(Scanner in) {
		this.playerCtrl = new SetPlayers(in);
		dealInitialCards();
		this.waterCtrl.setWaterLevel(in);
	}
}