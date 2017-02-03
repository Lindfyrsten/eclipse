package application.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @author Kristian Lindbjerg
 */
public class Plads implements Comparable<Plads> {
    private Område område;
    private int nummer;
    private ArrayList<Reservation> reservationer = new ArrayList<>();
    private static double standardTimePris = 50;
    
    public Plads(int nummer, Område område) {
        this.nummer = nummer;
        this.område = område;
        
    }
    
    public int getNummer() {
        return nummer;
    }

    public Område getOmråde() {
        return område;
    }
    
    public ArrayList<Reservation> getReservationer() {
        return new ArrayList<>(reservationer);
    }

    public void addReservation(Reservation reservation) {
        reservationer.add(reservation);
        if (!reservation.getPladser().contains(this)) {
            reservation.addPlads(this);
        }
    }

    public void removeReservation(Reservation reservation) {
        reservationer.remove(reservation);
        if (reservation.getPladser().contains(this)) {
            reservation.removePlads(this);
        }
    }

    public static double getStandardTimePris() {
        return standardTimePris;
    }

    public static void setStandardTimePris(double standardTimePris) {
        Plads.standardTimePris = standardTimePris;
    }

    public double pris(int timer) {
        double pris = Plads.standardTimePris * timer;
        if (område == Område.VIP) {
            return pris * 1.25;
        }
        else if (område == Område.TURNERING) {
            return pris * 1.1;
        }
        else if (område == Område.BØRNE) {
            return pris * 0.8;
        }
        else {
            return pris;
        }

    }
    
    public int samletReservationstid(LocalDateTime fra, LocalDateTime til) {
        int hours = 0;
        if (!reservationer.isEmpty()) {
            for (Reservation r : reservationer) {
                for (long i = 0; i < Duration.between(r.getStart(), r.getSlut()).toHours(); i++) {
                    for (long j = 0; j < Duration.between(fra, til).toHours(); j++) {
                        if (r.getStart().plusHours(i).compareTo(fra.plusHours(j)) == 0) {
                            hours++;
                        }
                    }
                }
            }
        }
        return hours;
    }
    
    @Override
    public String toString() {
        return "Plads [" + nummer + ", " + område + "]";
    }
    
    @Override
    public int compareTo(Plads o) {
        if (område == o.getOmråde()) {
            return nummer - o.getNummer();
        }
        else {
            return område.compareTo(o.getOmråde());
        }
    }

}
