package play;

import java.util.Arrays;
import java.util.Scanner;

import cards.Card;
import cards.CardType;
import gameboard.Board;
import player.*;

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
	Adventurers players = 	Adventurers.getInstance();
	Board board = 			Board.getInstance();
	Scanner 				in;
	
	Inventory 				inv;
	int 					p1;
	int 					p2;
	int 					cardNum;
	
	
	// ===========================================================
	// Constructor
	// ===========================================================
	public GiveCard(int p1, Scanner in) {
		this.in = in;
		this.p1 = p1;
		this.inv = players.getPlayer(p1).getTreasureCards();
		
		selectReceiver();
		
		selectCard();
	}
	
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
	
	/**
	 * Gets choice of receiver from player.
	 */
	private void selectReceiver() {
		// if there are only two players then automatically set the receiver
		// as the other player.
		if (players.numPlayers() == 2) {
			if(p1 == 1) {
				this.p2 = 2;
			}
			else {
				this.p2 = 1;
			}
		}
		
		else {
			// show list of active players
			for (int p = 1; p <= players.numPlayers(); p++) {
				if (p != p1) {
					System.out.println(p + ". " + players.getPlayer(p).getName());
				}
			}
			
			// get user input
			System.out.println("\nWho would you like to give a card to? [1-4]: ");
			do {
				p2 = in.nextInt();
				in.nextLine();				// capture return key
			}while(p2 < 1 || p2 > players.numPlayers() || p2 == p1);
		}
	}
	
	/**
	 * Gets choice of card from player.
	 */
	private void selectCard() {
		// show available treasure cards
		for (int i = 0; i < inv.size(); i++) {
			if (inv.cardType(i) == CardType.TREASURE) {
				System.out.println((i+1) + ". " + inv.viewCard(i));
			}
		}
		
		// get choice from player
		do {
			cardNum = in.nextInt();	
			in.nextLine();				// capture return key
			cardNum--;					// decrement to match inventory indexing
		}while(cardNum < 0 || cardNum > 5 || inv.cardType(cardNum) != CardType.TREASURE);
	}
	
	/**
	 * Perform the necessary checks for giving a treasure card.
	 * @return Boolean
	 */
	public boolean giveCardChecks() {
		// check if a player has any cards
		if (players.getPlayer(p1).inventorySize() == 0) {
			System.out.println("\nYou have no cards to give.");
			return false;}
		
		// check if a player has any treasure cards to give
		boolean hasTreasure = false;
		Inventory p1Cards = players.getPlayer(p1).getTreasureCards();
		for (int i = 0; i < players.getPlayer(p1).inventorySize(); i++) {
			if(p1Cards.cardType(i) == CardType.TREASURE) {
				hasTreasure = true;
			}
		}
		if (hasTreasure == false) {
			System.out.println("\nYou do not have any treasure cards to give.");
			return false;}
		
		// check that receiver has space in their inventory
		if (players.getPlayer(p2).inventorySize() == 5) {
			System.out.println("\n" + players.getPlayer(p2).getName() + " cannot hold any more cards.");
			return false;}
		
		// if player is not a messenger, check that the receiver is on the same tile
		if (players.getPlayer(p1).getRole() != "Messenger") {
			if (!Arrays.equals(players.getPlayer(p1).getPawnPosition(), players.getPlayer(p2).getPawnPosition())) {
				System.out.println("\n" + players.getPlayer(p2).getName() + " needs to be on the same tile.");
				return false;}}
		
		return true;
	}
	
	/**
	 * Takes card from P1 and gives to P2.
	 */
	public void doGiveCard() {
		Card card = players.getPlayer(p1).popFromInventory(cardNum);
		players.getPlayer(p2).giveCard(card);
		System.out.println("Card received!");
	}
}
