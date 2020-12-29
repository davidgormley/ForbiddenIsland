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
        p1.setRole("Engineer");
        Player p2 = new Player("P2");
        p2.setRole("Pilot");
        Player p3 = new Player("P3");
        p3.setRole("Diver");
        Player p4 = new Player("P4");
        p4.setRole("Navigator");

        Card tcard1 = new Card("The Earth Stone", CardType.TREASURE);
        Card tcard2 = new Card("The Earth Stone", CardType.TREASURE);
        Card tcard3 = new Card("The Earth Stone", CardType.TREASURE);
        Card tcard4 = new Card("The Earth Stone", CardType.TREASURE);

        p1.giveCard(tcard1);
        p1.giveCard(tcard2);
        p1.giveCard(tcard3);
        p1.giveCard(tcard4);

        p1.viewInventory();

        // Need to find a way to pass in the players position.
        // Capture.isValid(board, player)
    }

}
