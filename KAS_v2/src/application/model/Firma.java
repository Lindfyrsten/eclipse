package application.model;

import java.util.ArrayList;

public class Firma {
    // ===========================================================
    // Fields
    // ===========================================================
    private String navn;
    private int tlfNummer;
    private String addresse;

    // ===========================================================
    // Constructors
    // ===========================================================
    public Firma(String navn, int tlfNr, String addresse) {
        this.navn = navn;
        this.tlfNummer = tlfNr;
        this.addresse = addresse;
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
    
    public int getTlfNummer() {
        return tlfNummer;
    }
    
    public void setTlfNummer(int tlfNummer) {
        this.tlfNummer = tlfNummer;
    }
    
    public String getAddresse() {
        return addresse;
    }
    
    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    // ===========================================================
    // Methods
    // ===========================================================
    
}
