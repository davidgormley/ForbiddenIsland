package play;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.TreeMap;

import gameboard.Board;
import player.Adventurers;

/**
 * This class handles the move action for players.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201230
 * @version: 1.0
 */

public class Move {
	//===========================================================
    // Variable Setup
    //===========================================================
	Adventurers 			players = Adventurers.getInstance();
	Board 					board = Board.getInstance();
	Scanner 				in;
	TreeMap<Integer,String> moves = new TreeMap<Integer,String>();
	int 					playerNum;
	int 					numMoves = 0;
	int[] 					loc;				// player's current location
	int[] 					destination;
	
	//===========================================================
    // Constructor
    //===========================================================
	/**
	 * Create move object
	 * @param pnum player number
	 */
	public Move(int pnum, Scanner in) {
		this.in = in;
		doMove(pnum);
	}
	
	//===========================================================
    // Methods
    //===========================================================
	/**
	 * Determines where the player is on the board.
	 */
	private void getPlayerPos() {
		loc = players.getPlayer(playerNum).getPawnPosition();
	}
	
	/**
	 * This method checks each tile adjacent to the player and, if valid, 
	 * puts the tile name into a numbered TreeMap to later present to player.
	 * The keys correspond to move direction as follows:
	 * 1- North; 2- East; 3- South; 4- West.
	 */
	private TreeMap<Integer,String> determineValidMoves() {
		moves = players.getPlayer(playerNum).determineValidMoves(loc);
		this.numMoves = moves.size();
	
		return moves;
	}
	
	
	/**
	 * Method which gets the player's intended destination. A numbered list of
	 * valid choices is presented to the player who should then input an 
	 * integer corresponding to their choice.
	 * @return Coordinates of destination on the board as integer array.
	 */
	private void selectDestination() {
		int choice;
		
		// present options to player
		System.out.println("\nAvailable Destinations:");
		for (int n : moves.keySet()) {
			System.out.println(n + ". " + moves.get(n));
		}
		
		// get player's choice of destination
		do {
			System.out.println("\nPlease select a destination [1-4]: ");
			try {
				choice = in.nextInt();}
			catch(InputMismatchException e) {
				System.out.println("Invalid input. Please enter an integer.");
				choice = 0;			// default
			}
			in.nextLine(); 			// catch return key
		}while(!moves.containsKey(choice));
		
		destination = board.tileCoords(moves.get(choice));
	}
	
	/**
	 * Performs the move action for the specified player.
	 * @param pnum Player number
	 */
	public void doMove(int pnum) {
		this.playerNum = pnum;
		
		getPlayerPos();
		
		determineValidMoves();
		
		if (numMoves == 0) {
			System.out.println("\nUh-oh. There are no valid moves available. Get to the choppa!");
		}
		else {
			selectDestination();
			
			players.getPlayer(playerNum).setPos(destination[0], destination[1]);
			
			System.out.println(players.getPlayer(playerNum).getName() + " has arrived at "
					+ board.getTileName(destination[0], destination[1]) + ".");
		}
	}
}
