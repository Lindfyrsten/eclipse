/**
 *
 */
package opgave4;

import java.util.ArrayList;

/**
 * @author Kristian
 */
public class Series {
    // ===========================================================
    // Fields
    // ===========================================================
    private String title;
    private ArrayList<String> cast = new ArrayList<>();
    private ArrayList<Episode> episodes = new ArrayList<>();
    
    // ===========================================================
    // Constructors
    // ===========================================================
    Series(String title, ArrayList<String> cast) {
        this.title = title;
        this.cast = cast;
    }
    
    // ===========================================================
    // Getter & Setter
    // ===========================================================
    public String getTitle() {
        return title;
    }
    
    public ArrayList<String> getCast() {
        return cast;
    }

    public ArrayList<Episode> getEpisodes() {
        return episodes;
    }

    // ===========================================================
    // Methods
    // ===========================================================
    public void addEpisode(Episode episode) {
        
        episodes.add(episode);
        
    }

    /**
     * Return the total length (in minutes) of all the   * episodes in the series.
     */
    public int totalLength() {

        int sum = 0;
        for (Episode e : episodes) {
            sum += e.getLength();
        }
        return sum;
    }

    /**
     *   Return the total list of all guest actors from all episodes.
     */
    public ArrayList<String> getGuestActors() {
        ArrayList<String> allActors = new ArrayList<>();

        for (String s : cast) {
            allActors.add(s);

        }
        for (Episode e : episodes) {
            for (String guest : e.getGuestCast()) {
                if (!allActors.contains(guest)) {
                    allActors.add(guest);
                }

            }
        }
        return allActors;
    }
}
