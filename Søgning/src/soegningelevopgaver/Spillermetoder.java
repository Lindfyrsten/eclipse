package soegningelevopgaver;

import java.util.ArrayList;

public class Spillermetoder {
    public Spiller findScoreLinear(ArrayList<Spiller> spillere, int score) {
        boolean found = false;
        int i = 0;
        while (!found && i < spillere.size()) {
            if (spillere.get(i).getMaal() == score) {
                return spillere.get(i);
            }
            i++;
        }
        return null;
    }

    // 4.2 binær søgning

    public Spiller findScoreBineær(ArrayList<Spiller> spillere, int score) {
        boolean found = false;
        int left = 0;
        int right = spillere.size() - 1;
        int middle = -1;
        Spiller spiller = null;
        while (!found && left <= right) {
            middle = (left + right) / 2;
            spiller = spillere.get(middle);
            int comp = score - spiller.getMaal();
            if (comp == 0) {
                found = true;
                return spiller;
            }
            else if (comp > 0) {
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        
        return null;
    }

    //opgave 4.3 - find spiller der er mindre end 170cm og har score over 50 mål
    public String findSpillerHøjdeScore(ArrayList<Spiller> spillere) {
        boolean found = false;
        int i = 0;
        while (!found && i < spillere.size()) {
            if (spillere.get(i).getHoejde() >= 170 && spillere.get(i).getMaal() >= 50) {

                return spillere.get(i).getNavn();
            }
            else {
                i++;
            }
        }
        return "";

    }

    public static void main(String[] args) {
        Spillermetoder metoder = new Spillermetoder();

        // Her afprøves opgave 4.1
        ArrayList<Spiller> spillere = new ArrayList<>();
        spillere.add(new Spiller("Kristian", 188, 80, 35));
        spillere.add(new Spiller("Christiano", 186, 84, 22));
        spillere.add(new Spiller("Lionel", 148, 48, 2));
        spillere.add(new Spiller("Batistuta", 194, 87, 25));

        System.out
            .println("Spiller der har scoret 35 mål: " + metoder.findScoreLinear(spillere, 25));
        System.out
            .println("Spiller der har scoret 30 mål: " + metoder.findScoreLinear(spillere, 35));

        // Tilføj metoder der afprøver opgaver 4.2 og 4.3
    }

}
