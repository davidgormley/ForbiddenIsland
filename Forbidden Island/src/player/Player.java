package player;

import java.util.ArrayList;
import cards.*;
import gameboard.*;

/**
 * Class for a Player on the Board in a game of Forbidden Island.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201223
 * @version: 1.0
 */

public class Player {
	
    //===========================================================
    // Variable Setup
    //===========================================================
	private String		role;
	private int[] 		pawnPosition;
	private Inventory 	treasureCards;
	private String 		name;
		
	
	//===========================================================
	// Constructor
	//===========================================================
	/**
	 * Constructor for player object.
	 * @param name The player's name.
	 */
	public Player(String pName) {
		this.name = pName;
		this.treasureCards = new Inventory();
		this.pawnPosition = new int[2];
	}
	
	//===========================================================
	// Methods
	//===========================================================
	/**
	 * Method to view player's inventory.
	 */
	public void viewInventory() {
		if (treasureCards.size() == 0){
			System.out.println("Inventory is empty.");
		}
		else {
			for (int i = 0; i < treasureCards.size(); i++) {
				System.out.println("\n" + String.valueOf(i+1) + ": " + treasureCards.viewCard(i));
			}
		}
	}
	
	/**
	 * Method to give card to this player.
	 * @param c
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
	 */
	public void setPos(int i ,int j) {
		this.pawnPosition[0] = i;
		this.pawnPosition[1] = j;
	}
	
	/**
	 * Set starting position
	 */
	public void setStartingPos() {
		switch(this.role) {
			
		}
	}
	
	public String toString() {
		return "Player Role: "+this.role+", Player Position: "+pawnPosition;
	}
	
	// Return the pawn position on 2D game board
	public int[] getPawnPosition() {
		return this.pawnPosition;
	}
	
	// Part of the actions available for each turn
	public void Move() {
		System.out.println("Moving piece adjacently");
	}
	
	// Part of the actions available for each turn
	public void ShoreUp() {
		System.out.println("Flip a tile from flooded to unflooded");
	}
	
	// Part of the actions available for each turn
	public void GiveTreasureCard() {
		System.out.println("Give treasure card to another player");
	}
	
	// Part of the actions available for each turn
	public void CaptureTreasureCard() {
		System.out.println("Capture treasure card");
	}
	
	public void DrawTreasureCard() {
		System.out.println("Draw treasure cards from the deck.");
	}
	
	public String getRole() {
		return this.role;
	}


}
