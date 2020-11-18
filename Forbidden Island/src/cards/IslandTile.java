// There are 24 island tiles in total
// 2 Island tiles are associated with each treasure
// the Temple of the Moon and the Temple of the Sun are associated with
// the Earth Stone; the Whispering Garden and the Howling Garden are associated 
// with The Statue of the Wind; the Cave of Embers and the Cave of Shadows are 
// associated with the Crystal of Fire; the Coral Palace and the Tidal Palace are 
// associated with The Ocean’s Chalice.

package cards;

public class IslandTile {
	public String name;
	// each tile has a flooded and unflooded side, should this be a boolean?
	public Flooded flooded; 
	
	// constructor
	public IslandTile(String name) {
		this.name = name;
		this.flooded = Flooded.DRY;			// default state is dry
	}
}
