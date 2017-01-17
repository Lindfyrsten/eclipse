package storage;

import java.util.ArrayList;

import application.model.Medlem;
import application.model.Reservation;

public class Storage {
    private static ArrayList<Medlem> medlemmer = new ArrayList<>();
    private static ArrayList<Reservation> reservationer = new ArrayList<>();

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
    // -------------------------------------------------------------------------

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
