package service;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import application.model.Bane;
import application.model.Medlem;
import application.model.Reservation;
import storage.Storage;

/**
 * @author Kristian
 */
public class Service {
    public static Bane addBane(Bane bane) {
        Storage.addBane(bane);
        return bane;
    }

    public static ArrayList<Bane> getBaner() {
        return Storage.getBaner();
    }
    
    public static Medlem addMedlem(Medlem medlem) {
        Storage.addMedlem(medlem);
        return medlem;
    }

    public static Reservation createReservation(Medlem opretter, Medlem makker, Bane bane,
        LocalDate dato, LocalTime startTid) {
        if (bane.isLedig(dato, startTid) && !opretter.hasAktivReservation()) {
            return opretter.createReservation(bane, dato, startTid, makker);
        }
        else {
            return null;
        }
    }

    public static void writeLedigeTider(LocalDate dato, String filnavn) {
        try {
            PrintWriter p = new PrintWriter(filnavn);
            for (Bane b : getBaner()) {
                p.println(b.toString());
                p.println();
                p.println(b.getLedigeTiderPaaDag(dato));
                p.println();
            }
            p.flush();
            p.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static void initStorage() {
        Bane b1 = addBane(new Bane(1, "Nord/syd vendt"));
        Bane b2 = addBane(new Bane(2, "Under egetræet"));
        addBane(new Bane(3, "Med tilskuerpladser"));
        Medlem m1 = addMedlem(new Medlem("Lene Mikkelsen", "12345678", "lm@msn.com"));
        Medlem m2 = addMedlem(new Medlem("Finn Jensen", "22331144", "fj@msn.com"));
        createReservation(m1, m2, b1, LocalDate.now(), LocalTime.of(22, 0));
        createReservation(m2, m1, b2, LocalDate.now(), LocalTime.of(18, 0));
    }
}
