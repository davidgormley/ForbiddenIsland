package deck;

import cards.Card;

/**
 * Singleton class for the Flood deck discard pile.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201230
 * @version: 1.0
 */

public class FloodDiscard extends Deck<Card>{
	
	//===========================================================
	// Variable Setup
	//===========================================================
	private Deck<Card>				floodDiscard;
	private static FloodDiscard 	fDeck;
	
	//===========================================================
	// Private Constructor
	//===========================================================
	/**
	 * Create flood discard object.
	 */
	private FloodDiscard() {
		this.floodDiscard = new Deck<Card>();
	}
	
	//===========================================================
	// Get Instance
	//===========================================================
	/**
	 * Get instance of the flood discard object.
	 * @return fDeck Flood Discard deck object
	 */
	public static FloodDiscard getInstance() {
		if (fDeck == null) {
			fDeck = new FloodDiscard();
		}
		return fDeck;
	}
	
	//===========================================================
	// Public Methods
	//===========================================================
	/**
	 * Method to empty the discard pile.
	 */
	public void emptyDeck() {
		this.floodDiscard.emptyDeck();
	}
	
	/**
	 * Method to add card to pile.
	 */
	public void addCard(Card c) {
		this.floodDiscard.addCard(c);
	}

}