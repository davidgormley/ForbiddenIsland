package deck;

import cards.*;

public class DeckDemo {
	public static void main(String[] args) {
		Deck<Card> cdk = new Deck<Card>();
		TreasureDeck tdk = TreasureDeck.getInstance();
		TreasureDiscard tdd = TreasureDiscard.getInstance();
		Card tmp;
		
		// test treasure card fill and empty methods
		System.out.println("\n===================\nTest\n===================");
		cdk.printDeck();
		cdk.fillTreasureDeck();
		cdk.printDeck();
		cdk.emptyDeck();
		cdk.printDeck();
		
		// test for singleton
		System.out.println("\n===================\nTest\n===================");
		System.out.println(tdk.size());
		tdk.view();
		tdk.emptyDeck();
		System.out.println(tdk.size());
		tdk.view();
		tdk.refill();
		System.out.println(tdk.size());
		tdk.view();
		
		// test shuffle and deal methods
		System.out.println("\n===================\nTest\n===================");
		tdk.shuffleDeck();
		tmp = tdk.deal(true);
		tdd.addCard(tmp);
	}
}
