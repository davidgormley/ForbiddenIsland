package player;

import java.util.TreeMap;
import cards.TreasureType;
import gameboard.Board;


/**
 * Singleton class to keep track of active players.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201230
 * @version: 1.0
 */

public class Adventurers {
	
	//===========================================================
	// Variable Setup
	//===========================================================
	private static Adventurers				adventurers;
	private TreeMap<Integer,Player>			players;
	private TreeMap<TreasureType,Boolean>	treasures;
	Board 									board = Board.getInstance();

	//===========================================================
	// Private Constructor
	//===========================================================
	/**
	 * Create the adventurers list.
	 */
	private Adventurers() {
		this.players = new TreeMap<Integer,Player>();
		this.treasures = new TreeMap<TreasureType,Boolean>();
		setTreasures();
	}

	//===========================================================
	// Get Instance
	//===========================================================
	/**
	 * Get instance of the adventurers list.
	 * @return adventurers List of players
	 */
	public static Adventurers getInstance() {
		if (adventurers == null) {
			adventurers = new Adventurers();
		}
		return adventurers;
	}

	//===========================================================
	// Methods
	//===========================================================
	/**
	 * Adds players to the adventurers list.
	 * @param pnum Play order number.
	 * @param p The player to be added.
	 */
	public void addPlayer(int pnum, Player p) {
		this.players.put(pnum, p);
	}
	
	/**
	 * Returns the player specified by play order number.
	 * @param pnum Play order number.
	 * @return The player.
	 */
	public Player getPlayer(int pnum) {
		return this.players.get(pnum);
	}
	
	/**
	 * Returns the number of players.
	 * @return Integer
	 */
	public int numPlayers() {
		return this.players.size();
	}
	
	/**
	 * Prints out each active player in the play order.
	 */
	public void printList() {
		if (this.numPlayers() > 0) {
			for (int i = 1; i <= this.numPlayers(); i++) {
				System.out.println(i + ". " + players.get(i).getName());
			}
		}
	}
	
	/**
	 * This method initialises the treasure tracker for the group of
	 * plucky adventurers.
	 */
	private void setTreasures() {
		treasures.put(TreasureType.EARTH_STONE, false);
		treasures.put(TreasureType.CRYSTAL_OF_FIRE, false);
		treasures.put(TreasureType.OCEAN_CHALICE, false);
		treasures.put(TreasureType.STATUE_OF_WIND,false);
	}
	
	/**
	 * Adds captured treasure to list.
	 * @param treasure TreasureType Enum representing capture treasures.
	 */
	public void addTreasure(TreasureType treasure) {
		treasures.replace(treasure, true);
	}
	
	/**
	 * Checks whether a specified treasure has been captured.
	 * @param treasure TreasureType Enum representing capture treasures.
	 */
	public boolean haveTreasure(TreasureType treasure) {
		if (treasures.get(treasure) == true) {
			return true;
		}
		return false;
	}
	
	/**
	 * Prints out a list of captured treasures.
	 */
	public void capturedTreasures() {
		System.out.println("\nTreasure Collection:");
		
		for (TreasureType treasure : treasures.keySet()) {
			if (treasures.get(treasure) == true) {
				System.out.println(treasure.toString());
			}
		}
	}
	
	/**
	 * Print current player locations.
	 */
	public void playerLocations() {
		int[] pos;
		String tile;
		
		for (int p : players.keySet()) {
			pos = getPlayer(p).getPawnPosition();
			tile = board.getTileName(pos[0],pos[1]);
			System.out.println(getPlayer(p).getName() + ": " + tile);
		}
	}
}
