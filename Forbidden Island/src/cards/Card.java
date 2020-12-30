package cards;

/**
 * Class for a Card on the Board in a game of Forbidden Island.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201230
 * @version: 1.0
 */

public class Card {
	
    //===========================================================
    // Variable Setup
    //===========================================================
	public String 	name; // DG: Should variables be changed to private?
	public CardType	type; // DG: Should variables be changed to private?
	
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
	
	//===========================================================
	// Getters and Setters
	//===========================================================
	/**
	 * Return the name of the Card.
	 * @return String containing Card's name
	 */	
	public String cardName() {
		return name;
	}
	
	/**
	 * Return the type of the Card.
	 * @return CardType containing Card's type
	 */	
	public CardType getType() {
		return type;
	}
	
	
	//===========================================================
	// Other Functions
	//===========================================================
	/**
	 * Return the toString of the Card name.
	 * @return String containing Card's name
	 */	
	public String toString() {
		return name;
	}
}
