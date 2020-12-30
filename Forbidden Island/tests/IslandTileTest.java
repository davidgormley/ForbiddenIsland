import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import cards.*;

public class IslandTileTest {

    @Test
    public void test_flooding() {
        IslandTile firstTile = new IslandTile("The Earth Stone", CardType.TREASURE, TreasureType.NONE);
        IslandTile secondTile = new IslandTile("The Earth Stone", CardType.TREASURE, TreasureType.NONE);

        firstTile.flood();
        secondTile.flood();
        secondTile.flood();

        Assertions.assertEquals(firstTile.state(), Flooded.FLOODED);
        Assertions.assertEquals(secondTile.state(), Flooded.SUNK);
    }

}
