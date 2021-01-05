import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import cards.*;
import deck.*;
import player.*;
import gameboard.*;

public class DeckTest {

    @Test
    public void test_if_cards_are_shuffled() {
        Deck<Card> treasureCards = new Deck<Card>();

        treasureCards.fillTreasureDeck();
        treasureCards.shuffleDeck();

        Card cardOnTop = treasureCards.pop();

        treasureCards.emptyDeck();
        treasureCards.fillTreasureDeck();
        treasureCards.shuffleDeck();

        Card newCardOnTop = treasureCards.pop();

        Assertions.assertNotEquals(cardOnTop.cardName(), newCardOnTop.cardName());
    }

    @Test
    public void check_deck_emptiness() {
        Deck<Card> treasureCards = new Deck<Card>();

        treasureCards.fillTreasureDeck();

        Assertions.assertEquals(treasureCards.isEmpty(), false);

        treasureCards.emptyDeck();

        Assertions.assertEquals(treasureCards.isEmpty(), true);
    }
}
