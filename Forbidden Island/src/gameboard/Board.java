// Water Meter measures the level of the water in the island, which can range from 1 to 5
// should water meter logic be added in here?

// The number of players should range from 2 to 4. Each Player can have a role: Engineer,
// Explorer, Diver, Pilot, Messenger, Navigator. Depending on his/her role, a player’s pawn
// will be placed initially on a specific Island tile. The Engineer will be placed on Bronze Gate,
// the Explorer will be placed on Copper Gate, the Diver will be placed on Iron Gate, the Pilot 
// will be placed on Fools’ Landing, the Messenger will be placed on Silver Gate, and the Navigator 
// will be placed on Gold Gate.  

package gameboard;
import java.util.*;
import cards.*;

public class Board {
	public IslandTile[][] board = new IslandTile[6][6];
	
	// Map legend LUT. Key is the full name as string.
	// Value is a 2-char acronym string. 
	public Map<String, String> legend;{
		legend = new HashMap<String, String>();
		legend.put("Breakers Bridge", "BB");
		legend.put("Bronze Gate","BG");
		legend.put("Cliffs of Abandon","CA");
		legend.put("Cave of Embers","CE");
		legend.put("Crimson Forest","CF");
		legend.put("Copper Gate","CG");
		legend.put("Coral Palace","CP");
		legend.put("Cave of Shadows","CS");
		legend.put("Dunes of Deception","DD");
		legend.put("Fool's Landing","FL");
		legend.put("Gold Gate","GG");
		legend.put("Howling Garden","HG");
		legend.put("Iron Gate","IG");
		legend.put("Lost Lagoon","LL");
		legend.put("Misty Marsh","MM");
		legend.put("Observatory","OB");
		legend.put("Phantom Rock","PR");
		legend.put("Silver Gate","SG");
		legend.put("Temple of the Moon","TM");
		legend.put("Tidal Palace","TP");
		legend.put("Temple of the Sun","TS");
		legend.put("Twilight Hollow","TH");
		legend.put("Whispering Garden","WG");
		legend.put("Watchtower","WT");
	}
	
	// create new randomised board
	public Board(Stack<IslandTile> tiles_deck) {
		// shuffle Island Tiles deck
		Collections.shuffle(tiles_deck);
		
		// build game board
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				
				// skip invalid tiles
				if (i == 0 || i == 5) {
					// add tile to valid spaces
					if (j == 2 || j == 3) {
						// retrieve tile from front of list
						board[i][j] = tiles_deck.pop();
					}
				}
				
				// skip invalid tiles
				else if (i == 1 || i == 4) {
					// add tile to valid spaces
					if (j != 0 && j != 5) {
						// retrieve tile from front of list
						board[i][j] = tiles_deck.pop();
					}
				}
				
				else {
					// retrieve tile from front of list
					board[i][j] = tiles_deck.pop();
				}
			}
		}
	}
	
	// method to print simple board
	public void printBoard() {
		for (int i = 0; i < 6; i++) {
			
			// start new row
			System.out.println("\n");
			
			for (int j = 0; j < 6; j++) {
				if (board[i][j] == null || board[i][j].state() == Flooded.SUNK) {
					System.out.println("~~ ");
				}
				else {
					System.out.println(legend.get(board[i][j].getName()));
				}
				
			}
		}
	}
	
}
