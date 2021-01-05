package play;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.System;

import gameboard.Board;
import player.Adventurers;
import cards.*;
import player.*;

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
	Adventurers 		players = Adventurers.getInstance();
	Board 				board = Board.getInstance();
	Scanner 			in;
	
	ArrayList<String> actionCodes = new ArrayList<String>(
			Arrays.asList("M","U","C","I","T","P","G","S","H","E","V","L"));
	
	String 				action;
	String 				end;
	int 				pnum;
	int 				turns;
	Player 				p1;
	boolean				Win;
	
	
	//===========================================================
    // Constructor
    //===========================================================
	public Turn(Scanner in, int playerNumber) {
		this.in = in;
		this.pnum = playerNumber;
		this.turns = 3;
		this.p1 = players.getPlayer(pnum);
		this.Win = doTurn();
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
		System.out.println("Player [I]nfo");
		System.out.println("[T]eam info");
		System.out.println("View [P]layer Locations");
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
	public boolean doTurn() {
		while (turns > 0) {
			System.out.println("\n" + players.getPlayer(pnum).getName() + "'s turn (" 
					+ turns + " remaining).\n");
			
			playerOptions();
			
			selectAction();
			
			switch(action) {
			case "M":
				Move m = new Move(pnum,in);
				turns--;
				break;
				
			case "U":
				shoreUp();
				turns--;
				break;
			
			case "C":
				Capture c = new Capture(pnum,in);
				if(c.isValid() == true) {
					c.doCapture();
					turns--;}
				break;
				
			case "I":
				System.out.println("\n" + p1.getName() + " (" + p1.getRole() + ")"
						+ "\n\nInventory:");
				p1.viewInventory();
				break;
				
			case "T":
				players.capturedTreasures();
				break;
				
			case "P":
				players.playerLocations();
				break;
				
			case "G":
				GiveCard g = new GiveCard(pnum,in);
				if(g.giveCardChecks() == true){
					g.doGiveCard();
					turns--;
				}
				break;
				
			case "S":
				Sandbag s = new Sandbag(in);
				break;
				
			case "H":
				Helicopter h = new Helicopter(in);
				Win = h.doHelicopter();
				
				if(Win == true) {
					return true;}
				break;
				
			case "E":
				turns = 0;
				break;
				
			case "V":
				board.printLegend();
				board.printBoardFull(players);
				break;
				
			case "L":
				System.out.println("\nWARNING: this will end the game.\n Are you sure [Y/N]?");
				end = in.nextLine();
				end = end.toUpperCase();
				
				if (end.equals("Y")) {
					System.exit(0);
				}
				else {
					turns++;
				}
				break;
			}
			
			in.nextLine();			// pause run until player is ready for next turn
		}
		
		return false;
	}
}
