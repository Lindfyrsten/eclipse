package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {
    // ===========================================================
    // Fields
    // ===========================================================
    private String titel;
    private String kortBeskrivelse;
    private LocalDate startDate;
    private LocalDate slutDate;
    private double pris;
    private LocalDate tilmeldningsfrist;
    private ArrayList<Hotel> hoteller = new ArrayList<>();
    private ArrayList<Deltager> deltagere = new ArrayList<>();
    private ArrayList<Udflugt> udflugter = new ArrayList<>();
    
    // ===========================================================
    // Constructors
    // ===========================================================
    public Konference(String titel, double pris) {
        this.titel = titel;
        this.pris = pris;
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getKortBeskrivelse() {
        return kortBeskrivelse;
    }

    public void setKortBeskrivelse(String kortBeskrivelse) {
        this.kortBeskrivelse = kortBeskrivelse;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getSlutDate() {
        return slutDate;
    }

    public void setSlutDate(LocalDate slutDate) {
        this.slutDate = slutDate;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public LocalDate getTilmeldningsfrist() {
        return tilmeldningsfrist;
    }

    public void setTilmeldningsfrist(LocalDate tilmeldningsfrist) {
        this.tilmeldningsfrist = tilmeldningsfrist;
    }

    public ArrayList<Hotel> getHoteller() {
        return hoteller;
    }
    
    public ArrayList<Udflugt> getUdflugter() {
        return udflugter;
    }

    @Override
    public String toString() {
        return titel + " (" + pris + " kr)";
    }

    public ArrayList<Deltager> getDeltagere() {
        return new ArrayList<>(deltagere);
    }

    public void addDeltager(Deltager deltager) {
        deltagere.add(deltager);
    }

    public void removeDeltager(Deltager deltager) {
        deltagere.remove(deltager);

    }
    
    // ===========================================================
    // Methods
    // ===========================================================
    
}
