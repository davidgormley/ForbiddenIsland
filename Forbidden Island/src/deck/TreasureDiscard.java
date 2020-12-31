package deck;

import cards.Card;

/**
 * Singleton class for the Treasure discard pile.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201230
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
	/**
	 * Create the treasure discard pile
	 */
	private TreasureDiscard() {
		this.treasureDiscard = new Deck<Card>();
	}
	
	//===========================================================
	// Get Instance
	//===========================================================
	/**
	 * Get an instance of the treasure discard object
	 * @return DDeck Treasure Discard object
	 */
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
		this.treasureDiscard.empty();
	}
	
	/**
	 * Method to add card to pile.
	 */
	public void addCard(Card c) {
		this.treasureDiscard.addCard(c);
	}
	
	/**
	 * Pop card from discard pile. Used for flipping the deck.
	 */
	public Card pop() {
		return treasureDiscard.pop();
	}
}
