package deck;

import cards.*;
import cards.Flooded;
import cards.IslandTile;
import cards.WaterMeter;

/**
 * Singleton class for the Flood deck.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201230
 * @version: 1.0
 */

public class FloodDeck extends Deck {
	
	//===========================================================
	// Variable Setup
	//===========================================================
	private static FloodDeck FDeck;
	private Deck<IslandTile> floodDeck;

	//===========================================================
	// Private Constructor
	//===========================================================
	/**
	 * Private constructor for the flood deck
	 */
	private FloodDeck() {
		this.floodDeck = new Deck<IslandTile>();
		this.floodDeck.fillWithIslandTiles();
	}

	//===========================================================
	// Get Instance
	//===========================================================
	/**
	 * Get an instance of the flood deck
	 * @return FDeck FloodDeck object
	 */
	public static FloodDeck getInstance() {
		if (FDeck == null) {
			FDeck = new FloodDeck();
		}
		return FDeck;
	}

	//===========================================================
	// Public Methods
	//===========================================================
	/**
	 * Method to refill flood deck. To be used when creating new
	 * instance and during gameplay when cards have been dealt.
	 */
	public void refill() {
		this.floodDeck.fillWithIslandTiles();
	}

	/**
	 * Method to deal card from Flood deck.
	 * @return floodDeck drawCard method
	 */
	public IslandTile deal() {
		return this.floodDeck.drawCard();
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
	public Deck<IslandTile> drawCardsFromFloodDeck() {

		

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
