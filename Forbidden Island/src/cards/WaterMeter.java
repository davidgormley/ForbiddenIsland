package cards;

/**
 * Class for the Water Meter object to track water level
 * 
 * @author: Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date: 201230
 * @version: 1.0
 */

public class WaterMeter {

	// ===========================================================
	// Variable Setup
	// the minimum water level must be 1	
	// ===========================================================
	private int level = 1;

	// ===========================================================
	// Getters and Setters
	// ===========================================================
	/**
	 * gets the water meter level
	 * 
	 * @return level Water meter level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * sets the water meter level 
	 * checks if level is between 1-5
	 * 
	 * @param level Water meter level
	 */
	public void setLevel(int level) {
		if (level <= 5 && level > 0) {
			this.level = level;
		}
	}
}
