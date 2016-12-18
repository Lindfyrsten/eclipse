package application.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation implements Comparable<Reservation> {
    private LocalDate dato;
    private LocalTime startTid;
    private Bane bane;
    private Medlem opretter, makker;

    public Reservation(LocalDate dato, LocalTime startTid, Bane bane, Medlem opretter,
        Medlem makker) {
        this.dato = dato;
        this.startTid = startTid;
        this.bane = bane;
        this.opretter = opretter;
        this.makker = makker;
    }
    
    public Medlem getMakker() {
        return makker;
    }

    public Medlem getOpretter() {
        return opretter;
    }
    
    public Bane getBane() {
        return bane;
    }
    
    public LocalTime getStartTid() {
        return startTid;
    }
    
    public LocalDate getDato() {
        return dato;
    }
    
    @Override
    public String toString() {
        return "\n" + dato + " (" + startTid + ") | " + opretter.toString() + " vs. "
            + makker.toString();
    }

    @Override
    public int compareTo(Reservation o) {
        if (o.getDato().equals(dato) && o.getStartTid().equals(startTid)) {
            return bane.getNummer() - o.getBane().getNummer();
        }
        else
            if (o.getDato().equals(dato)) {
                return startTid.compareTo(o.getStartTid());
            }
            else {
                return dato.compareTo(o.getDato());
            }
    }
}
