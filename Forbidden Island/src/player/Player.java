package player;

/**
 * Class for a Player on the Board in a game of Forbidden Island.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201223
 * @version: 1.0
 */

public class Player {
	
    //===========================================================
    // Variable Setup
    //===========================================================
	private String	role;
	private int 	pawnPosition [];
	private String 	treasureCards [];
		
	
	//===========================================================
	// Constructor
	//===========================================================
	/**
	 * Constructor for room object.
	 * @param assignedRole The role of the player.
	 */
	public Player(String assignedRole) {
		role = assignedRole;
	}
	
	public String[] getPlayerTreasureCards() {
		return treasureCards;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String toString() {
		return "Player Role: "+this.role+", Player Cards: "+treasureCards+", Player Position: "+pawnPosition;
	}
	
	// Return the pawn position on 2D game board
	public int[] getPawnPosition() {
		return this.pawnPosition;
	}
	
	// Part of the actions available for each turn
	public void Move() {
		System.out.println("Moving piece adjacently");
	}
	
	// Part of the actions available for each turn
	public void ShoreUp() {
		System.out.println("Flip a tile from flooded to unflooded");
	}
	
	// Part of the actions available for each turn
	public void GiveTreasureCard() {
		System.out.println("Give treasure card to another player");
	}
	
	// Part of the actions available for each turn
	public void CaptureTreasureCard() {
		System.out.println("Capture treasure card");
	}
	
	public void DrawTreasureCard() {
		System.out.println("Draw treasure cards from the deck.");
	}
	
	public String getRole() {
		return this.role;
	}


}
