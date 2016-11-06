/**
 *
 */
package opgave4;

import java.util.ArrayList;

/**
 * @author Kristian
 */
public class Episode {
    // ===========================================================
    // Fields
    // ===========================================================
    private int number;
    private ArrayList<String> guestActors = new ArrayList<>();
    private int episodeLengthMinutes;

//    private Series series;
    // ===========================================================
    // Constructors
    // ===========================================================
    Episode(int number, int length, ArrayList<String> guests) {
        this.number = number;
        this.episodeLengthMinutes = length;
        this.guestActors = guests;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================
    public int getNumber() {
        return number;
    }

    public int getLength() {
        return episodeLengthMinutes;
    }
//    public ArrayList<String> getCast(){
//        return series.getCast();
//    }
    
    public ArrayList<String> getGuestCast() {
        return guestActors;
    }
    // ===========================================================
    // Methods
    // ===========================================================
}
