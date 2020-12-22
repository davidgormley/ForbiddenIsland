package cards;

/**
 * Class for the island tiles on the board
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201223
 * @version: 1.0
 */

public class Treasure {
	
	//===========================================================
    // Variable Setup
    //===========================================================
	private String 	name;
	private boolean captured;
	
	//===========================================================
	// Getters and Setters
	//===========================================================
	/**
	 * gets the Treasure name
	 * @return name The name of the Treasure
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * sets the Treasure name
	 * @param name Name of the treasure
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isCaptured() {
		return captured;
	}
	
	public void setCaptured(boolean captured) {
		this.captured = captured;
	}
}
