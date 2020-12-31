import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import cards.*;
import player.*;
import gameboard.*;

public class BoardTest {

    @Test
    public void test_board_creation() {
        Board board = Board.getInstance();

        // We test the corners of the board.
        Assertions.assertEquals(board.isValidTile(0, 2), true);
        Assertions.assertEquals(board.isValidTile(0, 3), true);
        Assertions.assertEquals(board.isValidTile(0, 1), false);
        Assertions.assertEquals(board.isValidTile(0, 4), false);

        Assertions.assertEquals(board.isValidTile(2, 0), true);
        Assertions.assertEquals(board.isValidTile(3, 0), true);
        Assertions.assertEquals(board.isValidTile(1, 0), false);
        Assertions.assertEquals(board.isValidTile(4, 0), false);

        Assertions.assertEquals(board.isValidTile(5, 2), true);
        Assertions.assertEquals(board.isValidTile(5, 3), true);
        Assertions.assertEquals(board.isValidTile(5, 1), false);
        Assertions.assertEquals(board.isValidTile(5, 4), false);

        Assertions.assertEquals(board.isValidTile(2, 5), true);
        Assertions.assertEquals(board.isValidTile(3, 5), true);
        Assertions.assertEquals(board.isValidTile(1, 5), false);
        Assertions.assertEquals(board.isValidTile(4, 5), false);
    }

}
