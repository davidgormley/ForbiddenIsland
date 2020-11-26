// There are 24 island tiles in total
// 2 Island tiles are associated with each treasure
// the Temple of the Moon and the Temple of the Sun are associated with
// the Earth Stone; the Whispering Garden and the Howling Garden are associated 
// with The Statue of the Wind; the Cave of Embers and the Cave of Shadows are 
// associated with the Crystal of Fire; the Coral Palace and the Tidal Palace are 
// associated with The Ocean’s Chalice.

package cards;

public class IslandTile extends Card{
	// DG: each tile has a flooded and unflooded side, should this be a boolean?
	// ORH: It could also be in 'sunk' state. 'Flooded' Enum has been created. 
	public Flooded flooded; 
	public boolean hasTreasure;				// tracks whether tile contains a treasure
	
	// constructor
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
	
	// Returns string containing card attributes
	public String toString() {
		return name + " (" + flooded + ")";
	}
}
