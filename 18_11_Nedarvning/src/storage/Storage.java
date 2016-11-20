package storage;

import java.util.ArrayList;

import opgave1.Mekaniker;
import opgave1.Synsmand;
import opgave1.Værkfører;

public class Storage {
    private static ArrayList<Mekaniker> mekanikerList = new ArrayList<>();
    private static ArrayList<Værkfører> værkførerList = new ArrayList<>();
    private static ArrayList<Synsmand> synsmænd = new ArrayList<>();

    public static void addMekaniker(Mekaniker mekaniker) {
        mekanikerList.add(mekaniker);
    }
    
    public static void addVærkfører(Værkfører værkfører) {
        værkførerList.add(værkfører);
        mekanikerList.add(værkfører);
    }
    
    public static void addSynsmand(Synsmand synsmand) {
        synsmænd.add(synsmand);
        mekanikerList.add(synsmand);

    }

    public static ArrayList<Mekaniker> getMekanikerList() {
        return new ArrayList<>(mekanikerList);
    }

    public static ArrayList<Værkfører> getVærkførerList() {
        return new ArrayList<>(værkførerList);
    }

    public static ArrayList<Synsmand> getSynsmænd() {
        return new ArrayList<>(synsmænd);
    }
    
}