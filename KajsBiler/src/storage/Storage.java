package storage;

import java.util.ArrayList;

import application.model.Bil;
import application.model.Kunde;
import application.model.Udlejning;

public class Storage {
    
    private static ArrayList<Bil> biler = new ArrayList<>();
    private static ArrayList<Kunde> kunder = new ArrayList<>();
    private static ArrayList<Udlejning> udlejninger = new ArrayList<>();

    public static ArrayList<Bil> getBiler() {
        return new ArrayList<>(biler);
    }

    public static ArrayList<Kunde> getKunder() {
        return new ArrayList<>(kunder);
    }

    public static ArrayList<Udlejning> getUdlejninger() {
        return new ArrayList<>(udlejninger);
    }
    
    public static void addBil(Bil bil) {
        biler.add(bil);
    }

    public static void addKunde(Kunde kunde) {
        kunder.add(kunde);
    }

    public static void addUdlejning(Udlejning udlejning) {
        udlejninger.add(udlejning);
    }
    
    public static void removeBil(Bil bil) {
        biler.remove(bil);
    }

    public static void removeKunde(Kunde kunde) {
        kunder.remove(kunde);
    }

}
