package org.phyous.deck;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * A threadsafe Deck class.
 * User: pyoussef
 * Date: 8/20/12
 * Time: 4:10 PM
 */
public class Deck {
    private ArrayList<Card> cards;

    // Use ReentrantReadWriteLock to assure thread safety
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock read = readWriteLock.readLock();
    private final Lock write = readWriteLock.writeLock();

    /**
     * Constructor for Deck class
     */
    public Deck() {
        cards = new ArrayList<Card>();
        for (Number n : Number.values()) {
            for (Suit s : Suit.values()) {
                cards.add(new Card(s, n));
            }
        }
    }

    /**
     * Draw a deck from the top of the deck
     *
     * @return deck from the top of the deck
     */
    public Card drawCard() {
        write.lock();
        try {
            if (cards.size() == 0)
                return null;
            return cards.remove(cards.size() - 1);
        } finally {
            write.unlock();
        }
    }

    /**
     * Shuffle the deck of cards.
     */
    public void shuffle(){
        write.lock();
        try {
        Card tmp;
        int index;
        for(int i = 0; i < cards.size(); i++){
            index = (int) (Math.random() * (cards.size() - i)) +i;
            tmp = cards.get(i);
            cards.set(i, cards.get(index));
            cards.set(index, tmp);
        }
        } finally {
            write.unlock();
        }
    }

    /**
     * Get deck at a given index, but do not remove it. If there is no deck at that index, return null.
     * Required to allow array type access through AbstractList class.
     *
     * @param index position to
     * @return deck at given index
     */
    public Card peek(int index) {
        read.lock();
        try {
            if (index > cards.size())
                return null;
            return cards.get(index - 1);
        } finally {
            read.unlock();
        }
    }

    /**
     * Get the size of the given deck.
     *
     * @return the number of cards in the deck
     */
    public int size() {
        read.lock();
        try {
            return cards.size();
        } finally {
            read.unlock();
        }
    }
}
