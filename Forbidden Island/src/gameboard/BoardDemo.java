package gameboard;

import java.util.Arrays;

public class BoardDemo {

	public static void main(String[] args) {
		// create new board and print
		Board gameboard = Board.getInstance();
		gameboard.printBoard();
		gameboard.printLegend();
		
		// test location finder
		System.out.println(Arrays.toString(gameboard.tileCoords("Fool's Landing")));
		
		// test remove method
		System.out.println(gameboard.toString(3,3));
		gameboard.removeTile(3,3);
		System.out.println(gameboard.toString(3,3));
	}
}
