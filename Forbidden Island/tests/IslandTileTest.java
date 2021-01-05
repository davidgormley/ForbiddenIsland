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

    @Test
    public void test_shoring_up() {
        IslandTile firstTile = new IslandTile("The Earth Stone", CardType.TREASURE, TreasureType.NONE);
        IslandTile secondTile = new IslandTile("The Earth Stone", CardType.TREASURE, TreasureType.EARTH_STONE);

        firstTile.flood();
        firstTile.shoreUp();

        secondTile.flood();
        secondTile.flood();
        secondTile.shoreUp();

        Assertions.assertEquals(firstTile.state(), Flooded.DRY);
        Assertions.assertEquals(secondTile.state(), Flooded.SUNK);
    }

    @Test
    public void test_lootable() {
        IslandTile firstTile = new IslandTile("The Earth Stone", CardType.TREASURE, TreasureType.NONE);
        IslandTile secondTile = new IslandTile("The Earth Stone", CardType.TREASURE, TreasureType.EARTH_STONE);

        Assertions.assertEquals(firstTile.isLootable(), false);
        Assertions.assertEquals(secondTile.isLootable(), true);
    }

    @Test
    public void test_to_string() {
        IslandTile firstTile = new IslandTile("Fool's Landing", CardType.TREASURE, TreasureType.NONE);
        IslandTile secondTile = new IslandTile("Phantom Rock", CardType.TREASURE, TreasureType.EARTH_STONE);

        Assertions.assertEquals(firstTile.toString(), "Fool's Landing (DRY)");
        Assertions.assertEquals(secondTile.toString(), "Phantom Rock (DRY)");

        firstTile.flood();
        firstTile.flood();

        Assertions.assertEquals(firstTile.toString(), "Fool's Landing (SUNK)");
    }
}
