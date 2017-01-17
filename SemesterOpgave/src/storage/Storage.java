package storage;

import java.util.ArrayList;

import application.model.Medlem;
import application.model.Område;
import application.model.Reservation;

public class Storage {
    private static ArrayList<Medlem> medlemmer = new ArrayList<>();
    private static ArrayList<Reservation> reservationer = new ArrayList<>();
    private static ArrayList<Område> områder = new ArrayList<>();
    
    // -------------------------------------------------------------------------
    public static ArrayList<Reservation> getReservationer() {
        return new ArrayList<>(reservationer);
    }

    public static void addReservation(Reservation reservation) {
        reservationer.add(reservation);
    }

    public static void removeReservation(Reservation reservation) {
        reservationer.remove(reservation);
    }
    // -------------------------------------------
    
    public static ArrayList<Område> getOmråder() {
        return new ArrayList<>(områder);
    }
    
    public static void addOmråde(Område område) {
        områder.add(område);
    }
    
    public static void removeOmråde(Område område) {
        områder.remove(område);
    }
    
    // -------------------------------------------------------------------------
    public static ArrayList<Medlem> getMedlemmer() {
        return new ArrayList<>(medlemmer);
    }
    
    public static void addMedlem(Medlem medlem) {
        medlemmer.add(medlem);
    }
    
    public static void removeMedlem(Medlem medlem) {
        medlemmer.remove(medlem);
    }
    
    // -------------------------------------------------------------------------
    
}
