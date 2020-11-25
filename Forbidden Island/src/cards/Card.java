// The treasure deck contains 28 cards - 20 Treasure cards (5 for each treasure),
// 3 Helicopter Lift cards, 2 Sandbag cards, 3 water rise cards

// Flood deck contains 24 cards each of them corresponding to an Island Tile


package cards;

public class Card {
	public String name;
	public CardType type;
	
	// Constructor
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
}
