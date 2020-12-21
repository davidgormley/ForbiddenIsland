// Game objective: Work cooperatively with the other players to keep Forbidden
// Island from sinking in order to buy enough time to capture its four
// treasures. Once you have captured them, you must make it to Fools' Landing
// and escape by helicopter to win



package game;
import player.*;
import java.util.Scanner;
import gameboard.Board;
import deck.*;

public class Main {

	public static void main(String[] args) {
		
		int numberPlayers; // number of players between 2 - 4
		int waterLevel; // water level between 1 - 5
		
		boolean newGame = false;
		
		
		
		// Testing the Player Class - To be removed
		Player player1 = new Player();
		System.out.println(player1.getRole());
		
		
		
		
		
		
		// Setting up the game
		System.out.println("Setting up the game...\n");

		
		Scanner in = new Scanner(System.in);
		
		// Check if user wants to start a new game
		do {
			System.out.println("Would you like to play a New Game? [y/n] ");
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
		
		// Game loop
		while (newGame == true) {
			
			/**
			 * Initial game setup
			 */
			
			// win flag
			boolean win = false;
			
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
			for (int p = 0; p < numberPlayers; p++) {
				// randomly assign a role
				// player[p].assignRole();
				
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
				 
				 // TODO play
			 
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
	
	
	// Player samplePlayer = new Player("John");

		
}
