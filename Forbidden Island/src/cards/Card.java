package cards;

/**
 * Class for a Card on the Board in a game of Forbidden Island.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201223
 * @version: 1.0
 */

public class Card {
	
    //===========================================================
    // Variable Setup
    //===========================================================
	public String 	name;
	public CardType	type;
	
	//===========================================================
	// Constructor
	//===========================================================
	/**
	 * Constructor for Card object.
	 * @param name The name of the card.
	 * @param type The type of card.
	 */
	public Card(String name, CardType type) {
		this.name = name;
		this.type = type;
	}    
	
	// get card name
	public String cardName() {
		return name;
	}
	
	// get card type
	public CardType getType() {
		return type;
	}
	public String toString() {
		return name;
	}
}
