package play;

import java.util.Scanner;

import gameboard.Board;
import player.Adventurers;
import player.Player;
import cards.TreasureType;
import cards.IslandTile;
import cards.Flooded;

/**
 * This class handles the capture action for players.
 * 
 * @author: Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date: 201230
 * @version: 1.0
 */

public class Capture {
	// Check player is on correct tile
	// (Optional?) Check that the treasure has not already been captured

	// Check which treasure card is required
	// Check that the player has four matching cards

	// Give treasure to player if checks successful

	// ===========================================================
	// Variable Setup
	// ===========================================================
	Adventurers players = Adventurers.getInstance();
	Board board = Board.getInstance();
	Scanner in;
	
	int pnum;
	int[] pos;
	Player player;
	TreasureType treasureType;
	String cardname;
	
	// ===========================================================
	// Constructor
	// ===========================================================
	public Capture(int playerNum, Scanner in) {
		this.pnum = playerNum;
		this.in = in;
		this.player = players.getPlayer(pnum);
		this.pos = player.getPawnPosition();
		this.treasureType = getTileTreasure();
	}
	
	// ===========================================================
	// Other functions
	// ===========================================================
	/**
	 * Checks the state of tile and if Treasure type is valid.
	 * 
	 * Also sets the card name variable if check is successful.
	 * 
	 * @param board Board object
	 * @param player Player object
	 * @param treasureType Treasure type object
	 * @return Boolean Check if tile is valid
	 */
	public boolean isValid() {
		int playerPosition[] = player.getPawnPosition();
		
		IslandTile tile = board.getTileAt(playerPosition[0], playerPosition[1]);

		if (tile.state() == Flooded.SUNK) {
			System.out.println("Can't loot a flooded tile - get to safety!");
			return false;}

		if (!tile.isLootable()) {
			System.out.println("There is no treasure to capture here.");
			return false;}
		
		/*
		if (tile.getTreasureType() != treasureType)
			return false;
		*/

		if (treasureType == TreasureType.EARTH_STONE) {
			if (player.getTreasureCards().cardInstances("The Earth Stone") < 4) {
				System.out.println("Not enough treasure cards. Keep exploring!");
				return false;}
			
			this.cardname = "The Earth Stone";
		}

		if (treasureType == TreasureType.OCEAN_CHALICE) {
			if (player.getTreasureCards().cardInstances("The Ocean's Chalice") < 4){
				System.out.println("Not enough treasure cards. Keep exploring!");
				return false;}
			
			this.cardname = "The Ocean's Chalice";
		}

		if (treasureType == TreasureType.STATUE_OF_WIND) {
			if (player.getTreasureCards().cardInstances("The Statue of the Wind") < 4){
				System.out.println("Not enough treasure cards. Keep exploring!");
				return false;}
			
			this.cardname = "The Statue of the Wind";
		}

		if (treasureType == TreasureType.CRYSTAL_OF_FIRE) {
			if (player.getTreasureCards().cardInstances("The Crystal of Fire") < 4){
				System.out.println("Not enough treasure cards. Keep exploring!");
				return false;}
			
			this.cardname = "The Crystal of Fire";
		}
		
		if (treasureType == TreasureType.NONE) {
			System.out.println("There is no treasure to loot here.");
			return false;}

		return true;
	}
	
	/**
	 * Returns the treasure type of the tile at the given location
	 * @return TreasureType enum
	 */
	private TreasureType getTileTreasure() {
		return board.getTreasureType(pos[0],pos[1]);
	}
	
	/**
	 * This method updates both locations from which a treasure may be captured
	 * once it has been captured from either one.
	 * @param treasureType TreasureType enum
	 */
	private void looted(TreasureType treasureType) {
		int[] loc1;
		int[] loc2;
		
		if (treasureType == TreasureType.EARTH_STONE) {
			loc1 = board.tileCoords("Temple of the Moon");
			loc2 = board.tileCoords("Temple of the Sun");
		}
		
		else if(treasureType == TreasureType.CRYSTAL_OF_FIRE) {
			loc1 = board.tileCoords("Cave of Embers");
			loc2 = board.tileCoords("Cave of Shadows");
		}
		
		else if(treasureType == TreasureType.OCEAN_CHALICE) {
			loc1 = board.tileCoords("Coral Palace");
			loc2 = board.tileCoords("Tidal Palace");
		}
		
		// Statue of the Wind
		else {
			loc1 = board.tileCoords("Withering Garden");
			loc2 = board.tileCoords("Howling Garden");
		}
		
		board.treasureCaptured(loc1[0], loc1[1]);
		board.treasureCaptured(loc2[0], loc2[1]);
		
		
	}
	
	/**
	 * Adds treasure to team's collection, updates tile, nad removes treasure
	 * cars from player's inventory.
	 */
	public void doCapture() {
		players.addTreasure(treasureType);
		looted(treasureType);
		players.getPlayer(pnum).removeTreasureCards(cardname);
	}
}
