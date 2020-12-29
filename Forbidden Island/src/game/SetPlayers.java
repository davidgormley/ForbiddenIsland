package game;

import player.*;
import java.util.Stack;
import java.util.Scanner;
import java.util.Map;

/**
 * Class to setup the players for a new game.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201223
 * @version: 1.0
 */

public class SetPlayers {
	//===========================================================
    // Variable Setup
    //===========================================================
	private int 				numberPlayers;
	private Adventurers			players;
	private Stack<String>		roles;
	
	//===========================================================
    // Constructor
    //===========================================================
	public SetPlayers(Scanner in) {
		this.players = Adventurers.getInstance();
		getNumPlayers(in);
		addPlayers(in);
		addRoles();
		assignRoles();
	}
	
	//===========================================================
    // Methods
    //===========================================================
	/**
	 * Set number of players
	 * @param in Scanner for player inputs
	 */
	public void getNumPlayers(Scanner in) {
		// set number of players
		System.out.println("How many players are playing? Enter integer between 2 and 4:");
		while (numberPlayers != 2 && numberPlayers != 3 && numberPlayers != 4) {
			numberPlayers = in.nextInt();
			in.nextLine();
		}
		System.out.println("There are " + numberPlayers + " players playing.\n");
	}
	
	/**
	 * 
	 * @param in Scanner for player inputs
	 * @param playerNum The order number of player being created
	 * @return The player
	 */
	public Player createPlayer(Scanner in, int playerNum) {
		System.out.println("\nEnter name for player " + playerNum + " : ");
		String name = in.nextLine();
		
		Player p = new Player(name);
		
		return p;
	}
	
	/**
	 * Method to add players to game
	 * @param in Scanner for player inputs
	 */
	public void addPlayers(Scanner in) {
		Player nextP;
		for (int p = 1; p <= this.numberPlayers; p++) {
				nextP = createPlayer(in, p);
				this.players.addPlayer(p,nextP);
		}
	}
	
	/**
	 * Method to create list of player roles for later assignment.
	 */
	private void addRoles() {
		this.roles = new Stack<String>();
		roles.push("Diver");
		roles.push("Engineer");
		roles.push("Explorer");
		roles.push("Messenger");
		roles.push("Navigator");
		roles.push("Pilot");
	}
	
	/**
	 * Method to randomly assign roles to players. For each, the 
	 * list of possible roles is shuffled then one role is popped
	 * from the top of the stack and assigned to the player.
	 * Starting positions are then assigned.
	 */
	public void assignRoles() {
		for (int p = 1; p <= numberPlayers; p++) {
			java.util.Collections.shuffle(this.roles);
			this.players.getPlayer(p).setRole(roles.pop());
			players.getPlayer(p).setStartingPos();
		}
	}
}
