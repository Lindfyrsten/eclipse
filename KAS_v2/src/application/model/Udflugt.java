package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Udflugt {
    // ===========================================================
    // Fields
    // ===========================================================
    private String navn;
    private double pris;
    private LocalDate dato;
    private ArrayList<Deltager> deltagere = new ArrayList<>();
    
    // ===========================================================
    // Constructors
    // ===========================================================
    public Udflugt(String navn, double pris, LocalDate dato) {
        this.navn = navn;
        this.pris = pris;
        this.dato = dato;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================
    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public ArrayList<Deltager> getDeltagere() {
        return new ArrayList<>(deltagere);
    }

    @Override
    public String toString() {
        return navn + " (" + pris + " kr)";
    }
    
    // ===========================================================
    // Methods
    // ===========================================================
    public void addDeltager(Tilmeldning tilmeldning) {
        deltagere.add(tilmeldning.getDeltager());
    }
    
    public void removeDeltagelse(Tilmeldning tilmeldning) {
        deltagere.remove(tilmeldning.getDeltager());
    }
    
}
