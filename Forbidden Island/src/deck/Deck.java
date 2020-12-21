package deck;

import java.util.Stack;

import cards.Card;
import cards.CardType;
import cards.IslandTile;
import java.util.Collections;

public class Deck<T> {
	Stack<T> deck = new Stack<T>();
	
//add a card to the deck
	public void addCard(Card e) {
		this.deck.add((T) e);
	}

	
//draw a card from the deck
	public T drawCard() {

		return deck.pop();
	}

//shuffle the deck 
	public void shuffleDeck() {
		Collections.shuffle(this.deck);
	}
//print the cards in the deck
	public void printDeck() {
		for (int i = 0; deck.size() > i; i++) {
			System.out.println(this.deck.elementAt(i).toString());
		}
	}

//	get the deck length
	public int deckLength() {
		return deck.size();
	}
}
