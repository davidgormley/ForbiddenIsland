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
}
