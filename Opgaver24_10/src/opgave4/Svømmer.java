/**
 *
 */
package opgave4;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Kristian
 */
public class Svømmer {
    // ===========================================================
    // Fields
    // ===========================================================
    private String navn;
    private String klub;
    private LocalDate fødselsdag;
    private ArrayList<Double> tider;

    // ===========================================================
    // Constructor
    // ===========================================================

    /**
    * Initialiserer en ny svømmer med navn, fødselsdag, klub
    * og tider.
    */
    public Svømmer(String navn, LocalDate fødselsdag, String klub, ArrayList<Double> tider) {
        
        this.navn = navn;
        this.fødselsdag = fødselsdag;
        this.klub = klub;
        this.tider = tider;
        
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================

    /**
     * Returnerer svømmerens navn.
     */
    public String getNavn() {
        return navn;
    }
    
    /**
    * Returnerer svømmerens klub.
    */
    public String getKlub() {
        return klub;
    }

    /**
    * Registrerer svømmerens klub
    * @param klub
    */
    public void setKlub(String klub) {
        this.klub = klub;
    }

    /**
    * Returnerer svømmerens årgang.
    */
    public int getÅrgang() {
        return fødselsdag.getYear();
    }
    
    // ===========================================================
    // Methods
    // ===========================================================
    
    /**
    * Returnerer den hurtigste tid svømmeren har opnået
    */
    public double bedsteTid() {
        double bestTime = tider.get(0);
        for (int i = 1; i < tider.size(); i++) {
            if (tider.get(i) < bestTime) {
                bestTime = tider.get(i);
            }
            
        }
        return bestTime;
    }
    
    /**
    * Returnerer gennemsnittet af de tider svømmeren har
     * opnået
    */
    public double gennemsnitAfTid() {
        double avgTime = 0;
        for (int i = 0; i < tider.size(); i++) {
            avgTime += tider.get(i);
        }
        
        return avgTime / tider.size();
    }
    
    /**
    * Returnerer gennemsnittet af de tider svømmeren har
     * opnået idet den langsomste tid ikke er medregnet
    */
    public double snitUdenDårligste() {
        double avgTime = 0;
        double worstTime = tider.get(0);
        for (int i = 0; i < tider.size(); i++) {
            if (tider.get(i) > worstTime) {
                worstTime = tider.get(i);
            }
            avgTime += tider.get(i);
        }
        
        return (avgTime - worstTime) / (tider.size() - 1);
    }
}
