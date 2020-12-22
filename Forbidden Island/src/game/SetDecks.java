package game;

import deck.*;
import cards.*;
import java.util.ArrayList;

public class SetDecks {
	/**
	 * Class to setup the card decks for new game.
	 * 
	 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
	 * @date:    201223
	 * @version: 1.0
	 */
	
	//===========================================================
    // Variable Setup
    //===========================================================
	private Deck<IslandTile> 	floodDeck;
	private Deck<IslandTile> 	floodDiscard;
	private Deck<Card> 			treasureDeck;
	private Deck<Card> 			treasureDiscard;
	private ArrayList<Deck>		gameDecks;
	
	//===========================================================
    // 
    //===========================================================
	public static SetDecks getInstance() {
		if S
	}
	
	
	//===========================================================
    // Other
    //===========================================================
	/**
	 * Populate tile and flood decks
	 */
	public void prefillDecks() {
		floodDeck.fillWithIslandTiles();
		treasureDeck.fillTreasureDeck();
	}
	
	
}
