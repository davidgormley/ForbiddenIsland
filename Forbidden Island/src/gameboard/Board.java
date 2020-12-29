package gameboard;

import java.util.*;
import cards.*;
import deck.*;

public class Board {
	//===========================================================
	// Variable Setup
	//===========================================================
	private IslandTile[][] board;
	
	private static Board gameboard;
	
	//===========================================================
	// Private Constructor
	//===========================================================
	private Board() {
		this.board = new IslandTile[6][6];
	}
	
	//===========================================================
	// Get Instance
	//===========================================================
	public static Board getInstance() {
		if (gameboard == null) {
			gameboard = new Board();
			gameboard.fillBoard();
		}
		return gameboard;
	}
	
	//===========================================================
	// Methods
	//===========================================================
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
	 * Map legend LUT. Key is the full name as string.
	 * Value is a 2-char acronym string. 
	 */
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
				}
				else {
					// check tile name against LUT and print acronym
					System.out.print(legend.get(board[i][j].getName()) + " ");
				}
				
			}
		}
		System.out.println("\n");
	}
	
	/**
	 * Method to print the map legend
	 */
	public void printLegend() {
		System.out.println("\nMap Legend:\n===========");
		legend.forEach((k,v)-> System.out.println(v + ": " + k));
	}
	
	/**
	 * Method to return location of a given tile on the board.
	 * @param tile_name Name of the tile as string.
	 * @return two-element int array
	 */
	public int[] tileCoords(String tile_name){
		int[] coords = new int[2];
		outerloop:
		for (int i = 0; i < 6; i++) {
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
	 * @param i	tile row index
	 * @param j	tile column index
	 */
	public void removeTile(int i, int j) {
		// need to check input values or whether tile is already removed?
		board[i][j] = null;
	}
	
	/**
	 * Method which returns the name of the tile at a 
	 * specified location.
	 * @param i	tile row index
	 * @param j tile column index
	 * @return
	 */
	public String toString(int i, int j) {
		if (board[i][j] == null){
			return "Water...";
		}
		else {
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
	 * @param i	tile row index
	 * @param j	tile column index
	 * @return Flood state enum
	 */
	public Flooded getState(int i, int j) {
		return board[i][j].state();
	}
	
	/**
	 * Calls shoreUp() on specified tile
	 * @param i	tile row index
	 * @param j	tile column index
	 */
	public void shoreUp(int i, int j) {
		board[i][j].shoreUp();
	}
	
	/**
	 * Method which iterates through board tiles and creates a TreeMap with K,V 
	 * pair of a number (int) and tile name (string). An intended use of this 
	 * method is in presenting a list of valid tiles to a player who can then
	 * easily select one via the assigned key int. This helps make selections
	 * quicker and inputs easier to validate.
	 * @return
	 */
	public TreeMap<Integer,String> activeTiles() {
		int tilecounter = 0;
		String tilename;
		TreeMap<Integer,String> tiles = new TreeMap<Integer,String>();
		
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
	 * @param i	tile row index
	 * @param j	tile column index
	 * @return Boolean
	 */
	public boolean isValidTile(int i, int j) {
		if (board[i][j] != null && board[i][j].state() != Flooded.SUNK) {
			return true;
		}
		return false;
	}
	
	/**
	 * Method to return the name of a tile at a specified position.
	 * Note: be careful to check context of use as this method will return
	 * "Water..." rather than tile name if specified position position contains
	 * an invalid tile.
	 * @param i
	 * @param j
	 * @return
	 */
	public String getTileName(int i, int j) {
		if (isValidTile(i,j) == true) {
			return board[i][j].getName();
		}
		return ("Water...");
	}
}
