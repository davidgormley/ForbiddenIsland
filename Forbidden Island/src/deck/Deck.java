package deck;

import cards.Card;
import cards.CardType;
import cards.IslandTile;

import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

/**
 * Class for a Deck on the Board in a game of Forbidden Island.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201223
 * @version: 1.0
 */

public class Deck<T> {
	
	//===========================================================
	// Variable Setup
	//===========================================================
	Stack<T> deck = new Stack<T>();
	
	//===========================================================
	// Getters and Setters
	//===========================================================
	/**
	 * Add a card to the deck
	 * @param e Adding card to the deck
	 */
	public void addCard(Card e) {
		this.deck.add((T) e);
	}

	/**
	 * Take a card from the deck
	 * @return Take a card from the deck
	 */
	public T drawCard() {
		return (T) deck.pop();
	
	}

	//===========================================================
	// Other
	//===========================================================
	/**
	 * Shuffle the deck
	 * 
	 */
	public void shuffleDeck() {
		Collections.shuffle(this.deck);
	}

	public void printDeck() {
		for (int i = 0; deck.size() > i; i++) {
			System.out.println(this.deck.elementAt(i).toString());
		}
	}

	public int deckLength() {
		return deck.size();
	}
	
	/**
	 * fill deck with Island Tiles
	 */
	public void fillWithIslandTiles() {
		this.addCard(new IslandTile("Breakers Bridge", CardType.TILE, false));
		this.addCard(new IslandTile("Bronze Gate", CardType.TILE, false));
		this.addCard(new IslandTile("Cliffs of Abandon", CardType.TILE, false));
		this.addCard(new IslandTile("Cave of Embers", CardType.TILE, true));
		this.addCard(new IslandTile("Crimson Forest", CardType.TILE, false));
		this.addCard(new IslandTile("Copper Gate", CardType.TILE, false));
		this.addCard(new IslandTile("Coral Palace", CardType.TILE, true));
		this.addCard(new IslandTile("Cave of Shadows", CardType.TILE, true));
		this.addCard(new IslandTile("Dunes of Deception", CardType.TILE, false));
		this.addCard(new IslandTile("Fool's Landing", CardType.TILE, false));
		this.addCard(new IslandTile("Gold Gate", CardType.TILE, false));
		this.addCard(new IslandTile("Howling Garden", CardType.TILE, true));
		this.addCard(new IslandTile("Iron Gate", CardType.TILE, false));
		this.addCard(new IslandTile("Lost Lagoon", CardType.TILE, false));
		this.addCard(new IslandTile("Misty Marsh", CardType.TILE, false));
		this.addCard(new IslandTile("Observatory", CardType.TILE, false));
		this.addCard(new IslandTile("Phantom Rock", CardType.TILE, false));
		this.addCard(new IslandTile("Silver Gate", CardType.TILE, false));
		this.addCard(new IslandTile("Temple of the Moon", CardType.TILE, true));
		this.addCard(new IslandTile("Tidal Palace", CardType.TILE, true));
		this.addCard(new IslandTile("Temple of the Sun", CardType.TILE, true));
		this.addCard(new IslandTile("Twilight Hollow", CardType.TILE, false));
		this.addCard(new IslandTile("Whispering Garden", CardType.TILE, true));
		this.addCard(new IslandTile("Watchtower", CardType.TILE, false));
	}
	
	/**
	 * fill treasure deck
	 */
	public void fillTreasureDeck() {
		// create 20 treasure cards
		for (int i = 0; i < 5; i++) {
			this.addCard(new Card("The Earth Stone",CardType.TREASURE));
			this.addCard(new Card("The Ocean's Chalice",CardType.TREASURE));
			this.addCard(new Card("The Statue of the Wind",CardType.TREASURE));
			this.addCard(new Card("The Crystal of Fire",CardType.TREASURE));
		}
		
		// create 3 helicopter lift cards
		for(int i = 0; i < 3; i++) {
			this.addCard(new Card("Helicopter Lift",CardType.HELI));
		}
		
		// create 2 sandbag cards
		for(int i = 0; i < 2; i++) {
			this.addCard(new Card("Sandbag",CardType.SANDBAG));
		}
		
		// create 3 water rise cards
		for(int i = 0; i< 3; i++) {
			this.addCard(new Card("Water Rise",CardType.WATER_RISE));
		}
	}
	public void refillTreasureDeck(Stack<Card> s)
	{
		this.deck.addAll((Collection<? extends T>) s);
		this.shuffleDeck();
	}
}
