package play;

import gameboard.*;
import deck.*;
import player.*;
import cards.*;

// Mock the board setup to test Capture.

public class GameDemo {

    public static void main(String[] args) {
        Board board = Board.getInstance(); // we set the board
        board.printBoard();

        Player p1 = new Player("P1"); // we set the players
        Player p2 = new Player("P2");
        Player p3 = new Player("P3");
        Player p4 = new Player("P4");

        p1.setRole("Engineer");
        p2.setRole("Pilot");
        p3.setRole("Diver");
        p4.setRole("Navigator");

        p1.setStartingPos();
        p2.setStartingPos();
        p3.setStartingPos();
        p4.setStartingPos();

        Card tcard1 = new Card("The Earth Stone", CardType.TREASURE);
        Card tcard2 = new Card("The Earth Stone", CardType.TREASURE);
        Card tcard3 = new Card("The Earth Stone", CardType.TREASURE);
        Card tcard4 = new Card("The Earth Stone", CardType.TREASURE);

        p1.giveCard(tcard1);
        p1.giveCard(tcard2);
        p1.giveCard(tcard3);
        p1.giveCard(tcard4);

        board.floodTile("Temple of the Moon");
        board.floodTile("Temple of the Moon");

        p1.viewInventory();
        p1.setPos(board.tileCoords("Temple of the Moon")[0], board.tileCoords("Temple of the Moon")[1]);

        // Need to find a way to pass in the players position.
        System.out.println(Capture.isValid(board, p1, TreasureType.EARTH_STONE));
    }

}
