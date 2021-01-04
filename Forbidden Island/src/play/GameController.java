package play;

import java.util.Scanner;

import cards.*;
import deck.FloodDeck;
import deck.FloodDiscard;
import deck.TreasureDeck;
import deck.TreasureDiscard;
import gameboard.Board;
import player.Adventurers;
import setup.WaterLevel;

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
	WaterLevel meter =				WaterLevel.getInstance();
	Scanner 						in;
	TreasureDeck tDeck =			TreasureDeck.getInstance();
	TreasureDiscard tDiscard =		TreasureDiscard.getInstance();
	FloodDeck fDeck = 				FloodDeck.getInstance();
	FloodDiscard fDiscard =			FloodDiscard.getInstance();
	
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
		this.in = in;
		while (Win == false && Lose == false) {
			for (int p = 1; p <= players.numPlayers(); p++) {
				Turn turn = new Turn(in,p);
				Win = turn.doTurn();
				
				// deal cards and check water meter lose condition
				if (Win == false) {
					Lose = dealTreasureCards(in,p);
					
					// deal cards and check flood lose conditions
					if (Lose == false) {
						Lose = dealFloodCards(p);
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
	private boolean dealTreasureCards(Scanner in, int pnum) {
		Card tmp;
		
		System.out.println("\nDealing treasure cards...\n");
		
		for (int r = 0; r < 2; r++) {
			tmp = tDeck.deal(true);
			
			// check if water rise card
			if (tmp.getType() == CardType.WATER_RISE) {
				System.out.println("Uh-oh, waters are rising!");
				meter.incrementWaterLevel();
				
				// check against lose conditions in case meter has reached 10
				if(checkLose(pnum) == true)
					return true;
			}
			
			// check if player's inventory is full and get them to discard one
			else if (players.getPlayer(pnum).inventorySize() == 5) {
				int choice;
				
				System.out.println("Inventory full. Choose a card to remove [1-6]: ");
				players.getPlayer(pnum).viewInventory();
				System.out.println("6: " + tmp.cardName());
				
				do {
					choice = in.nextInt();
					in.nextLine();
				} while (choice < 1 || choice > 6);
				
				if (choice < 6)
					players.getPlayer(pnum).getTreasureCards().removeCard(choice-1);
				
			}
			
			else {
				players.getPlayer(pnum).giveCard(tmp);
				System.out.println(players.getPlayer(pnum).getName() + " received "
						+ tmp.cardName() + " card.");
			}
			
			// check if all treasure cards have been dealt
			if (tDeck.deckIsEmpty() == true)
				tDeck.flipDiscard();
		}
		return false;
	}
	
	/**
	 * Deal flood cards according to water level.
	 */
	private boolean dealFloodCards(int pnum) {
		int draw = meter.cardsToDraw();
		
		System.out.println("\nDealing flood cards...\n");
		
		IslandTile tmp;
		String state;
		int[] coords;
		for (int r = 0; r < draw; r++) {
			tmp = fDeck.deal();
			coords = board.tileCoords(tmp.cardName());
			
			// redraw if tile is already sunk
			if(board.getTile(coords[0], coords[1]).state() == Flooded.SUNK) {
				fDeck.viewCards();
				//r--;}
			}
			else {
				board.floodTile(tmp.cardName());
				
				// new tile flood state as string
				if (tmp.state() == Flooded.DRY)
					state = "flooded";
				else
					state = "sunk";
				
				System.out.println(tmp.cardName() + " is now " + state + ".");
				
				// check lose condition
				if (checkLose(pnum) == true)
					return true;
			}

			fDiscard.addCard(tmp);
			
			// check if flood deck is empty and refill if necessary
			if (fDeck.deckIsEmpty() == true) {
				fDeck.refill();
				fDiscard.emptyDeck();}
		}
		
		return false;
	}
	
	/**
	 * End game with Win condition.
	 */
	private void doWinGame() {
		System.out.println("You won! Congratulations!");
	}
	
	/**
	 * End game with Lose condition.
	 */
	private void doLoseGame() {
		System.out.println("You lose. Better luck next time.");
	}
	
	/**
	 * Method for testing the losing conditions.
	 * @return
	 */
	private boolean checkLose(int pnum) {
		// Check if Water meter has reached level 5.
		if (meter.getWaterLevel() == 10) {
			return true;
		}
		
		// Check if both related Island Tiles for a given treasure have sunk
		// before the treasure could be captured.
		int[] loc1 = {0,0};
		int[] loc2 = {0,0};
		
		if (!players.haveTreasure(TreasureType.EARTH_STONE)) {
			loc1 = board.tileCoords("Temple of the Moon");
			loc2 = board.tileCoords("Temple of the Sun");
		}
		
		else if (!players.haveTreasure(TreasureType.CRYSTAL_OF_FIRE)) {
			loc1 = board.tileCoords("Cave of Embers");
			loc2 = board.tileCoords("Cave of Shadows");
		}
		
		else if (!players.haveTreasure(TreasureType.OCEAN_CHALICE)) {
			loc1 = board.tileCoords("Coral Palace");
			loc2 = board.tileCoords("Tidal Palace");
		}
		
		else if (!players.haveTreasure(TreasureType.STATUE_OF_WIND)) {
			loc1 = board.tileCoords("Withering Garden");
			loc2 = board.tileCoords("Howling Garden");
		}
		
		if (loc1[0] != 0) {
			if (board.getState(loc1[0],loc1[1]) ==  Flooded.SUNK &&
					board.getState(loc2[0], loc2[1]) == Flooded.SUNK) {
				return true;}
		}
		
		// Check if Fool's Landing has sunk.
		loc1 = board.tileCoords("Fool's Landing");
		if (board.getState(loc1[0], loc1[1]) == Flooded.SUNK) {
			return true;}
		
		
		// Check if a player has drowned.
		int[] ploc = players.getPlayer(pnum).getPawnPosition();
		int numMoves = players.getPlayer(pnum).determineValidMoves(ploc).size();
		
		if (numMoves == 0)
			return true;
		
		return false;
	}
}
