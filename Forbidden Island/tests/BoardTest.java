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

    @Test
    public void test_board_active_tiles() {
        Board board = Board.getInstance();

        int firstCount = board.activeTiles().size();

        board.floodTile("Fool's Landing");
        board.floodTile("Fool's Landing");

        int secondCount = board.activeTiles().size();

        Assertions.assertEquals(firstCount, 24);
        Assertions.assertEquals(secondCount, 23);
    }

    @Test
    public void test_board_coordinate_functions() {
        Board board = Board.getInstance();

        // Test for a few tiles.
        int flCoords[] = board.tileCoords("Fool's Landing");
        int tmCoords[] = board.tileCoords("Temple of the Moon");

        Assertions.assertEquals(board.getTileAt(flCoords[0], flCoords[1]).getName(), "Fool's Landing");
        Assertions.assertEquals(board.getTileAt(tmCoords[0], tmCoords[1]).getName(), "Temple of the Moon");
    }

    @Test
    public void test_board_looting() {
        Board board = Board.getInstance();

        int tmCoords[] = board.tileCoords("Temple of the Moon");
        board.treasureCaptured(tmCoords[0], tmCoords[1]);

        Assertions.assertEquals(board.getTileAt(tmCoords[0], tmCoords[1]).isLootable(), false);
    }
}
