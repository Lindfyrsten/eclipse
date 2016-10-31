package opgave3;

import java.time.LocalDateTime;

public class FlightTest {
    
    public static void main(String[] args) {
        Flight flight = new Flight("AY025", "Seoul");
        Passenger p1 = new Passenger("Arnold", 31);
        Passenger p2 = new Passenger("Bruce", 59);
        Passenger p3 = new Passenger("Dolph", 24);
        Passenger p4 = new Passenger("Linda", 59);
        Passenger p5 = new Passenger("Jennifer", 65);
        flight.newPassenger(p1);
        flight.newPassenger(p2);
        flight.newPassenger(p3);
        flight.newPassenger(p4);
        flight.newPassenger(p5);
        flight.printPassengers();
        flight.removePassenger(p1);
        flight.printPassengers();
        flight.setDepartDate(LocalDateTime.of(2016, 12, 1, 20, 45));
        flight.setArrivalDate(LocalDateTime.of(2016, 12, 2, 23, 30));

//        System.out.println(Arrays.toString(flight.getPassengers()));

//        System.out.println("Rejse i timer: " + flight.flightDurationInHours());
//        System.out.println("Midnatsrejse: " + flight.midnightFlight());
//        System.out.println("Gennemsnitsalder: " + flight.averageAge());
    }
    
}
