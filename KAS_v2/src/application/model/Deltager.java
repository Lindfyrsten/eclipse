package application.model;

import java.util.ArrayList;

public class Deltager {
    // ===========================================================
    // Fields
    // ===========================================================
    private String navn, addresse, land;
    private int alder, tlfNr;
    private Firma firma;
    private ArrayList<Tilmeldning> tilmeldninger = new ArrayList<>();
    
    // ===========================================================
    // Constructors
    // ===========================================================
    public Deltager(String navn, int alder, String addresse, String land, int tlfNr) {
        
        this.navn = navn;
        this.alder = alder;
        this.addresse = addresse;
        this.land = land;
        this.tlfNr = tlfNr;
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
    
    public int getAlder() {
        return alder;
    }
    
    public void setAlder(int alder) {
        this.alder = alder;
    }
    
    public String getAddresse() {
        return addresse;
    }
    
    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }
    
    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }
    
    public int getTlfNr() {
        return tlfNr;
    }
    
    public void setTlfNr(int tlfNr) {
        this.tlfNr = tlfNr;
    }

    public Firma getFirma() {
        return firma;
    }
    
    public void setFirma(Firma firma) {
        this.firma = firma;
    }
    
    public ArrayList<Tilmeldning> getTilmeldninger() {
        return tilmeldninger;
    }

    // ===========================================================
    // Methods
    // ===========================================================
    public void addTilmeldning(Tilmeldning t) {
        if (!tilmeldninger.contains(t)) {
            tilmeldninger.add(t);
        }
    }
    
    @Override
    public String toString() {
        return navn + " (alder: " + alder + ")";
    }
}
