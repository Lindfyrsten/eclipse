package enumeration;

import enumeration.Card.Rank;
import enumeration.Card.Suit;

public class CardApp {

    public static void main(String[] args) {
        Hand h1 = new Hand();
        h1.add(new Card(Suit.HEART, Rank.JACK));
        h1.add(new Card(Suit.SPADE, Rank.FOUR));
        h1.add(new Card(Suit.DIAMOND, Rank.ACE));
        h1.add(new Card(Suit.HEART, Rank.FIVE));
        h1.add(new Card(Suit.SPADE, Rank.KING));

        System.out.println(h1.toString());
    }

}
