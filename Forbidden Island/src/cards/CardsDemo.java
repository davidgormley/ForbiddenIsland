package cards;
import java.util.*;

public class CardsDemo {

	public static void main(String[] args) {
		Stack<Card> deck = new Stack<Card>();
		
		Card heli = new Card("Helicopter LIft",CardType.HELI);
		Card wr = new Card("Water Rise",CardType.WATER_RISE);
		Card sbag = new Card("Sandbag",CardType.SANDBAG);
		IslandTile FL = new IslandTile("Fool's Landing",CardType.TILE,false);
		
		System.out.println(FL.toString());
		FL.flood();
		System.out.println(FL.toString());
		FL.shoreUp();
		System.out.println(FL.toString());
		System.out.println(FL.isLootable());
		
		deck.push(heli);
		deck.push(wr);
		deck.push(sbag);
		deck.push(FL);
		System.out.println(deck.size());
		deck.pop();
		System.out.println(deck.size());
		Card p = deck.peek();
		System.out.println(p.toString());		// output is reference?
		System.out.println(deck.search(wr));
		FL.flood();
		FL.flood();
		System.out.println(FL.toString());
		FL.flood();
		

	}

}
