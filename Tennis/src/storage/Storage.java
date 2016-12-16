package storage;

import java.util.ArrayList;

import application.model.Bane;
import application.model.Medlem;

/**
 * @author Kristian
 */
public class Storage {
    private static ArrayList<Medlem> medlemmer = new ArrayList<>();
    private static ArrayList<Bane> baner = new ArrayList<>();

    public static void addBane(Bane bane) {
        if (!baner.contains(bane)) {
            baner.add(bane);
        }
    }

    public static void addMedlem(Medlem medlem) {
        if (!medlemmer.contains(medlem)) {
            medlemmer.add(medlem);
        }
    }

    public static ArrayList<Bane> getBaner() {
        return new ArrayList<>(baner);
    }

    public static ArrayList<Medlem> getMedlemmer() {
        return new ArrayList<>(medlemmer);
    }
    
}
