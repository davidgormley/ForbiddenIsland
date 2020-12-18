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
import deck.*;

public class Board {
	
	private IslandTile[][] board;
	
	private static Board gameboard = null;
	
	private Board() {
		board = new IslandTile[6][6];
	}
	
	public static Board getInstance() {
		if (gameboard == null) {
			gameboard = new Board();
			gameboard.fillBoard();
		}
		return gameboard;
	}
	
	// initialise new tiles deck
	private Stack<IslandTile> tiles_deck;{
		tiles_deck = new Stack<IslandTile>();
		tiles_deck.push(new IslandTile("Breakers Bridge", CardType.TILE, false));
		tiles_deck.push(new IslandTile("Bronze Gate", CardType.TILE, false));
		tiles_deck.push(new IslandTile("Cliffs of Abandon", CardType.TILE, false));
		tiles_deck.push(new IslandTile("Cave of Embers", CardType.TILE, true));
		tiles_deck.push(new IslandTile("Crimson Forest", CardType.TILE, false));
		tiles_deck.push(new IslandTile("Copper Gate", CardType.TILE, false));
		tiles_deck.push(new IslandTile("Coral Palace", CardType.TILE, true));
		tiles_deck.push(new IslandTile("Cave of Shadows", CardType.TILE, true));
		tiles_deck.push(new IslandTile("Dunes of Deception", CardType.TILE, false));
		tiles_deck.push(new IslandTile("Fool's Landing", CardType.TILE, false));
		tiles_deck.push(new IslandTile("Gold Gate", CardType.TILE, false));
		tiles_deck.push(new IslandTile("Howling Garden", CardType.TILE, true));
		tiles_deck.push(new IslandTile("Iron Gate", CardType.TILE, false));
		tiles_deck.push(new IslandTile("Lost Lagoon", CardType.TILE, false));
		tiles_deck.push(new IslandTile("Misty Marsh", CardType.TILE, false));
		tiles_deck.push(new IslandTile("Observatory", CardType.TILE, false));
		tiles_deck.push(new IslandTile("Phantom Rock", CardType.TILE, false));
		tiles_deck.push(new IslandTile("Silver Gate", CardType.TILE, false));
		tiles_deck.push(new IslandTile("Temple of the Moon", CardType.TILE, true));
		tiles_deck.push(new IslandTile("Tidal Palace", CardType.TILE, true));
		tiles_deck.push(new IslandTile("Temple of the Sun", CardType.TILE, true));
		tiles_deck.push(new IslandTile("Twilight Hollow", CardType.TILE, false));
		tiles_deck.push(new IslandTile("Whispering Garden", CardType.TILE, true));
		tiles_deck.push(new IslandTile("Watchtower", CardType.TILE, false));
	}
	
	// create new randomised board
	private void fillBoard() {
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
	
	// method to print simple board
	public void printBoard() {
		for (int i = 0; i < 6; i++) {
			
			// start new row
			System.out.println("\n");
			
			for (int j = 0; j < 6; j++) {
				// check if tile space is empty (i.e., in corner) or tile is sunk
				// then print the water symbol (a double tilde)
				if (board[i][j] == null || board[i][j].state() == Flooded.SUNK) {
					System.out.println("~~ ");
				}
				else {
					// check tile name against LUT and print acronym
					System.out.println(legend.get(board[i][j].getName()));
				}
				
			}
		}
	}
	
}
