package play;

import java.util.Scanner;
import gameboard.Board;
import player.Adventurers;

/**
 * This class handles manages to running of the game, including player turns
 * and checking of win/lose conditions.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201230
 * @version: 1.0
 */

public class GameController {
	//===========================================================
    // Variable Setup
    //===========================================================
	private static GameController 	GC;
	
	Adventurers players = 			Adventurers.getInstance();
	Board board = 					Board.getInstance();
	Scanner 						in;
	private boolean 				Win;
	private boolean					Lose;
	
	//===========================================================
    // Constructor
    //===========================================================
	private GameController() {
		this.Win = false;
		this.Lose = false;
		this.players = Adventurers.getInstance();
		this.board = board.getInstance();
	}
	
	//===========================================================
    // Get Instance
    //===========================================================
	public static GameController getInstance() {
		if (GC == null) {
			GC = new GameController();
		}
		return GC;
	}
	
	//===========================================================
    // Methods
    //===========================================================
	public void playGame(Scanner in) {
		
	}
}
