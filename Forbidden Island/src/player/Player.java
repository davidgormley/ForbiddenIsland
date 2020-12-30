package player;

import cards.*;
import gameboard.*;

/**
 * Class for a Player on the Board in a game of Forbidden Island.
 * 
 * @author: Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date: 201230
 * @version: 1.0
 */

public class Player {

	// ===========================================================
	// Variable Setup
	// ===========================================================
	private String 		role;
	private int[] 		pawnPosition;
	private Inventory 	treasureCards;
	private String 		name;

	// ===========================================================
	// Constructor
	// ===========================================================
	/**
	 * Constructor for player object.
	 * @param name The player's name.
	 */
	public Player(String pName) {
		this.name = pName;
		this.treasureCards = new Inventory();
		this.pawnPosition = new int[2];
	}

	// ===========================================================
	// Methods
	// ===========================================================
	/**
	 * Method to view player's inventory.
	 */
	public void viewInventory() {
		if (treasureCards.size() == 0) {
			System.out.println("Inventory is empty.");
		} else {
			for (int i = 0; i < treasureCards.size(); i++) {
				System.out.println("\n" + String.valueOf(i + 1) + ": " + treasureCards.viewCard(i));
			}
		}
	}

	/**
	 * Method to give card to this player.
	 * @param c Card object
	 */
	public void giveCard(Card c) {
		this.treasureCards.addCard(c);
	}

	/**
	 * Method to set player's role.
	 * @param role player role as string
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * Method to set player's position.
	 * @param i location i
	 * @param j locaiton j
	 */
	public void setPos(int i, int j) {
		this.pawnPosition[0] = i;
		this.pawnPosition[1] = j;
	}

	/**
	 * Set player starting position
	 */
	public void setStartingPos() {
		int[] pos = new int[2];
		Board board = Board.getInstance();

		switch (this.role) {
			case "Diver":
				pos = board.tileCoords("Iron Gate");
				break;

			case "Engineer":
				pos = board.tileCoords("Bronze Gate");
				break;

			case "Explorer":
				pos = board.tileCoords("Copper Gate");
				break;

			case "Messenger":
				pos = board.tileCoords("Silver Gate");
				break;

			case "Navigator":
				pos = board.tileCoords("Gold Gate");
				break;

			case "Pilot":
				pos = board.tileCoords("Fool's Landing");
				break;
		}

		setPos(pos[0], pos[1]);
	}

	/**
	 * Print the toString for the player
	 * @return String toString of the player details
	 */
	public String toString() {
		return "Player Role: " + this.role + ", Player Position: " + pawnPosition;
	}

	/**
	 * Return the location for the player
	 * @return pawnPosition pawn player position on board
	 */
	public int[] getPawnPosition() {
		return this.pawnPosition;
	}

	/**
	 * Add treasure card for the player
	 */
	public void CaptureTreasureCard(Card card) {
		treasureCards.addCard(card);
	}

	/**
	 * Method to draw the specified treasure card from the deck.
	 * @param cardname Name of desired card
	 * @return Card
	 */
	public Card DrawTreasureCard(String cardname) {
		return treasureCards.popCard(cardname);
	}

	/**
	 * Get the players role.
	 * @return role Get players role
	 */
	public String getRole() {
		return this.role;
	}

	/**
	 * Get the players name.
	 * @return name Get players name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Get the players inventory.
	 * @return treasureCards Get players cards
	 */
	public Inventory getTreasureCards() {
		return this.treasureCards;
	}

	/**
	 * Method to call the hasCard check from Inventory
	 * @param cardname Name of desired card
	 * @return Boolean
	 */
	public boolean hasCard(String cardname) {
		return this.treasureCards.hasCard(cardname);
	}

	/**
	 * Returns how many cards are in player's inventory.
	 * @return Integer.
	 */
	public int inventorySize() {
		return treasureCards.size();
	}

}
