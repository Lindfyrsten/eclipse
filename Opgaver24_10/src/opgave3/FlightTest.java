package opgave3;

import java.time.LocalDateTime;
import java.util.Arrays;

public class FlightTest {

    public static void main(String[] args) {
        Flight flight = new Flight("AY025", "Seoul");
        flight.newPassenger("Arnold", 31);
        flight.newPassenger("Bruce", 59);
        flight.newPassenger("Dolph", 24);
        flight.newPassenger("Linda", 59);
        flight.newPassenger("Jennifer", 65);
        flight.removePassenger("Linda");
        flight.setDepartDate(LocalDateTime.of(2016, 12, 1, 20, 45));
        flight.setArrivalDate(LocalDateTime.of(2016, 12, 2, 23, 30));
        
        System.out.println(Arrays.toString(flight.getPassengers()));
        System.out.println("Rejse i timer: " + flight.flightDurationInHours());
        System.out.println("Midnatsrejse: " + flight.midnightFlight());
        System.out.println("Gennemsnitsalder: " + flight.averageAge());
    }

}
