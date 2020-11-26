// There are 4 pawns, each of them assigned to a player. Should they be added in here?
// Engineer will be placed on Bronze Gate, the Explorer will be placed on Copper Gate,
// the Diver will be placed on Iron Gate, the Pilot will be placed on Fools’ Landing,
// the Messenger will be placed on Silver Gate, and the Navigator will be placed on Gold Gate


//Assign a role to each player: Randomly assign to each player one of the following roles: 
//Explorer, Diver, Pilot, Engineer, Messenger and Navigator.

package player;

public class Player {
	
	public String name;
	
	// constructor
	public Player(String name) {
		//super
		this.name = name;
		//this.flooded = Flooded.DRY;			// default state is dry
	}


}
