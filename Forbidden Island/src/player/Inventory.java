package player;

import cards.*;
import java.util.ArrayList;
/**
 * Class to hold player's treasure cards during game.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201223
 * @version: 1.0
 */

public class Inventory {
	//===========================================================
    // Variable Setup
    //===========================================================
	public ArrayList<Card> cards;
	public static int maxCards = 5;
	public int numCards;
	
	
	//===========================================================
    // Constructor
    //===========================================================
	public Inventory() {
		this.cards = new ArrayList<Card>();
		this.numCards = 0;
	}
	
	
	//===========================================================
    // Methods
    //===========================================================
	/**
	 * Method to add card to player's inventory.
	 * @param c Card to add.
	 */
	public void addCard(Card c) {
		if (this.cards.size() >= maxCards) {
			System.out.println("\nInventory full!");
		}
		else {
			this.cards.add(c);
			this.numCards++;
		}
	}
	
	/**
	 * Method to remove card from player's inventory.
	 * @param i Index of card to remove.
	 */
	public void removeCard(int i) {
		this.cards.remove(i);
		this.numCards--;
	}
	
	/**
	 * Method to check whether player's inventory is full.
	 * @return True if full, false otherwise.
	 */
	public boolean isFull() {
		if (this.numCards == maxCards) {
			return true;
		}
		return false;
	}
}
