package play;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import gameboard.Board;
import player.Adventurers;
import cards.Flooded;
import player.Player;

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
	Scanner in;
	
	ArrayList<String> actionCodes = new ArrayList<String>(
			Arrays.asList("M","U","C","I","G","S","H","E","V","L"));
	
	String action;
	int pnum;
	int turns;
	Player p1;
	
	
	//===========================================================
    // Constructor
    //===========================================================
	public Turn(Scanner in, int playerNumber) {
		this.in = in;
		this.pnum = playerNumber;
		this.turns = 3;
		this.p1 = players.getPlayer(pnum);
		doTurn();
	}
	
	//===========================================================
    // Methods
    //===========================================================
	/**
	 * Print the list of available actions to the player.
	 */
	private void playerOptions() {
		System.out.println("[M]ove");
		System.out.println("Shore [U]p");
		System.out.println("[C]apture Treasure");
		System.out.println("Check [I]nventory");
		System.out.println("[G]ive Card");
		System.out.println("[S]andbag");
		System.out.println("[H]elicopter");
		System.out.println("[E]nd Turn");
		System.out.println("[V]iew Map");
		System.out.println("[L]eave");
	}
	
	/**
	 * Gets choice of turn action from player.
	 */
	private void selectAction() {
		System.out.println("\nWhat would you like to do? ");
		
		do {
			action = in.nextLine();
			action = action.toUpperCase();
		}while(actionCodes.contains(action) == false);
	}
	
	/**
	 * Shores up the players tile.
	 */
	private void shoreUp() {
		int[] loc = p1.getPawnPosition();
		
		if (board.getState(loc[0], loc[1]) == Flooded.DRY) {
			// invalid action, loop again
			turns++;
		}
		else {
			board.shoreUp(loc[0], loc[1]);
			System.out.println(board.getTileName(loc[0], loc[1]) + " is now dry.");
		}
	}
	
	/**
	 * Implements player turn loop.
	 */
	public void doTurn() {
		while (turns > 0) {
			System.out.println("\n" + turns + " turns remaining.");
			
			// decrement turns counter
			turns--;
			
			playerOptions();
			
			selectAction();
			
			switch(action) {
			case "M":
				Move m = new Move(pnum);
				break;
				
			case "U":
				shoreUp();
				break;
			
			case "C":
				Capture c = new Capture();
				break;
				
			case "I":
				p1.viewInventory();
				turns++;
				break;
				
			case "G":
				if (p1.inventorySize() == 0) {
					System.out.println("\nYou have no cards to give.");
					turns++;
				}
				else {
					GiveCard g = new GiveCard();
				}
				break;
				
			case "S":
				Sandbag s = new Sandbag();
				turns++;
				break;
				
			case "H":
				Helicopter h = new Helicopter();
				turns++;
				break;
				
			case "E":
				turns = 0;
				break;
				
			case "V":
				board.printBoard();
				board.printLegend();
				break;
				
			case "L":
				System.out.println("\nWARNING: this will end the game.\n Are you sure [Y/N}?");
				String end;
				
				do {
					end = in.nextLine();
					end = end.toUpperCase();
				}while(end != "Y" || end != "N");
				
				if (end == "Y") {
					System.exit(0);
				}
				else {
					turns++;
				}
				break;
			}
			
			in.nextLine();
		}
	}
}
