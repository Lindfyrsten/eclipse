package guifx;

import java.time.LocalDate;
import java.time.LocalTime;

import application.model.Bane;
import application.model.Medlem;
import service.Service;

public class TestApp {
    
    public static void main(String[] args) {
        Bane b1 = new Bane(1, "Nord/syd vendt");
        Bane b2 = new Bane(2, "Under egetræet");
        Bane b3 = new Bane(3, "Med tilskuerpladser");
        Medlem m1 = new Medlem("Lene Mikkelsen", "12345678", "lm@msn.com");
        Medlem m2 = new Medlem("Finn Jensen", "22331144", "fj@msn.com");
        
        System.out.println(b1.getLedigeTiderPaaDag(LocalDate.now()));
//        m1.createReservation(b1, LocalDate.now(), LocalTime.of(22, 0), m2);
        Service.createReservation(m1, m2, b1, LocalDate.now(), LocalTime.of(22, 0));
        System.out.println(b1.getReservationer());
        System.out.println(b1.getLedigeTiderPaaDag(LocalDate.now()));
        
        System.out.println();
        System.out.println(m1.hasAktivReservation());
    }

}
