package enums;

import java.util.ArrayList;
import java.util.Collections;

public class Hand {
    private ArrayList<Card> cards = new ArrayList<>();

    public boolean add(Card c) {
        if (cards.contains(c)) {
            return false;
        }
        else {
            cards.add(c);
            return true;
        }
    }

    public boolean remove(Card c) {
        if (!cards.contains(c)) {
            return false;
        }
        else {
            cards.remove(c);
            return true;
        }
    }

    @Override
    public String toString() {
        Collections.sort(cards);
        return cards.toString();
    }

}
