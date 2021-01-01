import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import cards.*;
import player.*;
import gameboard.*;
import play.*;

public class CaptureTest {

    @Test
    public void test_capture_when_conditions_are_invalid() {
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");
        Player p3 = new Player("p3");
        Player p4 = new Player("p4");

        p1.setRole("Engineer");
        p2.setRole("Messenger");
        p3.setRole("Navigator");
        p4.setRole("Pilot");

        p1.setStartingPos();
        p2.setStartingPos();
        p3.setStartingPos();
        p4.setStartingPos();

        Adventurers adv = Adventurers.getInstance();
        adv.addPlayer(1, p1);
        adv.addPlayer(2, p2);
        adv.addPlayer(3, p3);
        adv.addPlayer(4, p4);

        Capture capture = new Capture(1, new Scanner(System.in));

        Assertions.assertEquals(capture.isValid(), false);
    }

    @Test
    public void test_capture_when_conditions_are_valid() {
        Board board = Board.getInstance();

        Player p1 = new Player("p1");
        Player p2 = new Player("p2");
        Player p3 = new Player("p3");
        Player p4 = new Player("p4");

        p1.setRole("Engineer");
        p2.setRole("Messenger");
        p3.setRole("Navigator");
        p4.setRole("Pilot");

        p1.setStartingPos();
        p2.setStartingPos();
        p3.setStartingPos();
        p4.setStartingPos();

        p1.CaptureTreasureCard(new Card("The Earth Stone", CardType.TREASURE));
        p1.CaptureTreasureCard(new Card("The Earth Stone", CardType.TREASURE));
        p1.CaptureTreasureCard(new Card("The Earth Stone", CardType.TREASURE));
        p1.CaptureTreasureCard(new Card("The Earth Stone", CardType.TREASURE));

        int tileCoords[] = board.tileCoords("Temple of the Moon");
        p1.setPos(tileCoords[0], tileCoords[1]);

        Adventurers adv = Adventurers.getInstance();
        adv.addPlayer(1, p1);
        adv.addPlayer(2, p2);
        adv.addPlayer(3, p3);
        adv.addPlayer(4, p4);

        Capture capture = new Capture(1, new Scanner(System.in));

        Assertions.assertEquals(capture.isValid(), true);
    }

}
