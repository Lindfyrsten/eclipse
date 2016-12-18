package application.model;

import java.time.LocalDate;
import java.time.LocalTime;

import service.Service;

public class TestApp {
    
    public static void main(String[] args) {
        Bane b1 = new Bane(1, "Nord/syd vendt");
        Bane b2 = new Bane(2, "Under egetræet");
        Bane b3 = new Bane(3, "Med tilskuerpladser");
        Service.addBane(b1);
        Service.addBane(b2);
        Service.addBane(b3);
        Medlem m1 = new Medlem("Lene Mikkelsen", "12345678", "lm@msn.com");
        Medlem m2 = new Medlem("Finn Jensen", "22331144", "fj@msn.com");
        
        System.out.println(b1.getLedigeTiderPaaDag(LocalDate.now()));
        Reservation r1 =
            Service.createReservation(m1, m2, b1, LocalDate.now(), LocalTime.of(22, 0));
        Reservation r2 =
            Service.createReservation(m2, m1, b1, LocalDate.now(), LocalTime.of(18, 0));
        System.out.println(b1.getReservationer());
        System.out.println(b1.getLedigeTiderPaaDag(LocalDate.now()));
        
        System.out.println();
        System.out.println(m1.hasAktivReservation());
        System.out.println(Service.getBaner());
        Service.writeLedigeTider(LocalDate.now(), "ledigeTider.txt");

    }

}
