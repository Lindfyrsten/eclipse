package service;

import java.util.ArrayList;

import opgave1.Mekaniker;
import opgave1.Person;
import opgave1.Synsmand;
import opgave1.Værkfører;
import storage.Storage;

public class Service {
    
    public static void createMekaniker(String navn, String addresse, int svendeprøveår,
        double timelønsats) {
        
        Storage.addMekaniker(new Mekaniker(navn, addresse, svendeprøveår, timelønsats));
    }

    public static void createVærkfører(String navn, String addresse, int svendeprøveår,
        double timelønsats, int udnævnelse, double tillæg) {
        Storage.addVærkfører(
            new Værkfører(navn, addresse, svendeprøveår, timelønsats, udnævnelse, tillæg));
    }

    public static void createSynsmand(String navn, String addresse, int svendeprøveår,
        double timelønsats, int antalSyn, double tillæg) {
        Storage.addSynsmand(
            new Synsmand(navn, addresse, svendeprøveår, timelønsats, antalSyn, tillæg));
    }

    public static ArrayList<Mekaniker> getMekanikere() {
        return Storage.getMekanikerList();
    }
    
    public static ArrayList<Værkfører> getVærkfører() {
        return Storage.getVærkførerList();
    }

    public static ArrayList<Person> getPersoner() {
        return Storage.getPersoner();
    }

    /**
     * Beregner summen af ugelønnen for alle mekanikere i listen
     * Krav: list´s elementer er af typen Mekaniker
      **/
    public static double samletLoen(ArrayList<Person> list) {
        double sum = 0;
        for (Person p : list) {
            sum += p.getUgentligLøn();
        }
        return sum;
    }
}
