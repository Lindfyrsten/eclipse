package application.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import application.service.Service;

public class TestApp {
    
    public static void main(String[] args) {
        Service.init();
        System.out.println(Service.getPladser());
        System.out.println(Service.getArrangementer());
        
        for (Arrangement a : Service.getArrangementer()) {
            System.out.println(a.antalReserveredePladser());
        }
        
//        System.out.println(Service.findPlads(Område.BØRNE, 5));
//        System.out.println(Service.findPlads(Område.STANDARD, 3));
//        System.out.println(Service.findPlads(Område.STANDARD, 4));
//        System.out.println(Service.findPlads(Område.TURNERING, 1));
//        System.out.println(Service.findPlads(Område.TURNERING, 3));
        System.out.println(Service.getPladser().get(0).samletReservationstid(
            LocalDateTime.of(LocalDate.of(2017, 9, 12), LocalTime.of(22, 0)),
            LocalDateTime.of(LocalDate.of(2017, 9, 12), LocalTime.of(23, 0))));

        System.out.println(Service.reservationsTidpåOmråde(Område.STANDARD,
            LocalDateTime.of(LocalDate.of(2017, 1, 12), LocalTime.of(22, 0)),
            LocalDateTime.of(LocalDate.of(2017, 12, 12), LocalTime.of(23, 0))));
    }
    
}
