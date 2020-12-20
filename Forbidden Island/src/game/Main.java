// Game objective: Work cooperatively with the other players to keep Forbidden
// Island from sinking in order to buy enough time to capture its four
// treasures. Once you have captured them, you must make it to Fools' Landing
// and escape by helicopter to win



package game;
import player.*;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numberPlayers; // number of players between 2 - 4
		int waterLevel; // water level between 1 - 5
		
		
		
		
		// Testing the Player Class - To be removed
		Player player1 = new Player();
		System.out.println(player1.getRole());
		
		
		
		
		
		
		// Setting up the game
		System.out.println("Setting up the game...\n");

		
		Scanner in = new Scanner(System.in);
		System.out.println("How many players are playing? Enter integer between 2 and 4:");
		numberPlayers = in.nextInt();
	    System.out.println("There are " + numberPlayers + " players playing.\n");
	    
	    // Setting up the forbidden island board and assigning tiles to the board
	    
	    // ForbiddenIslandBoard = setUpBoard();
	    
	    // Setting up the island tiles that will start to sink
	    
	    // Create floodDeck and take top 6 cards, flip the corresponding 6 island tiles to flooded
	    
	    // Randomly assign a role to each player
		System.out.println("Randomly assigning a role to each player.\n");
		
		// Begin handing out 2 treasure cards to each player
		System.out.println("Handing out 2 Treasure Cards to each player.\n");
		
		// Set the water level
		System.out.println("Set the water level between 1 - 5. Enter water level:");
		waterLevel = in.nextInt();
	    System.out.println("The water level is " + waterLevel);
	    
	    
	    // Finish game set
		System.out.println("Finished game set up. Get ready to play.\n");
		
		



	}
	
	
	// Player samplePlayer = new Player("John");

}
