package deck;

import cards.Card;

/**
 * Singleton class for the Treasure discard pile.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201223
 * @version: 1.0
 */

public class TreasureDiscard extends Deck<Card>{
	//===========================================================
	// Variable Setup
	//===========================================================
	private Deck<Card>				treasureDiscard;
	private static TreasureDiscard 	DDeck;
	
	//===========================================================
	// Private Constructor
	//===========================================================
	private TreasureDiscard() {
		this.treasureDiscard = new Deck<Card>();
	}
	
	//===========================================================
	// Get Instance
	//===========================================================
	public static TreasureDiscard getInstance() {
		if (DDeck == null) {
			DDeck = new TreasureDiscard();
		}
		return DDeck;
	}
	
	//===========================================================
	// Public Methods
	//===========================================================
	/**
	 * Method to empty the discard pile.
	 */
	public void empty() {
		this.treasureDiscard = null;
	}
}
