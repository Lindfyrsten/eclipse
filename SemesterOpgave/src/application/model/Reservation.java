package application.model;

import java.time.LocalDate;

/**
 * @author Kristian Lindbjerg
 */
public class Reservation {
    private LocalDate dato;
    private double pris;
    private int timer;
    private Medlem medlem;
    
    public Reservation(LocalDate dato, double pris, int timer) {
        this.dato = dato;
        this.pris = pris;
        this.timer = timer;
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

    public Medlem getMedlem() {
        return medlem;
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
