package gameboard;
import tiles.Flooded;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Board {
	public int[][] board = new int[6][6];
	
	// create new randomised board
	public Board() {
		// read in list of Island tiles
		// Collections.shuffle(tiles)
		
		// build game board
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				
				// skip invalid tiles
				if (i == 0 || i == 5) {
					if (j == 2 || j == 3) {
						// retrieve tile from front of list
					}
				}
				
				else if (i == 1 || i == 4) {
					if (j != 0 && j != 5) {
						// retrieve tile from front of list
					}
				}
				
				else {
					// retrieve tile from front of list
				}
			}
		}
	}
}
