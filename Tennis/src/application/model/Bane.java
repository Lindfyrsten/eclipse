package application.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Bane {
    private int nummer;
    private String baneinfo;
    private ArrayList<Reservation> reservationer = new ArrayList<>();
    
    public Bane(int nummer, String baneinfo) {
        this.nummer = nummer;
        this.baneinfo = baneinfo;
    }

    public int getNummer() {
        return nummer;
    }
    
    public String getBaneinfo() {
        return baneinfo;
    }
    
    public ArrayList<Reservation> getReservationer() {
        return new ArrayList<>(reservationer);
    }
    
    public void addReservation(Reservation reservation) {
        if (!reservationer.contains(reservation)) {
            
            reservationer.add(reservation);
        }

    }
    
    public boolean isLedig(LocalDate dato, LocalTime tid) {
        int i = 0;
        boolean ledig = true;
        while (i < reservationer.size() && !ledig) {
            Reservation result = reservationer.get(i);
            if (result.getDato() == dato && result.getStartTid() == tid) {
                ledig = false;
            }
            else {
                i++;
            }
        }
        return ledig;
    }
    
    public ArrayList<LocalTime> getLedigeTiderPaaDag(LocalDate dato) {
        ArrayList<LocalTime> ledigePladser = new ArrayList<>();
        LocalDateTime dt = LocalTime.of(6, 0).atDate(dato);
        while (dt.isBefore(dato.atTime(23, 0))) {
            LocalTime time = dt.toLocalTime();
            ledigePladser.add(time);
            for (Reservation r : reservationer) {
                if (dt.toLocalTime().equals(r.getStartTid())) {
                    ledigePladser.remove(time);
                }
            }
            dt = dt.plusHours(1);
        }
        return ledigePladser;
    }
}
