package deck;

import cards.Card;
import cards.CardType;
import cards.IslandTile;
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
		return deck.pop();
	}

	//===========================================================
	// Other
	//===========================================================
	/**
	 * Shuffule the deck
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
}
