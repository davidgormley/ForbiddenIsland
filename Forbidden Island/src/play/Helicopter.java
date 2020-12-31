package play;

import java.util.Scanner;

import gameboard.Board;
import player.Adventurers;
import java.util.TreeMap;

import cards.TreasureType;

import java.util.ArrayList;

/**
 * This class handles the helicopter action for players.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201230
 * @version: 1.0
 */

public class Helicopter {
	
	//===========================================================
    // Variable Setup
    //===========================================================
	Adventurers 		players = Adventurers.getInstance();
	Board 				board = Board.getInstance();
	Scanner 			in;
	int 				P1 = 0;
	int[] 				destination;
	ArrayList<Integer> 	passengers = new ArrayList<Integer>(); // an array of player numbers
	boolean				Win;
	
	//===========================================================
    // Constructor
    //===========================================================
	/**
	 * Create helicopter object
	 */
	public Helicopter(Scanner in) {
		this.in = in;
	}
	
	//===========================================================
    // Methods
    //===========================================================
	/**
	 * Method to read user input and select which player will perform
	 * the action. As these cards can be played at any time, the 
	 * intention here is that if another player would like to play
	 * the card outside their turn then they can be temporarily
	 * made the active player and control should then be given to that player.
	 */
	private void selectPlayer() {
		System.out.println("\nWhich Player will use Helicopter Lift card?");
		players.printList();
		
		do {
			P1 = in.nextInt();
		} while(P1 < 1 || P1 > players.numPlayers());
	}
	
	/**
	 * Checks whether player has a helicopter lift card.
	 * @return Boolean Check if player has helicopter card
	 */
	private boolean checkCard() {
		if (players.getPlayer(P1).hasCard("Helicopter Lift") == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Method which gets the player's intended destination. A numbered list of
	 * valid choices is presented to the player who should then input an 
	 * integer corresponding to their choice.
	 * @return Coordinates of destination on the board as integer array.
	 */
	private void selectDestination() {
		int choice;
		TreeMap<Integer,String> tileChoices = board.activeTiles();
		
		// present options to player
		System.out.println("Available Destinations:");
		for (int n : tileChoices.keySet()) {
			System.out.println(n + ". " + tileChoices.get(n));
		}
		
		// get player's choice of destination
		System.out.println("Please select a destination [1-" + tileChoices.size() + "]:");
		do {
			choice = in.nextInt();
		}while(choice < 1 || choice > tileChoices.size());
		
		destination = board.tileCoords(tileChoices.get(choice));
	}
	
	/**
	 * This method will query the active player about each adventurer to 
	 * decided who will travel to the destination.
	 * @return An ArrayList containing the player numbers of those chosen.
	 */
	private ArrayList<Integer> choosePassengers() {
		String decision;
		
		System.out.println("Choose which players will move to destination:");
		
		// iterate through players list and ask user for each
		for (int p = 1; p <= players.numPlayers(); p++) {
			System.out.println(players.getPlayer(p).getName() + "? [Y/N]");
			decision = in.next();
			
			if (decision.toUpperCase().equals("Y")) {
				passengers.add(p);
			}
			
		}
		
		return passengers;
	}
	
	/**
	 * Method for checking whether the win conditions have been met when a
	 * helicopter lift card is played.
	 * @return
	 */
	private boolean checkWin() {
		int[] loc = players.getPlayer(P1).getPawnPosition();
		
		// check that is played on Fool's Landing
		if (!loc.equals(board.tileCoords("Fool's Landing")))
			return false;
		
		// check that all players on Fool's Landing
		for (int p = 1; p <= players.numPlayers(); p++) {
			if (!loc.equals(players.getPlayer(p).getPawnPosition()))
				return false;
		}
		
		// check that all treasures have been captured
		if (!players.haveTreasure(TreasureType.CRYSTAL_OF_FIRE))
			return false;
		if (!players.haveTreasure(TreasureType.EARTH_STONE))
			return false;
		if (!players.haveTreasure(TreasureType.OCEAN_CHALICE))
			return false;
		if (!players.haveTreasure(TreasureType.STATUE_OF_WIND))
			return false;
		
		// succcess!
		return true;
	}
	
	/**
	 * Performs checks and player selections, then iterates through the list of
	 * chosen players and sets their position to the new destination.
	 */
	public boolean doHelicopter() {
		selectPlayer();
		
		if(checkCard() == true) {
			// check win condition
			if (checkWin() == true) {
				return true;
			}
			
			selectDestination();
			
			choosePassengers();
			
			passengers.forEach((p) -> players.getPlayer(p).setPos(destination[0],destination[1]));
			
			System.out.println("Adventurers have arrived safely at their destination.");
		}
		
		return false;
	}
}
