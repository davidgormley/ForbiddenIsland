package cards;

/**
 * Class for the island tiles on the board
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201223
 * @version: 1.0
 */

public class WaterMeter {
	
	//===========================================================
    // Variable Setup
    //===========================================================
	private int level = 0;
	
	
	//===========================================================
	// Getters and Setters
	//===========================================================
	/**
	 * gets the water meter level
	 * @return level Water meter level
	 */
	public int getLevel() {
		return level;
	}
	
	/**
	 * sets the water meter level
	 * @param level Water meter level
	 */
	public void setLevel(int level) {
		this.level = level;
	}
}
