package application.model;

import java.util.ArrayList;

/**
 * @author Kristian Lindbjerg
 */
public class Arrangement {
    private String navn;
    private boolean offentlig;
    private ArrayList<Reservation> reservationer = new ArrayList<>();

    public Arrangement(String navn, boolean offentlig) {
        this.navn = navn;

    }

    public String getNavn() {
        return navn;
    }

    public boolean isOffentlig() {
        return offentlig;
    }
    
    public ArrayList<Reservation> getReservationer() {
        return new ArrayList<>(reservationer);
    }
    
    public void addReservation(Reservation reservation) {
        reservationer.add(reservation);
    }
    
    public void removeReservation(Reservation reservation) {
        reservationer.remove(reservation);
    }
    
    public int antalReserveredePladser() {
        int count = 0;
        if (!reservationer.isEmpty()) {
            for (Reservation r : reservationer) {
                if (!r.getPladser().isEmpty()) {

                    count += r.getPladser().size();
                }
            }
        }
        return count;
    }
    
    @Override
    public String toString() {
        return navn;
    }
    
}
