package enums;

public class Card implements Comparable<Card> {
    
    public enum Suit {
        DIAMOND, CLUB, HEART, SPADE
    }

    public enum Rank {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }

    private Rank rank;
    private Suit suit;
    
    public Card(Suit s, Rank r) {
        this.suit = s;
        this.rank = r;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card o) {
        if (getRank().compareTo(o.getRank()) == 0) {
            return getSuit().compareTo(o.getSuit());
            
        }
        else {
            
            return getRank().compareTo(o.getRank());
        }
    }

    @Override
    public String toString() {
        return rank + " of " + suit + "'S";
    }
    
}
