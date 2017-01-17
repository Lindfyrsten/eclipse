package application.service;

import java.util.ArrayList;

import application.model.Medlem;
import storage.Storage;

public class Service {
    
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    
    public static Medlem createMedlem(String navn, String adresse, int tlfNr, int medlemsNr,
        String mail,
        boolean ryger) {
        Medlem medlem = new Medlem(navn, adresse, tlfNr, medlemsNr, mail, ryger);
        Storage.addMedlem(medlem);
        return medlem;
    }
    
    public static void deleteMedlem(Medlem medlem) {
        Storage.removeMedlem(medlem);
    }

    public static ArrayList<Medlem> getMedlemmer() {
        return Storage.getMedlemmer();
    }
    
    // -------------------------------------------------------------------------
    /**
     * Initializes the storage with some objects.
     */
    public static void initStorage() {
        
    }
    
    public static void init() {
        
        initStorage();
        
    }
    
}
