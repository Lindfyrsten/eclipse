package application.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Medlem {
    private String navn, mobil, mail;
    private ArrayList<Reservation> reservationer = new ArrayList<>();
    private Medlem makker;

    public Medlem(String navn, String mobil, String mail) {
        this.navn = navn;
        this.mobil = mobil;
        this.mail = mail;
    }
    
    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    public String getMail() {
        return mail;
    }

    public void setMakker(Medlem makker) {
        this.makker = makker;
    }
    
    public Medlem getMakker() {
        return makker;
    }

    public ArrayList<Reservation> getReservationer() {
        return reservationer;
    }

    public void addReservation(Reservation reservation) {
        reservationer.add(reservation);
    }

    public Reservation createReservation(Bane bane, LocalDate date, LocalTime time, Medlem makker) {
        Reservation r = new Reservation(date, time, bane, this, makker);
        bane.addReservation(r);
        addReservation(r);
        setMakker(makker);
        return r;
    }
    
    public boolean hasAktivReservation() {
        boolean result = false;
        int i = 0;
        while (!result && i < reservationer.size()) {
            Reservation r = reservationer.get(i);
            if (r.getDato().atTime(r.getStartTid()).isAfter(LocalDateTime.now())) {
                result = true;
            }
            else {
                i++;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return navn;
    }
}
