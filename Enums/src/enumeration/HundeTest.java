package enumeration;

import java.util.ArrayList;

public class HundeTest {

    public static void main(String[] args) {

        ArrayList<Hund> hunde = new ArrayList<>();
        Hund h1 = new Hund("Jack", Race.BOKSER, 5000);
        Hund h2 = new Hund("Percy", Race.TERRIER, 2000);
        Hund h3 = new Hund("Fie", Race.PUDDEL, 7000);
        Hund h4 = new Hund("Albert", Race.BOKSER, 4000);
        Hund h5 = new Hund("Bo", Race.PUDDEL, 6000);
        hunde.add(h1);
        hunde.add(h2);
        hunde.add(h3);
        hunde.add(h4);
        hunde.add(h5);

        System.out.println(samletPris(hunde, Race.BOKSER));
        
    }

    public static int samletPris(ArrayList<Hund> hunde, Race race) {
        int samletPris = 0;
        for (Hund h : hunde) {
            if (h.getRace() == race) {

                samletPris += h.getPris();
            }
        }
        return samletPris;
    }

}
