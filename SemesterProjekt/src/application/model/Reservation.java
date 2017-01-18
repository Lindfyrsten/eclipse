package application.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @author Kristian Lindbjerg
 */
public class Reservation {
    private LocalDateTime start, slut;
    private ArrayList<Plads> pladser = new ArrayList<>();
    
    public Reservation(LocalDateTime start, LocalDateTime slut) {
        this.start = start;
        this.slut = slut;
    }
    
    public LocalDateTime getStart() {
        return start;
    }
    
    public LocalDateTime getSlut() {
        return slut;
    }
    
    public ArrayList<Plads> getPladser() {
        return new ArrayList<>(pladser);
    }

    public void addPlads(Plads plads) {
        pladser.add(plads);
        if (!plads.getReservationer().contains(this)) {
            plads.addReservation(this);
        }
    }

    public void removePlads(Plads plads) {
        pladser.remove(plads);
        if (plads.getReservationer().contains(this)) {
            plads.removeReservation(this);
        }
    }

}
