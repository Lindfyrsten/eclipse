package storage;

import java.util.ArrayList;

import application.model.Bil;
import application.model.Parkeringshus;

public class Storage {
    
    private static ArrayList<Bil> biler = new ArrayList<>();
    private static ArrayList<Parkeringshus> parkeringshuse = new ArrayList<>();
    
    public static ArrayList<Bil> getBiler() {
        return new ArrayList<>(biler);
    }

    public static void addBil(Bil bil) {
        biler.add(bil);
    }
    
    public static void removeBil(Bil bil) {
        biler.remove(bil);
    }

    public static ArrayList<Parkeringshus> getParkeringshuse() {
        return new ArrayList<>(parkeringshuse);
    }

    public static void addParkeringshus(Parkeringshus p) {
        parkeringshuse.add(p);
    }

    public static void removeParkeringshus(Parkeringshus p) {
        parkeringshuse.remove(p);
    }

}
