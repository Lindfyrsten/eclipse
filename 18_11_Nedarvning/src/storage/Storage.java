package storage;

import java.util.ArrayList;

import opgave1.Mekaniker;
import opgave1.Person;
import opgave1.Synsmand;
import opgave1.Værkfører;

public class Storage {
    private static ArrayList<Mekaniker> mekanikerList = new ArrayList<>();
    private static ArrayList<Værkfører> værkførerList = new ArrayList<>();
    private static ArrayList<Person> personer = new ArrayList<>();
    private static ArrayList<Synsmand> synesmænd = new ArrayList<>();

    public static void addMekaniker(Mekaniker mekaniker) {
        mekanikerList.add(mekaniker);
        personer.add(mekaniker);
    }
    
    public static void addVærkfører(Værkfører værkfører) {
        værkførerList.add(værkfører);
        personer.add(værkfører);
    }

    public static ArrayList<Mekaniker> getMekanikerList() {
        return new ArrayList<>(mekanikerList);
    }

    public static ArrayList<Værkfører> getVærkførerList() {
        return new ArrayList<>(værkførerList);
    }

    public static ArrayList<Person> getPersoner() {
        return new ArrayList<>(personer);
    }

    public static void addSynsmand(Synsmand synsmand) {
        synesmænd.add(synsmand);
        personer.add(synsmand);
    }
    
}