package deck;

import cards.Card;
import cards.Flooded;
import cards.IslandTile;
import cards.WaterMeter;

public class FloodDeck extends Deck {
	private static FloodDeck FDeck;
	private Deck<IslandTile> floodDeck;

	private FloodDeck() {
		this.floodDeck = new Deck<IslandTile>();
		this.floodDeck.fillWithIslandTiles();
	}

	public static FloodDeck getInstance() {
		if (FDeck == null) {
			FDeck = new FloodDeck();
		}
		return FDeck;
	}

	public void refill() {
		floodDeck.fillWithIslandTiles();

	}

	Deck<IslandTile> drawSixCardsFloodDeck() {
		Deck<IslandTile> cardsDrawn = new Deck<IslandTile>();
		for (int i = 0; i < 6; i++) {
			IslandTile cardNew = (IslandTile) floodDeck.drawCard();
			cardsDrawn.addCard(cardNew);

		}
		return cardsDrawn;
//		for (int i = 0; i < 6; i++) {
//			IslandTile cardNew = (IslandTile) floodDeck.drawCard();
//			
//			// flood the tile in the board
//
//		}
	}

//	draw cards from flood deck based on water rise card level
	Deck<IslandTile> drawCardsFromFloodDeck(WaterMeter wm) {

		int n = wm.getLevel();

		Deck<IslandTile> cardsDrawn = new Deck<IslandTile>();
		for (int i = 0; i < n; i++) {
			IslandTile cardNew = (IslandTile) floodDeck.drawCard();
			cardsDrawn.addCard(cardNew);

		}
		return cardsDrawn;

//		for (int i = 0; i < n; i++) {
//			IslandTile cardNew = (IslandTile) deck.drawCard();
//			if (cardNew.state() == Flooded.FLOODED) {
//				// remove the tile from the game
//
//			} else {
//				// flood the tile in the board
//
//			}
//		}
	}
}
