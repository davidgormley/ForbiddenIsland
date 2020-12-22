package cards;

/**
 * Class for the island tiles on the board
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201223
 * @version: 1.0
 */

public class IslandTile extends Card{

	//===========================================================
    // Variable Setup
    //===========================================================
	Flooded 		flooded; 
	private boolean hasTreasure;
	
	//===========================================================
	// Constructor
	//===========================================================
	/**
	 * Constructor for island tile object.
	 * @param name The name of the island tile.
	 * @param type The type of card.
	 * @param hasTreasure If the tile has a treasure or not.
	 */
	public IslandTile(String name, CardType type, boolean hasTreasure) {
		super(name,type);
		this.flooded = Flooded.DRY;			// default state is dry
		this.hasTreasure = hasTreasure;
	}
	
	// method to change flood state
	// ORH: will a check against flood state be made in player method before calling this method?
	// i.e., is the last else / error statement here needed?
	public void flood() {
		if (flooded == Flooded.DRY) {
			flooded = Flooded.FLOODED;}
		else if (flooded == Flooded.FLOODED) {
			flooded = Flooded.SUNK;}
		else {
			System.out.println("Tile is already sunk.");}	// invalid action
	}
	
	// method to shore up a flooded tile
	// ORH: will a check against flood state be made in player method before calling this method?
	public void shoreUp() {
		if (flooded == Flooded.FLOODED) {
			flooded = Flooded.DRY;}
		else {
			System.out.println("Only flooded tiles may be shored up.");}	// invalid action
	}
	
	// method to check whether a treasure can be captured
	public boolean isLootable() {
		if (hasTreasure == true) {
			return true;}
		else {
			return false;}
	}
	
	// method to invoke when capturing a treasure
	public void loot() {
		hasTreasure = false;
	}
	
	// Getters
	public String getName() {
		return this.name;
	}
	
	public Flooded state() {
		return this.flooded;
	}
	
	// Returns string containing card attributes
	public String toString() {
		return name + " (" + flooded + ")";
	}
}
