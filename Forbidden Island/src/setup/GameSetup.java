package setup;

import gameboard.*;
import player.*;
import java.util.concurrent.TimeUnit;
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
		
		System.out.println("\nDealing treasure cards...\n");
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
		
		System.out.println("\nDealing Flood cards...\n");
		for (int i = 0; i < 6; i++) {
			tmp = flood.deal();
			board.floodTile(tmp.getName());
			System.out.println(tmp.getName() + " is flooded.");
			fdiscard.addCard(tmp);
		}
	}
	
	/**
	 * Prints the game title.
	 */
	private void printTitle() {
		String[] message = {"______ _________________ _________________ _____ _   _ ",
				"|  ___|  _  | ___ \\ ___ \\_   _|  _  \\  _  \\  ___| \\ | |",
				"| |_  | | | | |_/ / |_/ / | | | | | | | | | |__ |  \\| |",
				"|  _| | | | |    /| ___ \\ | | | | | | | | |  __|| . ` |",
				"| |   \\ \\_/ / |\\ \\| |_/ /_| |_| |/ /| |/ /| |___| |\\  |",
				"\\_|    \\___/\\_| \\_\\____/ \\___/|___/ |___/ \\____/\\_| \\_/",
				" _____ _____ _       ___   _   _______ ",
				"|_   _/  ___| |     / _ \\ | \\ | |  _  \\",
				"  | | \\ `--.| |    / /_\\ \\|  \\| | | | |",
				"  | |  `--. \\ |    |  _  || . ` | | | |",
				" _| |_/\\__/ / |____| | | || |\\  | |/ / ",
				" \\___/\\____/\\_____/\\_| |_/\\_| \\_/___/  "};
	
		
		System.out.print("\nWelcome Adventurers");
		// delay printing
		try {
			TimeUnit.MILLISECONDS.sleep(1200);}
		catch (Exception e) {
			e.printStackTrace();}
		System.out.print(", to the ...\n");
		// delay printing
		try {
			TimeUnit.MILLISECONDS.sleep(1200);}
		catch (Exception e) {
			e.printStackTrace();}
		
		for (String line : message) {
			System.out.println(line);
			// delay printing
			try {
				TimeUnit.MILLISECONDS.sleep(500);}
			catch (Exception e) {
				e.printStackTrace();}
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
		printTitle();
	}
}