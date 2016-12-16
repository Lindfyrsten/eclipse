package service;

import java.time.LocalDate;
import java.time.LocalTime;

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
    
    public static void initStorage() {
        addBane(new Bane(1, "Nord/syd vendt"));
        addBane(new Bane(2, "Under egetræet"));
        addBane(new Bane(3, "Med tilskuerpladser"));
        addMedlem(new Medlem("Lene Mikkelsen", "12345678", "lm@msn.com"));
        addMedlem(new Medlem("Finn Jensen", "22331144", "fj@msn.com"));
    }
}
