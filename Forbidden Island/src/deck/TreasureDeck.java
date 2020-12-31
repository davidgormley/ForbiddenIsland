package deck;

import cards.*;

/**
 * Singleton class for the Treasure Deck.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201230
 * @version: 1.0
 */

public class TreasureDeck extends Deck<Card> {
	
	//===========================================================
	// Variable Setup
	//===========================================================
	private Deck<Card>				treasureDeck;
	private static TreasureDeck 	TDeck;
	
	//===========================================================
	// Private Constructor
	//===========================================================
	/**
	 * Create treasure deck
	 */
	private TreasureDeck() {
		this.treasureDeck = new Deck<Card>();
	}
	
	//===========================================================
	// Get Instance
	//===========================================================
	/**
	 * Get instance of the treasure deck
	 * @return tDeck Instance of the treasure deck
	 */
	public static TreasureDeck getInstance() {
		if (TDeck == null) {
			TDeck = new TreasureDeck();
			TDeck.refill();
		}
		return TDeck;
	}
	
	//===========================================================
	// Public Methods
	//===========================================================
	/**
	 * Method to deal card from treasure deck
	 * @param dealWaterRise sets whether a water rise card is a 
	 * valid draw. For use with game setup.
	 */
	public Card deal(Boolean dealWaterRise) {
		Card tmp = this.treasureDeck.drawCard();
		// If a water rise is not valid draw, return card to treasure
		// deck and shuffle, then call method recursively until a valid 
		// treasure card is drawn.
		if (tmp.getType() == CardType.WATER_RISE && dealWaterRise == false) {
			this.treasureDeck.addCard(tmp);
			this.treasureDeck.shuffleDeck();
			tmp = deal(false);
		}
		
		return tmp;
	}
	
	/**
	 * Method to refill the treasure deck. To be called when all cards
	 * have been drawn during gameplay.
	 */
	public void refill() {
		// make sure treasure deck is empty first
		if (this.size() == 0) {
			this.treasureDeck.fillTreasureDeck();
			//the above statement is wrong call treasureDeck.refillTreasureDeck();
		}
	}
	
	/**
	 * Print out the contents of the deck. **For testing**
	 */
	public void view() {
		this.treasureDeck.printDeck();
	}
	
	/**
	 * Empty the treasure deck. **For testing**
	 */
	public void empty() {
		this.treasureDeck.empty();
	}
	
	/**
	 * get the size of the Treasure deck
	 * @return int Size of the treasure deck
	 */
	public int size() {
		return this.treasureDeck.deckLength();
	}
	
	/**
	 * Turns over the discard pile to create a new Treasure Deck. Used when
	 * the treasure deck runs out during gameplay.
	 */
	public void flipDiscard() {
		TreasureDiscard discard = TreasureDiscard.getInstance();
		while (discard.deckLength() > 0) {
			this.treasureDeck.addCard(discard.pop());
		}
	}
}
