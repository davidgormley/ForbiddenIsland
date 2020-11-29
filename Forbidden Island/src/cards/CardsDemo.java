package cards;

import deck.Deck;

import java.awt.List;
import java.util.ArrayList;

public class CardsDemo {

	public static void main(String[] args) {
//		Stack<Card> deck = new Stack<Card>();

		Card heli = new Card("Helicopter LIft", CardType.HELI);
		Card wr = new Card("Water Rise", CardType.WATER_RISE);
		Card sbag = new Card("Sandbag", CardType.SANDBAG);
		IslandTile FL = new IslandTile("Fool's Landing", CardType.TILE, false);
		ArrayList<String> tileNames = new ArrayList();

		tileNames.add("Temple of the Sun");
		tileNames.add("Temple of the Moon");
		tileNames.add("Iron Gate");
		tileNames.add("Lost Lagoon");
		tileNames.add("Misty March");
		tileNames.add("Observatory");
		tileNames.add("Silver Gate");
		tileNames.add("Howling Garden");
		tileNames.add("Gold Gate");
		tileNames.add("Fool's Landing");
		tileNames.add("Dunes of Deception");
		tileNames.add("Watchtower");
		tileNames.add("Phantom Rock");
		tileNames.add("Crimson Forest");
		tileNames.add("Coral Palace");
		tileNames.add("Copper Gate");
		tileNames.add("Cliffs of Abandon");
		tileNames.add("Whispering Garden");
		tileNames.add("Cave of Shadows");
		tileNames.add("Cave of Embers");
		tileNames.add("Bronze Gate");
		tileNames.add("Breakers Bridge");
		tileNames.add("Tidal Palace");
		tileNames.add("Twilight Hollow");
		Deck deck = new Deck();
		try {
			for (int i = 0; tileNames.size() > i; i++) {

				IslandTile FL1 = new IslandTile(tileNames.get(i), CardType.FLOOD, false);
				System.out.print(FL1.toString());
				deck.pushFloodCard(FL1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(FL.toString());
		FL.flood();
		System.out.println(FL.toString());
		FL.shoreUp();
		System.out.println(FL.toString());
		System.out.println(FL.isLootable());

		deck.pushTreasureCard(heli);
		deck.pushTreasureCard(wr);
		deck.pushTreasureCard(sbag);
//		deck.pushFloodCard(FL);
		deck.printFloodDeck();
		System.out.println("-------------------------------------------------------------------");

		deck.shuffleFloodDeck();
		deck.printFloodDeck();
		deck.shuffleTreasureDeck();
//		System.out.println(deck.size());
		deck.popTreasureCard();
//		System.out.println(deck.size());
//		Card p = deck.peek();
//		System.out.println(p.toString()); // output is reference?
//		System.out.println(deck.search(wr));
		FL.flood();
		FL.flood();
		System.out.println(FL.toString());
		FL.flood();

	}

}
