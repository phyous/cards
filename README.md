Cards - A card deck simulator
=====

The following code can be used to represent a threadsafe deck in java.

To run tests:
> mvn test
(maven required: http://maven.apache.org/download.html)

Ex:
```java
import org.phyous.deck;

System.out.println("Taking a new deck out of shrink wrap!")
Deck deck = new Deck();
System.out.println("Shuffling deck ...")
deck.shuffle();

ArrayList<Card> hand = new ArrayList<Card>();
System.out.println("Drawing a hand ...")
for(int i = 0; i < 5; i++){
    System.out.println(deck.draw.toString());
}
System.out.println("Any good? :)");

```

Output:
```plain
Taking a new deck out of shrink wrap!
Shuffling deck ...
Drawing a hand ...
ACE-SPADES
NINE-DIAMONDS
FOUR-CLUBS
FIVE-DIAMONDS
FIVE-CLUBS
Any good? :)
```
=======
cards
=====

A card deck simulator
