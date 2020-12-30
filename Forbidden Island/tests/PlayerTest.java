import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import cards.*;
import player.*;
import gameboard.*;

public class PlayerTest {

    @Test
    public void test_initial_starting_positions() {
        Player engineer = new Player("p1");
        Player diver = new Player("p2");
        Player navigator = new Player("p3");
        Player pilot = new Player("p4");
        Player messenger = new Player("p5");
        Player explorer = new Player("p6");

        engineer.setRole("Engineer");
        diver.setRole("Diver");
        navigator.setRole("Navigator");
        pilot.setRole("Pilot");
        messenger.setRole("Messenger");
        explorer.setRole("Explorer");

        engineer.setStartingPos();
        diver.setStartingPos();
        navigator.setStartingPos();
        pilot.setStartingPos();
        messenger.setStartingPos();
        explorer.setStartingPos();

        Board board = Board.getInstance();

        Assertions.assertEquals(Arrays.toString(engineer.getPawnPosition()),
                Arrays.toString(board.tileCoords("Bronze Gate")));
        Assertions.assertEquals(Arrays.toString(diver.getPawnPosition()),
                Arrays.toString(board.tileCoords("Iron Gate")));
        Assertions.assertEquals(Arrays.toString(navigator.getPawnPosition()),
                Arrays.toString(board.tileCoords("Gold Gate")));
        Assertions.assertEquals(Arrays.toString(pilot.getPawnPosition()),
                Arrays.toString(board.tileCoords("Fool's Landing")));
        Assertions.assertEquals(Arrays.toString(messenger.getPawnPosition()),
                Arrays.toString(board.tileCoords("Silver Gate")));
        Assertions.assertEquals(Arrays.toString(explorer.getPawnPosition()),
                Arrays.toString(board.tileCoords("Copper Gate")));
    }

    @Test
    public void test_inventory() {
        Player p1 = new Player("p1");

        int firstSize = p1.inventorySize();

        p1.CaptureTreasureCard(new Card("The Earth Stone", CardType.TREASURE));
        p1.CaptureTreasureCard(new Card("The Earth Stone", CardType.TREASURE));

        int secondSize = p1.inventorySize();

        p1.DrawTreasureCard("The Earth Stone");

        int thirdSize = p1.inventorySize();

        Assertions.assertEquals(firstSize, 0);
        Assertions.assertEquals(secondSize, 2);
        Assertions.assertEquals(thirdSize, 1);
    }

}
