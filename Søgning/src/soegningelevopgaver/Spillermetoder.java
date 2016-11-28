package soegningelevopgaver;

import java.util.ArrayList;

public class Spillermetoder {
    public Spiller findScoreLinear(ArrayList<Spiller> spillere, int score) {
        // TODO Opgave 4.1
        return null;
    }
    
    // Her tilføjes metoder der der løser opgve 4.2 og 4.3
    
    public static void main(String[] args) {
        Spillermetoder metoder = new Spillermetoder();
        
        // Her afprøves opgave 4.1
        ArrayList<Spiller> spillerListe = new ArrayList<>();
        spillerListe.add(new Spiller("Hans", 196, 99, 45));
        spillerListe.add(new Spiller("Bo", 203, 89, 60));
        spillerListe.add(new Spiller("Jens", 188, 109, 32));
        spillerListe.add(new Spiller("Finn", 194, 102, 12));
        spillerListe.add(new Spiller("Lars", 192, 86, 35));
        spillerListe.add(new Spiller("Mads", 200, 103, 37));
        
        System.out
            .println("Spiller der har scoret 35 mål: " + metoder.findScoreLinear(spillerListe, 35));
        System.out
            .println("Spiller der har scoret 30 mål: " + metoder.findScoreLinear(spillerListe, 30));
        
        // Tilføj metoder der afprøver opgaver 4.2 og 4.3
    }
    
}
