package cards;

import deck.Deck;

import java.awt.List;
import java.util.ArrayList;

public class CardsDemo {

	public static void main(String[] args) {
//		Stack<Card> deck = new Stack<Card>();

		
		IslandTile FL = new IslandTile("Fool's Landing", CardType.TILE, false);
		System.out.println(FL.toString());
		FL.flood();
		System.out.println(FL.toString());
		FL.shoreUp();
		System.out.println(FL.toString());
		System.out.println(FL.isLootable());
		System.out.println("-------------------------------------------------------------------");
		ArrayList<String> tileNames = new ArrayList();

		tileNames = createTileNames();
		
		Deck treasureDeck = new Deck<Card>();
		Deck floodDeck = new Deck<IslandTile>();
		createFloodDeck(tileNames,floodDeck);
		createTreasureDeck(treasureDeck);
		System.out.println("-------------------------------------------------------------------");
		treasureDeck.shuffleDeck();
		treasureDeck.printDeck();
		System.out.println("-------------------------------------------------------------------");
//		deck.pushFloodCard(FL);
		floodDeck.printDeck();
		System.out.println("-------------------------------------------------------------------");

		floodDeck.shuffleDeck();
		floodDeck.printDeck();
		treasureDeck.shuffleDeck();
//		System.out.println(deck.size());
		treasureDeck.drawCard();
//		System.out.println(deck.size());
//		Card p = deck.peek();
//		System.out.println(p.toString()); // output is reference?
//		System.out.println(deck.search(wr));
		FL.flood();
		FL.flood();
		System.out.println(FL.toString());
		FL.flood();

	}
	public static void createTreasureDeck(Deck deck)
	{
		System.out.println("-------------------------------------------------------------------");	
		ArrayList<String> tileNames = new ArrayList();
		tileNames.add("The Earth Stone");
		tileNames.add("The Statue of the Wind");
		tileNames.add("The Crystal of Fire");
		tileNames.add("The Ocean’s Chalice");
		Card tr = new Card(tileNames.get(0),CardType.TREASURE);
		Card tr1 = new Card(tileNames.get(1),CardType.TREASURE);
		Card tr2 = new Card(tileNames.get(2),CardType.TREASURE);
		Card tr3 = new Card(tileNames.get(3),CardType.TREASURE);
		Card heli = new Card("Helicopter LIft", CardType.HELI);
		Card wr = new Card("Water Rise", CardType.WATER_RISE);
		Card sbag = new Card("Sandbag", CardType.SANDBAG);
		for(int i=0;i<5;i++)
		{
			deck.addCard(tr);
			deck.addCard(tr1);
			deck.addCard(tr2);
			deck.addCard(tr3);
			if(i<3)
			{
				deck.addCard(heli);
				deck.addCard(wr);
			}
			if(i<2)
			{
				deck.addCard(sbag);
			}
		}
		deck.printDeck();
		
	
		
		
		
	}
	public static <T> void createFloodDeck(ArrayList<String> tileNames,Deck<T> deck)
	{
		for (int i = 0; tileNames.size() > i; i++) {

			IslandTile FL1 = new IslandTile(tileNames.get(i), CardType.FLOOD, false);
			System.out.print(FL1.toString());
			deck.addCard(FL1);
		}
	}
	public static ArrayList<String> createTileNames()
	{
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
		return tileNames;
	}

}
