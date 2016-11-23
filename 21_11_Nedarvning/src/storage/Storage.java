package storage;

import java.util.ArrayList;

import opgave3.Ansat;
import opgave3.Arbejdsdreng;
import opgave3.Mekaniker;
import opgave3.Synsmand;
import opgave3.Værkfører;

public class Storage {
    private static ArrayList<Mekaniker> mekanikerList = new ArrayList<>();
    private static ArrayList<Værkfører> værkførerList = new ArrayList<>();
    private static ArrayList<Synsmand> synsmænd = new ArrayList<>();
    private static ArrayList<Ansat> ansatte = new ArrayList<>();
    private static ArrayList<Arbejdsdreng> arbejdsdrenge = new ArrayList<>();

    public static void addMekaniker(Mekaniker mekaniker) {
        mekanikerList.add(mekaniker);
        ansatte.add(mekaniker);
    }
    
    public static void addVærkfører(Værkfører værkfører) {
        værkførerList.add(værkfører);
        ansatte.add(værkfører);
    }
    
    public static void addSynsmand(Synsmand synsmand) {
        synsmænd.add(synsmand);
        mekanikerList.add(synsmand);
        ansatte.add(synsmand);

    }
    
    public static void addArbejdsdreng(Arbejdsdreng arbejdsdreng) {
        arbejdsdrenge.add(arbejdsdreng);
        ansatte.add(arbejdsdreng);
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

    public static ArrayList<Ansat> getAnsatte() {
        return new ArrayList<>(ansatte);
    }
    
}