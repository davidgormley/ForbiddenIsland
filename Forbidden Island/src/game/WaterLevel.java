package game;

import java.util.Scanner;

/**
 * This class handles the water level for the game.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201230
 * @version: 1.0
 */

public class WaterLevel {
	
	//===========================================================
    // Variable Setup
    //===========================================================
	private static WaterLevel 	waterLevel;
	private int 				wlvl;
	
	//===========================================================
    // Constructor
    //===========================================================
	/**
	 * Create water level object
	 */
	private WaterLevel() {
		this.wlvl = 0;
	}
	
	//===========================================================
    // Get Instance
    //===========================================================
	/**
	 * Get instance of water level object
	 * @return waterLevel Water level object
	 */
	public static WaterLevel getInstance() {
		if (waterLevel == null) {
			waterLevel = new WaterLevel();
		}
		return waterLevel;
	}
	
	//===========================================================
    // Methods
    //===========================================================
	/**
	 * This method lets the user set the water level at the 
	 * beginning of a new game.
	 * @param in Scanner to read in user input.
	 * @return integer object to accept new input
	 */
	public void setWaterLevel(Scanner in) {
		int wlvl;
		
		// use do-while to repeat until a valid input is received
		do {
			System.out.println("Set flood level? Enter integer between 1 and 5:");
			wlvl = in.nextInt();
		}while (wlvl < 1 && wlvl > 5);
	}
	
	/**
	 * Returns the current water level.
	 * @return integer object to set new input
	 */
	public int getWaterLevel() {
		return this.wlvl;
	}
	
	/**
	 * Method to increment the water level.
	 */
	public void incrementWaterLevel() {
		if (this.wlvl < 11){
			this.wlvl++;
		}
	}
	
	/**
	 * Determines how many flood cards to draw based on current
	 * water meter level.
	 * @return
	 */
	public int cardsToDraw() {
		if (this.wlvl < 3)
			return 2;
		else if (wlvl < 6)
			return 3;
		else if (wlvl < 8)
			return 4;
		else 
			return 5;
	}
}
