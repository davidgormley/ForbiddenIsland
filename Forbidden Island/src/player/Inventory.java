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
	
	/**
	 * Method to return how many cards are in inventory.
	 * @return Number of cards.
	 */
	public int size() {
		return this.numCards;
	}
	
	/**
	 * Method to view card in inventory.
	 * @param i Index of card in inventory.
	 * @return The name of the card as String.
	 */
	public String viewCard(int i) {
		return this.cards.get(i).cardName();
	}
	
	/**
	 * Method to check whether a player has a given card in their inventory.
	 * @param cardname Name of desired card
	 * @return Boolean stating whether player has the card
	 */
	public boolean hasCard(String cardname) {
		for (Card card : this.cards) {
			if (card.cardName().equals(cardname)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Method to check how many copies of a specified card a 
	 * player may have in their inventory.
	 * @param cardname Name of desired card
	 * @return How many of a given card the player has as Integer.
	 */
	public int cardInstances(String cardname) {
		int count = 0;
		
		for (Card card : this.cards) {
			if (card.cardName().equals(cardname)) {
				count++;
			}
		}
		return count;
	}
}
