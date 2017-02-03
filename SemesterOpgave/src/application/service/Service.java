package application.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import application.model.Arrangement;
import application.model.KonsolPlads;
import application.model.Område;
import application.model.Plads;
import application.model.Reservation;
import storage.Storage;

public class Service {
    
    // -------------------------------------------------------------------------
    public static Arrangement createArrangement(String navn, boolean offentlig) {
        Arrangement a = new Arrangement(navn, offentlig);
        Storage.addArrangement(a);
        return a;
    }

    public static ArrayList<Arrangement> getArrangementer() {
        return Storage.getArrangement();
    }

    public static void addReservation(Arrangement arrangement, Reservation reservation) {
        arrangement.addReservation(reservation);
    }
    
    // -------------------------------------------------------------------------
    public static Plads createPlads(int nummer, Område område) {
        Plads p = new Plads(nummer, område);
        Storage.addPlads(p);
        return p;
    }

    public static ArrayList<Plads> getPladser() {
        return Storage.getPladser();
    }
    
    public static Plads createKonsolPlads(int nummer, Område område, String type) {
        Plads p = new KonsolPlads(nummer, område, type);
        Storage.addPlads(p);
        return p;
    }

    // -------------------------------------------------------------------------
    public static Reservation createReservation(LocalDateTime start, LocalDateTime slut) {
        Reservation r = new Reservation(start, slut);
        Storage.addReservation(r);
        return r;
    }
    
    public static ArrayList<Reservation> getReservationer() {
        return Storage.getReservationer();
    }
    
    public static void addPlads(Reservation reservation, Plads plads) {
        reservation.addPlads(plads);
    }
    
    /**
     * Finder en bestemt plads i et område, hvis den findes.
     * @param område
     * @param nummer
     * @return
     */
    public static Plads findPlads(Område område, int nummer) {
        ArrayList<Plads> list = new ArrayList<>();
        for (Plads p : Service.getPladser()) {
            if (p.getOmråde() == område) {
                list.add(p);
            }
        }
        boolean found = false;
        int left = 0;
        int right = list.size() - 1;
        int middle = -1;
        Plads plads = null;
        while (!found && left <= right) {
            middle = (left + right) / 2;
            plads = list.get(middle);
            int comp = plads.getNummer() - nummer;
            if (comp == 0) {
                found = true;
            }
            else if (comp > 0) {
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        if (found) {
            return plads;
        }
        else {
            return null;
        }
    }
    
    public static int reservationsTidpåOmråde(Område område, LocalDateTime fra, LocalDateTime til) {
        int hours = 0;
        ArrayList<Plads> pladser = new ArrayList<>();
        if (!getPladser().isEmpty()) {
            
            for (Plads p : getPladser()) {
                if (p.getOmråde().equals(område)) {
                    pladser.add(p);
                }
            }
        }
        for (Plads p : pladser) {
            hours += p.samletReservationstid(fra, til);
        }
        return hours;

    }
    
    /**
     * Initializes the storage with some objects.
     */
    public static void initStorage() {
        Plads p1 = createPlads(1, Område.TURNERING);
        Plads p2 = createPlads(2, Område.TURNERING);
        Plads p3 = createPlads(3, Område.STANDARD);
        Plads p4 = createPlads(4, Område.STANDARD);
        Plads p5 = createPlads(5, Område.BØRNE);
        Plads p6 = createKonsolPlads(1, Område.VIP, "PlayStation 4");
        Plads p7 = createKonsolPlads(2, Område.VIP, "Xbox One");
        
        Arrangement a1 = createArrangement("Dota 2 tournament", true);
        Arrangement a2 = createArrangement("CS GO tournament", false);
        
        Reservation r1 =
            createReservation(LocalDateTime.of(LocalDate.of(2017, 8, 12), LocalTime.of(20, 0)),
                LocalDateTime.of(LocalDate.of(2017, 8, 12), LocalTime.of(23, 0)));
        r1.addPlads(p1);
        r1.addPlads(p2);
        a1.addReservation(r1);
        
        Reservation r2 =
            createReservation(LocalDateTime.of(LocalDate.of(2017, 8, 13), LocalTime.of(19, 0)),
                LocalDateTime.of(LocalDate.of(2017, 8, 14), LocalTime.of(6, 0)));
        r2.addPlads(p3);
        r2.addPlads(p4);
        
        Reservation r3 =
            createReservation(LocalDateTime.of(LocalDate.of(2017, 8, 14), LocalTime.of(19, 0)),
                LocalDateTime.of(LocalDate.of(2017, 8, 15), LocalTime.of(6, 0)));
        r3.addPlads(p7);
        
    }
    
    public static void init() {
        
        initStorage();
        
    }
    
}
