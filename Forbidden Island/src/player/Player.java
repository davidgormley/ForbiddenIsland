// There are 4 pawns, each of them assigned to a player. Should they be added in here?
// Engineer will be placed on Bronze Gate, the Explorer will be placed on Copper Gate,
// the Diver will be placed on Iron Gate, the Pilot will be placed on Fools’ Landing,
// the Messenger will be placed on Silver Gate, and the Navigator will be placed on Gold Gate


//Assign a role to each player: Randomly assign to each player one of the following roles: 
//Explorer, Diver, Pilot, Engineer, Messenger and Navigator.

package player;

import java.util.Random;

public class Player {
	
	int role; // 1-Engineer, 2-Explorer, 3-Diver, 4-Pilot, 5-Messenger, 6-Navigator
	int pawnPosition [][]; //single value to show position on the board for player
	int treasureCards []; // max number of 5 treasure cards per player, anything over and a card must go into Treasure discard pile
		
	
	// constructor
	public Player() {
		//super
		Random r = new Random();
		int low = 1;
		int high = 7; // excluding 7
		int result = r.nextInt(high-low) + low;
		this.role = result;

	}
	
	public String toString() {
		return "Player Role: "+this.role+", Player Cards: "+treasureCards+", Player Position: "+pawnPosition;
	}
	
	// Part of the actions available for each turn
	public void Move() {
		System.out.println("Moving piece adjacently");
	}
	
	// Part of the actions available for each turn
	public void ShoreUp() {
		System.out.println("Flip a tile from flooded to unflooded");
	}
	
	// Part of the actions available for each turn
	public void GiveTreasureCard() {
		System.out.println("Give treasure card to another player");
	}
	
	// Part of the actions available for each turn
	public void CaptureTreasureCard() {
		System.out.println("Capture treasure card");
	}
	
	public void DrawTreasureCard() {
		System.out.println("Draw treasure cards from the deck.");
	}
	
	public int getRole() {
		return this.role;
	}


}
