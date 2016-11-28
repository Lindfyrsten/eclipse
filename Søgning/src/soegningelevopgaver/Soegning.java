package soegningelevopgaver;

import java.util.ArrayList;

public class Soegning {

    public boolean findUlige(int[] tabel) {

        boolean found = false;
        int i = 0;
        while (!found && i < tabel.length) {
            if (tabel[i] % 2 == 1) {

                found = true;
                return found;
            }
            else {
                i++;
            }
        }
        return found;

    }

    // her skriver du metoder tilopgaverne 2,3,5,6 og 7

    //opgave 2 - finder første heltal i intervallet [10,15]

    public int findHeltalInterval(int[] tabel) {

        boolean found = false;
        int i = 0;
        while (!found && i < tabel.length) {
            if (tabel[i] % 2 == 0 && tabel[i] < 15 && tabel[i] > 9) {

                found = true;
                return tabel[i];
            }
            else {
                i++;
            }
        }
        return -1;

    }

    //opgave 3 - nabotal ens?

    public boolean findNeighbourDuplicate(int[] tabel) {

        boolean found = false;
        int i = 0;
        int oldValue = -1;
        while (!found && i < tabel.length) {
            if (tabel[i] == oldValue) {

                found = true;
                return found;
            }
            else {
                oldValue = tabel[i];
                i++;
            }
        }
        return found;

    }

    //opgave 4.1 - find spiller med score ved lineær
    public Spiller findScoreLineær(ArrayList<Spiller> spillere, int score) {
        boolean found = false;
        int i = 0;
        while (!found && i < spillere.size()) {
            if (spillere.get(i).getMaal() == score) {

                return spillere.get(i);
            }
            else {
                i++;
            }
        }
        return null;

    }

    //opgave 4.2 - find spiller med score ved bineær

    public Spiller findScoreBineær(ArrayList<Spiller> spillere, int score) {
        boolean found = false;
        int left = 0;
        int right = spillere.size() - 1;
        int middle = -1;
        Spiller spiller = null;
        while (!found && left <= right) {
            middle = (left + right) / 2;
            spiller = spillere.get(middle);
            int comp = spiller.getMaal() - score;
            if (comp == 0) {
                found = true;
            }
            else if (comp > 0) {
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        if (found) {
            return spiller;
        }
        else {
            return null;
        }
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

    //opgave 5 - find kvadratroden

    public int findSquareRoot(int tal) {

        boolean found = false;
        int result = 0;
        int i = 0;
        while (!found) {
            if (i * i == tal) {
                found = true;
                result = i;
            }
            
        }

        return result;

    }
}
