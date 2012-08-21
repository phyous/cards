import org.junit.*;
import org.phyous.deck.*;
import org.phyous.deck.Number;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
* User: pyoussef
* Date: 8/20/12
* Time: 4:28 PM
* To change this template use File | Settings | File Templates.
*/
public class CardTest {
    private Card c1;

    @Before
    public void setUp() throws Exception {
        c1 = new Card(Suit.CLUBS, Number.KING);
        assertTrue(c1 != null);
    }

    @Test
    public void testGetSuit() throws Exception {
        assertEquals(c1.getSuit(), Suit.CLUBS);
        c1.hashCode();
    }

    @Test
    public void testGetNumber() throws Exception {
        assertEquals(c1.getNumber(), Number.KING);
    }

    @Test
    public void testEquals() throws Exception {
        Card c2 = new Card(Suit.CLUBS, Number.KING);
        Card c3 = new Card(Suit.CLUBS, Number.QUEEN);
        String foo = "B4DB33F";
        Integer bar = null;
        assertTrue(c2.equals(c1));
        assertFalse(c3.equals(c1));
        assertFalse(c3.equals(foo));
        assertFalse(c3.equals(bar));
    }

    @Test
    public void testHashCode() throws Exception {
        Card c2 = new Card(Suit.CLUBS, Number.KING);
        Card c3 = new Card(Suit.CLUBS, Number.QUEEN);
        assertTrue(c1.hashCode() == c2.hashCode());
        assertTrue(c1.hashCode() != c3.hashCode());
    }

    @Test
    public void testToString() throws Exception {
        assertTrue(c1.toString().equals("KING-CLUBS"));
    }
}
