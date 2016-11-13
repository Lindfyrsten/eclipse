package application.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Udflugt {
    // ===========================================================
    // Fields
    // ===========================================================
    private String navn;
    private double pris;
    private LocalDateTime dato;
    private ArrayList<Deltager> deltagere = new ArrayList<>();

    // ===========================================================
    // Constructors
    // ===========================================================
    public Udflugt(String navn, double pris, LocalDateTime dato) {
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
    
    public LocalDateTime getDato() {
        return dato;
    }
    
    public void setDato(LocalDateTime dato) {
        this.dato = dato;
    }
    
    public ArrayList<Deltager> getDeltagere() {
        return new ArrayList<>(deltagere);
    }

    // ===========================================================
    // Methods
    // ===========================================================
    public void addDeltager(Deltagelse deltagelse) {
        deltagere.add(deltagelse.getDeltager());
    }

    public void removeDeltagelse(Deltagelse deltagelse) {
        deltagere.remove(deltagelse.getDeltager());
    }

}
