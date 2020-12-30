package play;

import cards.Card;
import cards.CardType;
import player.Player;

/**
 * This class handles the give card action for players.
 * 
 * @author: Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date: 201230
 * @version: 1.0
 */

public class GiveCard {
	// Select card to give

	// Select receiving player
	// - show available players
	// - check that receiver has space in inventory

	// Remove from P1's inventory and add to P2's

	// ===========================================================
	// Variable Setup
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	/**
	 * Method to check whether the GiveCard action is valid.
	 * @param sender   The sender player object
	 * @param receiver The receiver player object
	 * @param card     The card which is to be given
	 * @return Boolean stating whether action is valid or not.
	 */
	private static boolean isValid(Player sender, Player receiver, Card card) {
		if (card.type != CardType.TREASURE)
			return false;

		if (!sender.hasCard(card.cardName()))
			return false;

		if (receiver.inventorySize() >= 5)
			return false;

		return true;
	}

	/**
	 * Method to give a selected card from one player to another.
	 * @param sender   The sender player object
	 * @param receiver The receiver player object
	 * @param card     The card which is to be given
	 */
	public static void give(Player sender, Player receiver, Card card) {
		if (!isValid(sender, receiver, card))
			return;

		receiver.CaptureTreasureCard(sender.DrawTreasureCard(card.cardName()));
	}
}
