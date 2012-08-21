package org.phyous.deck;

/**
 * Class representing a playing deck.
 * User: pyoussef
 * Date: 8/20/12
 * Time: 4:10 PM
 */
public class Card {
    private Suit cardSuit;
    private Number cardNumber;

    /**
     * Constructor for Card class
     *
     * @param suit   suit of the deck to create
     * @param number number of the deck to create
     */
    public Card(Suit suit, Number number) {
        cardSuit = suit;
        cardNumber = number;
    }

    /**
     * Accessor for the suit of a deck.
     *
     * @return the deck's suit
     */
    public Suit getSuit() {
        return cardSuit;
    }

    /**
     * Accessor for the number of a deck.
     *
     * @return the cards number
     */
    public Number getNumber() {
        return cardNumber;
    }

    /**
     * Returns a string representation of the current card.
     * @return string representing the card
     */
    public String toString(){
        return String.format("%s-%s", cardNumber.toString(), cardSuit.toString());
    }

    @Override
    public boolean equals(Object object) {
        if (object == null)
            return false;
        if (object.getClass() != getClass())
            return false;
        Card other = (Card) object;
        if (!cardSuit.equals(other.getSuit()))
            return false;
        if (!cardNumber.equals(other.getNumber()))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return (cardSuit.toString() + cardNumber.toString()).hashCode();
    }
}
