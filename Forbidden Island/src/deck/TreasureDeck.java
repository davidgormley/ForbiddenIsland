package deck;

import cards.*;

/**
 * Singleton class for the Treasure Deck.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201223
 * @version: 1.0
 */

public class TreasureDeck {
	//===========================================================
	// Variable Setup
	//===========================================================
	private Deck<Card>				treasureDeck;
	private static TreasureDeck 	TDeck;
	
	//===========================================================
	// Private Constructor
	//===========================================================
	private TreasureDeck() {
		this.treasureDeck = new Deck<Card>();
		this.treasureDeck.fillTreasureDeck();
	}
	
	//===========================================================
	// Get Instance
	//===========================================================
	public static TreasureDeck getInstance() {
		if (TDeck == null) {
			TDeck = new TreasureDeck();
		}
		return TDeck;
	}
	
	//===========================================================
	// Public Methods
	//===========================================================
	/**
	 * Method to deal card from treasure deck
	 * @param dealWaterRise
	 * @return
	 */
	public Card deal(Boolean dealWaterRise) {
		
	}
}
