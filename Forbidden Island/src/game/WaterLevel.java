package game;

import java.util.Scanner;

/**
 * This class handles the water level for the game.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201223
 * @version: 1.0
 */

public class WaterLevel {
	//===========================================================
    // Variable Setup
    //===========================================================
	private static WaterLevel waterLevel;
	private int wlvl;
	public Scanner in;
	
	//===========================================================
    // Constructor
    //===========================================================
	private WaterLevel() {
		this.in = new Scanner(System.in);
		this.wlvl = setWaterLevel(in);
	}
	
	//===========================================================
    // Get Instance
    //===========================================================
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
	 * @return
	 */
	private int setWaterLevel(Scanner in) {
		int wlvl;
		
		// use do-while to repeat until a valid input is received
		do {
			System.out.println("Set flood level? Enter integer between 1 and 5:");
			wlvl = in.nextInt();
		}while (wlvl < 1 && wlvl > 5);
		
		return wlvl;
	}
	
	/**
	 * Returns the current water level.
	 * @return
	 */
	public int getWaterLevel() {
		return this.wlvl;
	}
	
	/**
	 * Method to increment the water level.
	 */
	public void incrementWaterLevel() {
		if (this.wlvl < 10){
			this.wlvl++;
		}
	}
	
}
