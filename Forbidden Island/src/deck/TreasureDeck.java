package deck;

import cards.*;

/**
 * Singleton class for the Treasure Deck.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201223
 * @version: 1.0
 */

public class TreasureDeck {
	//===========================================================
	// Variable Setup
	//===========================================================
	private Deck<IslandTile>		treasureDeck;
	private static TreasureDeck 	TDeck;
	
	//===========================================================
	// Private Constructor
	//===========================================================
	private TreasureDeck() {
		this.treasureDeck = new Deck<IslandTile>();
		this.treasureDeck.fillWithIslandTiles();
	}
	
	//===========================================================
	// Get Instance
	//===========================================================
	public static TreasureDeck getInstance() {
		if (TDeck == null) {
			TDeck = new TreasureDeck();
		}
		return TDeck;
	}
	
	//===========================================================
	// Public Methods
	//===========================================================
	
}
