package game;

import deck.*;
import java.util.ArrayList;

public class SetDecks {
	/**
	 * Class to setup the card decks for new game.
	 * 
	 * @author: Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
	 * @date: 201223
	 * @version: 1.0
	 */

	// ===========================================================
	// Variable Setup
	// ===========================================================
	private FloodDeck 			floodDeck;
	private FloodDiscard 		floodDiscard;
	private TreasureDeck 		treasureDeck;
	private TreasureDiscard 	treasureDiscard;

	// ===========================================================
	// Constructor
	// ===========================================================
	public SetDecks() {
		// instantiate decks
		this.floodDeck = 		FloodDeck.getInstance();
		this.floodDiscard = 	FloodDiscard.getInstance();
		this.treasureDeck = 	TreasureDeck.getInstance();
		this.treasureDiscard = 	TreasureDiscard.getInstance();
		
		// shuffle decks
		floodDeck.shuffleDeck();
		floodDiscard.shuffleDeck();
		treasureDeck.shuffleDeck();
		treasureDiscard.shuffleDeck();
	}

	// ===========================================================
	// Other
	// ===========================================================
	

}
