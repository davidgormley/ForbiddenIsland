package play;

import java.util.Scanner;

import gameboard.Board;
import player.Adventurers;

/**
 * This class handles player turns.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201223
 * @version: 1.0
 */

public class Turn {
	//===========================================================
    // Variable Setup
    //===========================================================
	Adventurers players = Adventurers.getInstance();
	Board board = Board.getInstance();
	Scanner in = new Scanner(System.in);
	
	int turns = 3;
	
	
	//===========================================================
    // Constructor
    //===========================================================
	
	
	
	//===========================================================
    // Methods
    //===========================================================
	/**
	 * Print the list of available actions to the player.
	 */
	private void playerOptions() {
		System.out.println("[M]ove");
		System.out.println("Shore [U]p");
		System.out.println("[G]ive Card");
		System.out.println("[S]andbag");
		System.out.println("[H]elicopter");
		System.out.println("[E]nd Turn");
		System.out.println("[V]iew Map");
		System.out.println("[L]eave");
	}
}
