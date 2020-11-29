package deck;

import java.util.Stack;

import cards.Card;
import cards.CardType;
import cards.IslandTile;
import java.util.Collections;

public class Deck {
	Stack<Card> treasureDeck = new Stack<Card>();
	Stack<IslandTile> floodDeck = new Stack<IslandTile>();

	public void pushTreasureCard(Card e) {
		System.out.print(e.toString());
		this.treasureDeck.add(e);
	}

	public void pushFloodCard(IslandTile e) {
		this.floodDeck.add(e);

	}

	public Card popTreasureCard() {
		System.out.println(treasureDeck.firstElement().toString());

		return treasureDeck.pop();
	}

	public IslandTile popFloodCard() {
		System.out.println(floodDeck.firstElement().toString());
		return floodDeck.pop();
	}

	public void shuffleFloodDeck() {
		Collections.shuffle(this.floodDeck);
	}

	public void shuffleTreasureDeck() {
		Collections.shuffle(this.treasureDeck);
	}

	public void printTreasureDeck() {
		for (int i = 0; treasureDeck.size() > i; i++) {
			System.out.println(this.treasureDeck.elementAt(i).toString());
		}
	}

	public void printFloodDeck() {
		for (int i = 0; floodDeck.size() > i; i++) {
			System.out.println(this.floodDeck.elementAt(i).toString());
		}
	}
}
