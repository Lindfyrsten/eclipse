package application.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import application.model.Medlem;
import application.model.Område;
import application.model.Reservation;
import storage.Storage;

public class Service {

    // -------------------------------------------------------------------------
    public static Område createOmråde(String navn, int antalPladser, double prisMedlem,
        double pris) {
        Område område = new Område(navn, antalPladser, prisMedlem, pris);
        Storage.addOmråde(område);
        return område;
    }

    public static void deleteOmråde(Område område) {
        Storage.removeOmråde(område);
    }
    
    public static ArrayList<Område> getOmråder() {
        return Storage.getOmråder();
    }
    
    public static void createPlads(Område område) {
        område.createPlads();
        
    }
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
    public static Reservation createReservation(Medlem medlem, LocalDate dato, double pris,
        LocalTime startTid, int timer) {
        Reservation r = medlem.createReservation(dato, pris, startTid, timer);
        Storage.addReservation(r);
        return r;
    }
    
    /**
     * Initializes the storage with some objects.
     */
    public static void initStorage() {

    }

    public static void init() {

        initStorage();

    }

}
