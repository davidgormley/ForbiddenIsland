package deck;

import cards.*;

public class DeckDemo {
	public static void main(String[] args) {
		TreasureDeck tdk = TreasureDeck.getInstance();
		TreasureDiscard tdd = TreasureDiscard.getInstance();
		Card tmp;
		
		tdk.shuffleDeck();
		tmp = tdk.deal(true);
		tdd.addCard(tmp);
	}
}
