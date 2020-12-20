package deck;

import java.util.Stack;

import cards.Card;
import cards.CardType;
import cards.IslandTile;
import java.util.Collections;

public class Deck<T> {
	Stack<T> deck = new Stack<T>();
	

	public void addCard(Card e) {
		this.deck.add((T) e);
	}

	

	public T drawCard() {

		return deck.pop();
	}


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
