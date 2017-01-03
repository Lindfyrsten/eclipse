package storage;

import java.util.ArrayList;

import model.Kollegie;
import model.Lejer;

/**
 * @author Kristian Lindbjerg
 */
public class Storage {
    private static ArrayList<Kollegie> kollegier = new ArrayList<>();
    private static ArrayList<Lejer> lejere = new ArrayList<>();

    public static void addLejer(Lejer lejer) {
        lejere.add(lejer);
    }

    public static void addKollegie(Kollegie kollegie) {
        kollegier.add(kollegie);
    }

    public static ArrayList<Kollegie> getKollegier() {
        return new ArrayList<>(kollegier);
    }

    public static ArrayList<Lejer> getLejere() {
        return new ArrayList<>(lejere);
    }
}
