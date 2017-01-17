package application.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Medlem {
    private String navn, adresse, mail;
    private int tlfNr, medlemsNr;
    private boolean ryger;
    private ArrayList<Kategori> interesser = new ArrayList<>();
    private ArrayList<Reservation> reservationer = new ArrayList<>();
    
    public Medlem(String navn, String adresse, int tlfNr, int medlemsNr, String mail,
        boolean ryger) {
        this.navn = navn;
        this.adresse = adresse;
        this.tlfNr = tlfNr;
        this.medlemsNr = medlemsNr;
        this.mail = mail;
        this.ryger = ryger;
    }
    
    public String getName() {
        return navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getMail() {
        return mail;
    }

    public int getTlfNr() {
        return tlfNr;
    }

    public int getMedlemsNr() {
        return medlemsNr;
    }

    public boolean isRyger() {
        return ryger;
    }

    // ---------------------------------------------------------------------------

    public void addInteresse(Kategori kategori) {
        interesser.add(kategori);
    }
    
    public void removeInteresse(Kategori kategori) {
        interesser.remove(kategori);
    }
    
    public ArrayList<Kategori> getInteresser() {
        return new ArrayList<>(interesser);
    }
    // ------------------------------------------------------------------------
    
    public Reservation createReservation(LocalDate dato, double pris, LocalTime startTid,
        int timer) {
        Reservation reservation = new Reservation(dato, pris, startTid, timer);
        addReservation(reservation);
        return reservation;
    }

    public void addReservation(Reservation reservation) {
        reservationer.add(reservation);
        if (reservation.getMedlem() != this) {
            reservation.setMedlem(this);
        }
    }
    
    public void removeReservation(Reservation reservation) {
        reservationer.remove(reservation);
        if (reservation.getMedlem() == this) {
            reservation.setMedlem(null);
        }
    }

    public ArrayList<Reservation> getReservationer() {
        return new ArrayList<>(reservationer);
    }

    @Override
    public String toString() {
        return navn;
    }
    
}
