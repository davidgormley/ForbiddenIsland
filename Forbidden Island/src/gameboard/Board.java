// Water Meter measures the level of the water in the island, which can range from 1 to 5
// should water meter logic be added in here?

// The number of players should range from 2 to 4. Each Player can have a role: Engineer,
// Explorer, Diver, Pilot, Messenger, Navigator. Depending on his/her role, a player’s pawn
// will be placed initially on a specific Island tile. The Engineer will be placed on Bronze Gate,
// the Explorer will be placed on Copper Gate, the Diver will be placed on Iron Gate, the Pilot 
// will be placed on Fools’ Landing, the Messenger will be placed on Silver Gate, and the Navigator 
// will be placed on Gold Gate.  

package gameboard;
import java.util.Random;

import cards.Flooded;

import java.util.ArrayList;
import java.util.Collections;

public class Board {
	public int[][] board = new int[6][6];
	
	// create new randomised board
	public Board() {
		// read in list of Island tiles
		// Collections.shuffle(tiles)
		
		// build game board
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				
				// skip invalid tiles
				if (i == 0 || i == 5) {
					if (j == 2 || j == 3) {
						// retrieve tile from front of list
					}
				}
				
				else if (i == 1 || i == 4) {
					if (j != 0 && j != 5) {
						// retrieve tile from front of list
					}
				}
				
				else {
					// retrieve tile from front of list
				}
			}
		}
	}
}
