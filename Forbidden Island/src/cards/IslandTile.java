package cards;

/**
 * Class for the island tiles on the board
 * 
 * @author: Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date: 201230
 * @version: 1.0
 */

public class IslandTile extends Card {

	// ===========================================================
	// Variable Setup
	// ===========================================================
	Flooded flooded;
	private TreasureType treasureType;

	// ===========================================================
	// Constructor
	// ===========================================================
	/**
	 * Constructor for island tile object.
	 * 
	 * @param name        The name of the island tile.
	 * @param type        The type of card.
	 * @param hasTreasure If the tile has a treasure or not.
	 */
	public IslandTile(String name, CardType type, TreasureType treasureType) {
		super(name, type);
		this.flooded = Flooded.DRY; // default state is dry
		this.treasureType = treasureType;
	}

	//===========================================================
	// Getters and Setters
	//===========================================================
	/**
	 * Return the name of the tile.
	 * @return String containing name of the Island tile
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Return the TreasureType of the island tile.
	 * @return treasuretype containing treasure type of the Island tile
	 */
	public TreasureType getTreasureType() {
		return treasureType;
	}
	
	//===========================================================
	// Other Functions
	//===========================================================
	/**
	 * Method to change flood state
	 * ORH: will a check against flood state be made in player method before calling
	 * this method? i.e., is the last else / error statement here needed?
	 */
	public void flood() {
		if (flooded == Flooded.DRY) {
			flooded = Flooded.FLOODED;
		} else if (flooded == Flooded.FLOODED) {
			flooded = Flooded.SUNK;
		} else {
			System.out.println("Tile is already sunk.");
		} // invalid action
	}

	/**
	 * Method to shore up a flooded tile
	 * ORH: will a check against flood state be made in player method before calling
	 * this method?
	 */
	public void shoreUp() {
		if (flooded == Flooded.FLOODED) {
			flooded = Flooded.DRY;
		} else {
			System.out.println("Only flooded tiles may be shored up.");
		} // invalid action
	}

	/**
	 * Method to check whether a treasure can be captured
	 * @return boolean whether a treasure card has been captured
	 */
	public boolean isLootable() {
		return this.treasureType != TreasureType.NONE;
	}

	/**
	 * Method to invoke when capturing a treasure
	 */
	public void loot() {
		this.treasureType = TreasureType.NONE;
	}
	
	/**
	 * Return the flooded state of the tile.
	 * @return Flooded containing flooded state of the Island tile
	 */
	public Flooded state() {
		return this.flooded;
	}

	/**
	 * Return the toString of the Island tile.
	 * @return String containing flooded state of the Island tile and the name
	 */
	public String toString() {
		return name + " (" + flooded + ")";
	}
}
