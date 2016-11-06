package opgave4;

import java.util.ArrayList;

public class SeriesApp {

    public static void main(String[] args) {
        ArrayList<String> cast = new ArrayList<>();
        ArrayList<String> guestEp1 = new ArrayList<>();
        ArrayList<String> guestEp2 = new ArrayList<>();
        String[] castStr = { "Justin Beaver", "Michael Jackson", "Donald Trump" };
        String[] guestStrEp1 = { "Kristian Lindbjerg" };
        String[] guestStrEp2 = { "Hillary Clinton" };
        
        for (String s : castStr) {
            cast.add(s);
        }
        
        for (String s : guestStrEp1) {
            guestEp1.add(s);
        }
        for (String s : guestStrEp2) {
            guestEp2.add(s);
        }
        Series zombz = new Series("Another stupid zombie show", cast);
        Episode ep1 = new Episode(1, 45, guestEp1);
        Episode ep2 = new Episode(2, 55, guestEp2);
        zombz.addEpisode(ep1);
        zombz.addEpisode(ep2);

        System.out.println("Actors: " + zombz.getGuestActors());
        System.out.println("Total length: " + zombz.totalLength() + " minutes");

    }
}
