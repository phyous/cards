import org.junit.Before;
import org.junit.Test;
import org.phyous.deck.Card;
import org.phyous.deck.Deck;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.Assert.assertTrue;

/**
* Created with IntelliJ IDEA.
* User: pyoussef
* Date: 8/20/12
* Time: 6:27 PM
*/
public class DeckTest {
    private Deck d1;

    @Before
    public void setUp(){
        d1 = new Deck();
    }

    @Test
    public void testDrawCard() throws Exception {
        int count = 52;
        Card c = null;
        for(int i = 52; i > 0; i--){
            c = d1.drawCard();
            assertTrue(d1.getClass() == Deck.class);
        }
        // try to draw a deck from an empty deck;
        c = d1.drawCard();
        assertTrue(c == null);

    }

    @Test
    public void testGetPeek() throws Exception {
        assertTrue(d1.peek(52).equals(d1.drawCard()));
    }

    @Test
    public void testSize() throws Exception {
        assertTrue(d1.size() == 52);
        for(int i = 10; i > 0; i--){
            d1.drawCard();
        }
        assertTrue(d1.size() == 42);
        for(int i = 42; i > 0; i--){
            d1.drawCard();
        }
        assertTrue(d1.size() == 0);
    }

    /**
     * Shuffle the deck and make sure there are 52 unique cards after the shuffle
     * @throws Exception
     */
    @Test
    public void testShuffle() throws Exception{
        d1.shuffle();
        assertTrue(d1.size() == 52);
        HashSet<Card> cards = new HashSet<Card>();
        for(int i = 1; i <= 52; i++){
            cards.add(d1.peek(i));
        }
        assertTrue(cards.size() == 52);
    }

    /**
     * Test that the example in the README.md works correctly
     * @throws Exception
     */
    @Test
    public void testExampleText() throws Exception{
        // Taking a new deck out of shrink wrap!
        Deck deck = new Deck();
        // Shuffling deck ...
        deck.shuffle();

        ArrayList<Card> hand = new ArrayList<Card>();
        // Drawing a hand ...
        for(int i = 0; i < 5; i++){
            deck.drawCard().toString();
        }
    }
}
