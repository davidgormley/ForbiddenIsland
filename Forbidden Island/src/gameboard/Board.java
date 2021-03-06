package gameboard;

import java.util.*;
import cards.*;
import deck.*;
import player.Adventurers;

/**
 * Class to set up the Board for Forbidden Island.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    2012230
 * @version: 1.0
 */

public class Board {
	
	// ===========================================================
	// Variable Setup
	// ===========================================================
	private IslandTile[][] 	board;
	private static Board 	gameboard;

	// ===========================================================
	// Private Constructor
	// ===========================================================
	/**
	 * Create a new 6by6 board
	 */
	private Board() {
		this.board = new IslandTile[6][6];
	}

	// ===========================================================
	// Get Instance
	// ===========================================================
	/**
	 * Get instance of gameboard
	 * @return gameboard Game board object
	 */
	public static Board getInstance() {
		if (gameboard == null) {
			gameboard = new Board();
			gameboard.fillBoard();
		}
		return gameboard;
	}

	// ===========================================================
	// Methods
	// ===========================================================
	/**
	 * Method to fill a new randomised board.
	 */
	private void fillBoard() {
		// create and fill tiles deck
		Deck<IslandTile> tiles_deck = new Deck<IslandTile>();
		tiles_deck.fillWithIslandTiles();

		// shuffle Island Tiles deck
		tiles_deck.shuffleDeck();

		// build game board
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {

				// skip invalid tiles
				if (i == 0 || i == 5) {
					// add tile to valid spaces
					if (j == 2 || j == 3) {
						// retrieve tile from front of list
						board[i][j] = tiles_deck.drawCard();
					}
				}

				// skip invalid tiles
				else if (i == 1 || i == 4) {
					// add tile to valid spaces
					if (j != 0 && j != 5) {
						// retrieve tile from front of list
						board[i][j] = tiles_deck.drawCard();
					}
				}

				else {
					// retrieve tile from front of list
					board[i][j] = tiles_deck.drawCard();
				}
			}
		}
	}

	/**
	 * Map legend LUT. Key is the full name as string. Value is a 2-char acronym
	 * string.
	 */
	public Map<String, String> legend;
	{
		legend = new HashMap<String, String>();
		legend.put("Breakers Bridge", "BB");
		legend.put("Bronze Gate", "BG");
		legend.put("Cliffs of Abandon", "CA");
		legend.put("Cave of Embers", "CE");
		legend.put("Crimson Forest", "CF");
		legend.put("Copper Gate", "CG");
		legend.put("Coral Palace", "CP");
		legend.put("Cave of Shadows", "CS");
		legend.put("Dunes of Deception", "DD");
		legend.put("Fool's Landing", "FL");
		legend.put("Gold Gate", "GG");
		legend.put("Howling Garden", "HG");
		legend.put("Iron Gate", "IG");
		legend.put("Lost Lagoon", "LL");
		legend.put("Misty Marsh", "MM");
		legend.put("Observatory", "OB");
		legend.put("Phantom Rock", "PR");
		legend.put("Silver Gate", "SG");
		legend.put("Temple of the Moon", "TM");
		legend.put("Tidal Palace", "TP");
		legend.put("Temple of the Sun", "TS");
		legend.put("Twilight Hollow", "TH");
		legend.put("Whispering Garden", "WG");
		legend.put("Watchtower", "WT");
	}

	/**
	 * Method to print simple board
	 */
	public void printBoard() {
		for (int i = 0; i < 6; i++) {

			// start new row
			System.out.println("\n");

			for (int j = 0; j < 6; j++) {
				// check if tile space is empty (i.e., in corner) or tile is sunk
				// then print the water symbol (a double tilde)
				if (board[i][j] == null || board[i][j].state() == Flooded.SUNK) {
					System.out.print("~~ ");
				} else {
					// check tile name against LUT and print acronym
					System.out.print(legend.get(board[i][j].getName()) + " ");
				}

			}
		}
		System.out.println("\n");
	}
	
	/**
	 * Prints a more detailed version of the board. Each tile is presented in
	 * a 3x4 format as follows:
	 * |1234| <- numbers correspond to players currently on tile
	 * | FL | <- corresponds to tile name acronyms from LUT
	 * |D  T| <- left : flood state (D=Dry, F=Flooded); right: treasure availability (T=treasure can be captured here)
	 * @param players
	 */
	public void printBoardFull(Adventurers players) {
		// StringBuffer array for building mutable strings
		StringBuffer[] map_strings = new StringBuffer[25];
		// initialise array and set capacities
		for (int n = 0; n < 25; n++) {
			map_strings[n] = new StringBuffer("");
			map_strings[n].ensureCapacity(36);
		}
		
		// iterate over tiles and build formatted strings
		for (int i = 0; i < 6; i++) {
			// add borders
			if (i==0 || i*4==4 || i*4==8 || i*4==12 || i*4==16 || i*4==20) {
				map_strings[i*4].append("------------------------------------");}
			
			// fill tile bodies
			for (int j = 0; j < 6; j++) {
				// check if null or sunk tile
				if (board[i][j] == null || board[i][j].state() == Flooded.SUNK) {
					map_strings[i*4 + 1].append(" ~ ~ ~");
					map_strings[i*4 + 2].append("~ ~ ~ ");
					map_strings[i*4 + 3].append(" ~ ~ ~");
				}
				
				else {
					map_strings[i*4 + 1].append(playerLocPrntStr(i,j,players));
					map_strings[i*4 + 2].append(tileNamePrntStr(i,j));
					map_strings[i*4 + 3].append(stateTreasurePrntStr(i,j));
				}
			}
		}
		map_strings[24].append("------------------------------------");
		
		// print map
		for(int n = 0; n < 25; n++)
			System.out.println(map_strings[n].toString());
	}

	/**
	 * Support for function for printing full board. Handles player location row.
	 * @param i Row
	 * @param j Col
	 * @param players Adventurers object
	 * @return String
	 */
	private String playerLocPrntStr(int i, int j, Adventurers players) {
		StringBuffer on_tile = new StringBuffer(6);
		on_tile.append("|");
		
		int[] loc = {i,j};
		for (int p = 1; p <= players.numPlayers(); p++) {
			if (Arrays.equals(loc,players.getPlayer(p).getPawnPosition()) == true)
				on_tile.append(String.valueOf(p));
			else
				on_tile.append(" ");
		}
		
		if (players.numPlayers() == 2)
			on_tile.append("  ");
		else if (players.numPlayers() == 3)
			on_tile.append(" ");
		
		on_tile.append("|");
		
		return on_tile.toString();
	}
	
	/**
	 * Support method for printing full board. Handles tile name row.
	 * @param i Row
	 * @param j Col
	 * @return String
	 */
	private String tileNamePrntStr(int i, int j) {
		StringBuffer tname = new StringBuffer(6);
		tname.append("| ");
		tname.append(legend.get(board[i][j].getName()));
		tname.append(" |");
		return tname.toString();
	}
	
	/**
	 * Support method for printing full board. Handles tile State and Treasure row.
	 * @param i
	 * @param j
	 * @return
	 */
	private String stateTreasurePrntStr(int i, int j) {
		String line = "|";
		// add flood state in lower left corner
		if (this.board[i][j].state() == Flooded.DRY)
			line = line + "D  ";
		else
			line = line + "F  ";
		// add treasure indicator in bottom right corner
		if (board[i][j].isLootable() == true)
			line = line + "T|";
		else
			line = line + " |";
		
		return line;
	}
	
	/**
	 * Method to print the map legend
	 */
	public void printLegend() {
		System.out.println("\nMap Legend:\n===========");
		legend.forEach((k, v) -> System.out.println(v + ": " + k));
	}

	/**
	 * Method to get a tile from the board using the coordinates given.
	 * @param i tile row index
	 * @param j tile column index
	 */
	public IslandTile getTileAt(int i, int j) {
		return board[i][j];
	}

	/**
	 * Method to return location of a given tile on the board.
	 * @param tile_name Name of the tile as string.
	 * @return two-element int array
	 */
	public int[] tileCoords(String tile_name) {
		int[] coords = new int[2];
		outerloop: for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (board[i][j] != null) {
					if (board[i][j].getName() == tile_name) {
						coords[0] = i;
						coords[1] = j;
						break outerloop;
					}
				}
			}
		}
		return coords;
	}

	/**
	 * Method to remove a tile from the board.
	 * @param i tile row index
	 * @param j tile column index
	 */
	public void removeTile(int i, int j) {
		// need to check input values or whether tile is already removed?
		board[i][j] = null;
	}

	/**
	 * Method which returns the name of the tile at a specified location.
	 * @param i tile row index
	 * @param j tile column index
	 * @return String name of the individual tile or water
	 */
	public String toString(int i, int j) {
		if (board[i][j] == null) {
			return "Water...";
		} else {
			return board[i][j].getName();
		}
	}

	/**
	 * Flood a specified tile on the board.
	 * @param tile_name Tile name as string.
	 */
	public void floodTile(String tile_name) {
		int[] pos = tileCoords(tile_name);
		board[pos[0]][pos[1]].flood();
	}

	/**
	 * Returns the flood state of tile at location
	 * @param i tile row index
	 * @param j tile column index
	 * @return Flood state enum
	 */
	public Flooded getState(int i, int j) {
		return board[i][j].state();
	}

	/**
	 * Calls shoreUp() on specified tile
	 * @param i tile row index
	 * @param j tile column index
	 */
	public void shoreUp(int i, int j) {
		board[i][j].shoreUp();
	}

	/**
	 * Method which iterates through board tiles and creates a TreeMap with K,V pair
	 * of a number (int) and tile name (string). An intended use of this method is
	 * in presenting a list of valid tiles to a player who can then easily select
	 * one via the assigned key int. This helps make selections quicker and inputs
	 * easier to validate.
	 * @return tiles Tiles of the board
	 */
	public TreeMap<Integer, String> activeTiles() {
		int tilecounter = 0;
		String tilename;
		TreeMap<Integer, String> tiles = new TreeMap<Integer, String>();

		// iterate and find valid tiles
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (board[i][j] != null && board[i][j].state() != Flooded.SUNK) {
					tilecounter++;
					tilename = board[i][j].getName();
					tiles.put(tilecounter, tilename);
				}
			}
		}

		return tiles;
	}

	/**
	 * Checks if the specified tile is a valid active tile.
	 * @param i tile row index
	 * @param j tile column index
	 * @return Boolean For valid tile
	 */
	public boolean isValidTile(int i, int j) {
		if (board[i][j] != null && board[i][j].state() != Flooded.SUNK) {
			return true;
		}
		return false;
	}

	/**
	 * Method to return the name of a tile at a specified position. Note: be careful
	 * to check context of use as this method will return "Water..." rather than
	 * tile name if specified position position contains an invalid tile.
	 * @param i tile row index
	 * @param j tile column index
	 * @return Tile name as String
	 */
	public String getTileName(int i, int j) {
		if (isValidTile(i, j) == true) {
			return board[i][j].getName();
		}
		return ("Water...");
	}
	
	/**
	 * Method to return a tile at a specified location.
	 * NOTE: be sure to validate tile BEFORE calling this method.
	 * @param i tile row index
	 * @param j tile column index
	 * @return IslandTile
	 */
	public IslandTile getTile(int i, int j) {
		return board[i][j];
	}
	
	/**
	 * Method to return the treasure type of the tile at position (i,j).
	 * @param i tile row index
	 * @param j tile column index
	 * @return TreasureType enum
	 */
	public TreasureType getTreasureType(int i, int j) {
		return board[i][j].getTreasureType();
	}
	
	/**
	 * Flips the lootable boolean on tile when its treasure has been captured.
	 * @param i tile row index
	 * @param j tile column index
	 */
	public void treasureCaptured(int i, int j) {
		board[i][j].loot();
	}
}
