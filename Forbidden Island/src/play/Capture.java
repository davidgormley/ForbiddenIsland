package play;

import gameboard.Board;
import player.Player;
import cards.TreasureType;
import cards.IslandTile;
import cards.Flooded;

/**
 * This class handles the capture action for players.
 * 
 * @author: Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date: 201223
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

	// ===========================================================
	// Methods
	// ===========================================================

	public static boolean isValid(Board board, Player player, TreasureType treasureType) {
		int playerPosition[] = player.getPawnPosition();
		IslandTile tile = board.getTileAt(playerPosition[0], playerPosition[1]);

		if (tile.state() == Flooded.SUNK)
			return false;

		if (!tile.isLootable())
			return false;

		if (tile.getTreasureType() != treasureType)
			return false;

		if (player.getTreasureCards().cardInstances("The Earth Stone") != 4)
			return false;

		return true;
	}
}
