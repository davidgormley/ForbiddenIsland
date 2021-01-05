import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import cards.*;
import deck.*;
import player.*;
import gameboard.*;

public class AdventurersTest {

    @Test
    public void test_adventurers_treasure_captures() {
        Adventurers adventurers = Adventurers.getInstance();
        Assertions.assertEquals(adventurers.haveTreasure(TreasureType.EARTH_STONE), false);

        adventurers.addTreasure(TreasureType.EARTH_STONE);
        Assertions.assertEquals(adventurers.haveTreasure(TreasureType.EARTH_STONE), true);
    }

    @Test
    public void test_if_players_added() {
        Adventurers adventurers = Adventurers.getInstance();

        Player p1 = new Player("p1");
        Player p2 = new Player("p2");
        Player p3 = new Player("p3");

        adventurers.addPlayer(1, p1);
        adventurers.addPlayer(2, p2);
        adventurers.addPlayer(3, p3);

        Assertions.assertEquals(adventurers.numPlayers(), 3);
        Assertions.assertNotEquals(adventurers.numPlayers(), 4);
    }
}
