package deck;

import java.util.Stack;

import cards.Card;
import cards.CardType;
import cards.IslandTile;
import java.util.Collections;

public class Deck {
	Stack<Card> treasureDeck = new Stack<Card>();
	Stack<IslandTile> floodDeck = new Stack<IslandTile>();

	public void addTreasureCard(Card e) {
		this.treasureDeck.add(e);
	}

	public void addFloodCard(IslandTile e) {
		this.floodDeck.add(e);

	}

	public Card drawTreasureCard() {

		return treasureDeck.pop();
	}

	public IslandTile drawFloodCard() {
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
			System.out.println(this.treasureDeck.elementAt(i).cardName());
		}
	}

	public void printFloodDeck() {
		for (int i = 0; floodDeck.size() > i; i++) {
			System.out.println(this.floodDeck.elementAt(i).toString());
		}
	}
	public int floodDeckLength() {
		return floodDeck.size();
	}
	public int treasureDeckLength() {
		return treasureDeck.size();
	}
}
