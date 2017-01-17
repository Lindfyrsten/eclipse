package application.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Kristian Lindbjerg
 */
public class Reservation {
    private LocalDate dato;
    private LocalTime startTid;
    private double pris;
    private int timer;
    private Plads plads;
    private Medlem medlem;
    
    public Reservation(LocalDate dato, double pris, LocalTime startTid, int timer) {
        this.dato = dato;
        this.pris = pris;
        this.startTid = startTid;
        this.timer = timer;
    }

    public Reservation(LocalDate dato, double pris, LocalTime startTid, int timer, Plads p) {
        this.dato = dato;
        this.pris = pris;
        this.startTid = startTid;
        this.timer = timer;
        this.plads = p;
    }
    
    public LocalDate getDato() {
        return dato;
    }
    
    public double getPris() {
        return pris;
    }
    
    public int getTimer() {
        return timer;
    }

    public Plads getPlads() {
        return plads;
    }

    public Medlem getMedlem() {
        return medlem;
    }
    
    public LocalTime getStartTid() {
        return startTid;
    }

    public void setMedlem(Medlem medlem) {
        Medlem oldMedlem = this.medlem;
        this.medlem = medlem;
        if (oldMedlem != null) {
            oldMedlem.removeReservation(this);
        }
        if (medlem != null && !medlem.getReservationer().contains(this)) {
            medlem.addReservation(this);
        }
    }

}
