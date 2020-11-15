package tiles;

public class IslandTile {
	public String name;
	public Flooded flooded;
	
	// constructor
	public IslandTile(String name) {
		this.name = name;
		this.flooded = Flooded.DRY;			// default state is dry
	}
}
