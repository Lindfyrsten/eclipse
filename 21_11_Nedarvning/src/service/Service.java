package service;

import java.util.ArrayList;

import opgave3.Ansat;
import opgave3.Arbejdsdreng;
import opgave3.Mekaniker;
import opgave3.Synsmand;
import opgave3.Værkfører;
import storage.Storage;

public class Service {

    public static void createMekaniker(String navn, String addresse, double timeløn,
        int svendeprøveår) {

        Storage.addMekaniker(new Mekaniker(navn, addresse, timeløn, svendeprøveår));
    }
    
    public static void createVærkfører(String navn, String addresse, double timeløn, int udnævnelse,
        double tillæg) {
        Storage.addVærkfører(
            new Værkfører(navn, addresse, timeløn, udnævnelse, tillæg));
    }
    
    public static void createSynsmand(String navn, String addresse, double timeløn,
        int svendeprøveår) {
        Storage.addSynsmand(
            new Synsmand(navn, addresse, timeløn, svendeprøveår));
    }

    public static void createArbejdsdreng(String navn, String addresse, double timeløn) {
        Storage.addArbejdsdreng(new Arbejdsdreng(navn, addresse, timeløn));
    }
    
    public static ArrayList<Mekaniker> getMekanikere() {
        return Storage.getMekanikerList();
    }

    public static ArrayList<Værkfører> getVærkfører() {
        return Storage.getVærkførerList();
    }

    public static ArrayList<Synsmand> getSynsmænd() {
        return Storage.getSynsmænd();
    }

    public static ArrayList<Ansat> getAnsatte() {
        return Storage.getAnsatte();
    }
    
    /**
     * Beregner summen af ugelønnen for alle mekanikere i listen
     * Krav: list´s elementer er af typen Mekaniker
      **/
    public static double samletLoen(ArrayList<Ansat> list) {
        double sum = 0;
        for (Ansat a : list) {
            sum += a.beregnLoen();
        }

        return sum;
    }
}
