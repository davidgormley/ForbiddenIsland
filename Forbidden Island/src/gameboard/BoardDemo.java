package gameboard;


public class BoardDemo {

	public static void main(String[] args) {
		Board gameboard = Board.getInstance();
		gameboard.printBoard();
		gameboard.printLegend();

	}

}
