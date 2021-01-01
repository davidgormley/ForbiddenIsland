package main;

import java.util.Scanner;

import play.GameController;
import setup.*;

/**
 * Main class to play the game Forbidden Island.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201230
 * @version: 1.0
 */

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		GameSetup setup = GameSetup.getInstance();
		setup.setupNewGame(in);
		
		GameController GC = GameController.getInstance();
		GC.playGame(in);
		
		in.close();
		
		System.exit(0);
		
	}
}