package deck;

import cards.Card;

/**
 * Singleton class for the Treasure discard pile.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201223
 * @version: 1.0
 */

public class TreasureDiscard {
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
	 * Method to add card to discard pile.
	 * @param dealWaterRise sets whether a water rise card is a 
	 * valid draw. For use with game setup.
	 */
	public void addCard(Card c) {
		this.treasureDiscard.addCard(c);
	}
}
