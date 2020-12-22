package game;

import player.*;
import java.util.ArrayList;
import java.util.Scanner;
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
	private int numberPlayers;
	private ArrayList<Player> players;
	
	
	//===========================================================
    // Methods
    //===========================================================
	/**
	 * Set number of players
	 * @param in Scanner for player inputs
	 */
	public void getPlayers(Scanner in) {
		// set number of players
		System.out.println("How many players are playing? Enter integer between 2 and 4:");
		while (numberPlayers != 2 && numberPlayers != 3 && numberPlayers != 4) {
			numberPlayers = in.nextInt();
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
		
		
	}
}
