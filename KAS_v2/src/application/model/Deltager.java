package application.model;

import java.util.ArrayList;

public class Deltager {
    // ===========================================================
    // Fields
    // ===========================================================
    private String navn;
    private int alder;
    private String addresse;
    private String nationalitet;
    private Firma firma;
    private ArrayList<Tilmeldning> tilmeldninger;
    
    // ===========================================================
    // Constructors
    // ===========================================================
    public Deltager(String navn, int alder, String addresse, String nationalitet) {

        this.navn = navn;
        this.alder = alder;
        this.addresse = addresse;
        this.nationalitet = nationalitet;
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
    
    public String getNationalitet() {
        return nationalitet;
    }
    
    public void setNationalitet(String nationalitet) {
        this.nationalitet = nationalitet;
    }
    
    public Firma getFirma() {
        return firma;
    }
    
    public void setFirma(Firma firma) {
        this.firma = firma;
    }
    
    public void addTilmeldning(Tilmeldning t) {
        if (!tilmeldninger.contains(t)) {
            tilmeldninger.add(t);
        }
    }

    public ArrayList<Tilmeldning> getTilmeldninger() {
        return tilmeldninger;
    }

    // ===========================================================
    // Methods
    // ===========================================================
    
    @Override
    public String toString() {
        return navn + " (alder: " + alder + ")";
    }
}
