import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import cards.*;
import deck.*;
import player.*;
import gameboard.*;

public class InventoryTest {

    @Test
    public void test_inventory_max_limit() {
        Inventory inventory = new Inventory();

        inventory.addCard(new Card("The Earth Stone", CardType.TREASURE));
        inventory.addCard(new Card("The Earth Stone", CardType.TREASURE));
        inventory.addCard(new Card("The Earth Stone", CardType.TREASURE));
        inventory.addCard(new Card("The Earth Stone", CardType.TREASURE));
        inventory.addCard(new Card("The Earth Stone", CardType.TREASURE));

        Assertions.assertEquals(inventory.isFull(), true);
        Assertions.assertEquals(inventory.size(), 5);

        inventory.addCard(new Card("The Earth Stone", CardType.TREASURE));
        inventory.addCard(new Card("The Earth Stone", CardType.TREASURE));

        Assertions.assertEquals(inventory.size(), 5);
    }

    @Test
    public void test_inventory_contains_card() {
        Inventory inventory = new Inventory();

        inventory.addCard(new Card("The Earth Stone", CardType.TREASURE));
        inventory.addCard(new Card("The Earth Stone", CardType.TREASURE));
        inventory.addCard(new Card("The Earth Stone", CardType.TREASURE));
        inventory.addCard(new Card("The Earth Stone", CardType.TREASURE));
        inventory.addCard(new Card("The Earth Stone", CardType.TREASURE));

        Assertions.assertEquals(inventory.hasCard("The Earth Stone"), true);
        Assertions.assertEquals(inventory.hasCard("Random Card Name"), false);
    }
}
