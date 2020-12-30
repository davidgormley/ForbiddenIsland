package game;

import player.*;
import java.util.*; 
import java.util.Scanner;
import gameboard.Board;
import deck.*;

/**
 * Main class to play the game Forbidden Island.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201230
 * @version: 1.0
 */

public class Main {

	public static void main(String[] args) {
		
		int numberPlayers; // number of players between 2 - 4
		int waterLevel; // water level between 1 - 5
		boolean newGame = false;		
		
		Scanner in = new Scanner(System.in);
	    String decision;
	    while(!newGame){

	        System.out.println("Would you like to play a New Game? [y/n]");
	        decision = in.nextLine();

	        switch(decision){
	        case "y":
	        	newGame = true;
	            break;
	        case "n": 
	        	System.out.println("Ending the game...");
	        	System.exit(0);
	        default : 
	            System.out.println("Incorrect input. Would you like to play a New Game? [y/n]");
	            //return default;
	        }
	    }
		
		/**
		Scanner in = new Scanner(System.in);
		// Check if user wants to start a new game
		do {
			System.out.println("Would you like to play a New Game? [y/n] ");
			if (in.next().toUpperCase() == "Y") {
				System.out.println("You selected to play the game.");
				newGame = true;		// Game on
			}
			else if (in.next().toUpperCase() == "N") {
				
				// close scanner
				in.close();
				
				// Exit app
				System.exit(0);
			}
			
			
		} while(newGame != true);
		**/
		// Setting up the game
		System.out.println("Setting up the game...\n");
		
		// Game loop
		while (newGame == true) {
			
			/**
			 * Initial game setup
			 */
			
			// win flag
			boolean win = false;
			
			// counter for player per-round actions
			int actionsTaken;
			
			// set number of players
			System.out.println("How many players are playing? Enter integer between 2 and 4:");
			numberPlayers = in.nextInt();
			// TODO verify input
		    System.out.println("There are " + numberPlayers + " players playing.\n");
		    
		    // set flood level
			System.out.println("Set flood level? Enter integer between 1 and 5:");
			numberPlayers = in.nextInt();
			// TODO verify input
		    
		    // Setting up the forbidden island board and assigning tiles to the board
		    Board gameboard = Board.getInstance();
		    
		    /**
		   	 * Setting up the island tiles that will start to sink
		     */
		    
		    // Create treasure deck and discard, then shuffle
		    // Deck treasureDeck = new Deck();
		    // Deck treasureDiscard = new Deck();
		    // treasureDeck.shuffle();
		    
		    // Create floodDeck and take top 6 cards, flip the corresponding 6 island tiles to flooded
		    // Deck floodDeck = new Deck();
		    // Deck floodDiscard = new Deck();
		    // floodDeck.fillWithTiles();
		    // floodDeck.shuffle();
		    
		    for (int d = 0; d < 6; d ++) {
		    	// draw from flood deck
		    	// IslandTile tmp = floodDeck.drawCard();
		    	
		    	// get position of that card on the board
		    	// int[2] tmpPos = gameboard.tileCoords(tmp.getName());
		    	
		    	// flood it
		    	// gameboard[tmpPos[0]][tmpPos[1]].flood();
		    	
		    	// add flood card to discard pile
		    	// floodDiscard.addCard(tmp);
		    }
		    
		    // Randomly assign a role to each player
			System.out.println("Randomly assigning a role to each player.\n");
			
			/**
				assign roles and starting positions
			**/
			
            List<String> roleList = Arrays.asList("Engineer", "Explorer", "Diver", "Pilot", "Messenger", "Navigator");
			// System.out.println("List before Shuffle : "+roleList);  
            Collections.shuffle(roleList);  
            // System.out.println("List after shuffle : "+roleList); 
            Player[] playerList = new Player[numberPlayers];
			for (int p = 0; p < numberPlayers; p++) {
				// randomly assign a role
				// player[p].assignRole();
				playerList[p] = new Player(roleList.get(p));
				playerList[p].toString();
				
				// set starting position on board based on role
				// player[p].setStartPos(role);
				
				// tell the player which role they were assigned
				// player[p].printRole();
			}
			
			// Begin handing out 2 treasure cards to each player
			System.out.println("Handing out 2 Treasure Cards to each player.\n");
			
			for (int p = 0; p < numberPlayers; p++) {
				// draw treasure cards
				// Card tmp1 = treasureDeck.drawCard();
				/**
				// check if water rise card is drawn and repeat draw as necessary
				while (tmp1.getType() == CardType.Water_Rise){
					treasureDeck.addCard(tmp1);
					treasureDeck.shuffle();
					tmp1 = treasureDeck.drawCard();
				}
				**/
				
				// Card tmp2 = treasureDeck.drawCard();
				/**
				// check if water rise card is drawn and repeat draw as necessary
				while (tmp2.getType() == CardType.Water_Rise){
					treasureDeck.addCard(tmp2);
					treasureDeck.shuffle();
					tmp2 = treasureDeck.drawCard();
				}
				**/
				
				// give to player
				// player[p].giveCard(tmp1);
				// player[p].giveCard(tmp2);
				
				// 2-card draw (w/o water rise checks) will be repeated during each player turn
				// -> bundle into method!
			}
			
			// Set the water level
			System.out.println("Set the water level between 1 - 5. Enter water level:");
			waterLevel = in.nextInt();
		    System.out.println("The water level is " + waterLevel);
		    
		    
		    // Finish game set
			System.out.println("Finished game set up. Get ready to play.\n");
			
			
			/**
			 * Main round-by-round loop
			 */
			int round = 0;
			 while (win != true) {
		
				 /**
				  * PLayer actions
				  */
				 actionsTaken = 1;
				 
				 while (actionsTaken < 3) {
					 // present player actions
					 // playerActions();
					 
					 // read in command
					 // String action = in.next();
					 
					 // do what the meatbag... err, 'boss' says
					 
					 /**
					 
					 switch (action.toLowerCase()){
					 	
					 	// many of these require fleshed out submenu options
					 	case "move":
					 		movePlayer();
					 		break;
					 	
					 	case "shore up":
					 		shoreUp();
					 		break;
					 	
					 	case "give card":
					 		giveCard();
					 		break;
					 		
					 	case "capture":
					 		capture();
					 		break;
					 		
					 	case "use sandbag":
					 		sandbag();
							break;
						
						case "helicopter":
							heli();
							break;
							
						case "view inventory":
							inventory();
							break;
						
						case "view map":
							viewMap();
							break;
							
						case "end turn":
							endTurn();
							break;
						
						case "leave":
							leaveGame();
							break;
					}
					 
					 **/
				 }
				 
				 // draw treasure cards
				 //roundTreasureDraw();
				 
				 // draw flood cards
				 // roundFloodDraw();
			 
			 }
	
			
			// Check if user wants to start another game
			newGame = false;			// reset flag
			do {
				System.out.println("Would you like to play another game? [y/n] ");
				if (in.next().toUpperCase() == "Y") {
					newGame = true;		// Game on
				}
				else if (in.next().toUpperCase() == "N") {
					// close scanner 
					in.close();
					
					// Exit app
					System.exit(0);
				}
				
			} while(newGame != true);
		}
	}
	
	// method for drawing two treasure cards after player actions
	public void roundTreasureDraw() {
		// TODO
	}

	/**
	// method for end-of-round flooding
	public void roundFloodDraw(Deck floodDeck, int waterLevel) {
		for (int w = 0; w < waterLevel; w++) {
			// draw from flood deck
	    	// IslandTile tmp = floodDeck.drawCard();
	    	
	    	// get position of that card on the board
	    	// int[2] tmpPos = gameboard.tileCoords(tmp.getName());
	    	
	    	// flood it
	    	// gameboard[tmpPos[0]][tmpPos[1]].flood();
	    	
	    	// add flood card to discard pile
	    	// floodDiscard.addCard(tmp);
		}
	}**/

}