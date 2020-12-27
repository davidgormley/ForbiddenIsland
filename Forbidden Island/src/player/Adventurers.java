package player;

import java.util.TreeMap;


/**
 * Singleton class to keep track of active players.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201223
 * @version: 1.0
 */

public class Adventurers {
	//===========================================================
	// Variable Setup
	//===========================================================
	private static Adventurers		adventurers;
	private TreeMap<Integer,Player>	players;

	//===========================================================
	// Private Constructor
	//===========================================================
	private Adventurers() {
		this.players = new TreeMap<Integer,Player>();
	}

	//===========================================================
	// Get Instance
	//===========================================================
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
}
