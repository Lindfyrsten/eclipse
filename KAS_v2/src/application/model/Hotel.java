package application.model;

import java.util.ArrayList;

public class Hotel {
    // ===========================================================
    // Fields
    // ===========================================================
    private String navn;
    private String addresse;
    private double dagsPrisEnkelt;
    private double dagsPrisDobbelt;
    private ArrayList<HotelTilvalg> tilvalg;

    // ===========================================================
    // Constructors
    // ===========================================================
    public Hotel(String navn, String addresse, double enkelt, double dobbelt,
        ArrayList<HotelTilvalg> tilvalg) {
        this.navn = navn;
        this.addresse = addresse;
        this.dagsPrisEnkelt = enkelt;
        this.dagsPrisDobbelt = dobbelt;
        this.tilvalg = tilvalg;
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

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public double getDagsPrisEnkelt() {
        return dagsPrisEnkelt;
    }

    public void setDagsPrisEnkelt(double dagsPrisEnkelt) {
        this.dagsPrisEnkelt = dagsPrisEnkelt;
    }

    public double getDagsPrisDobbelt() {
        return dagsPrisDobbelt;
    }

    public void setDagsPrisDobbelt(double dagsPrisDobbelt) {
        this.dagsPrisDobbelt = dagsPrisDobbelt;
    }

    public void addTilvalg(HotelTilvalg tv) {
        tilvalg.add(tv);
    }
    
    public ArrayList<HotelTilvalg> getTilvalg() {
        return new ArrayList<>(tilvalg);
    }

    public void setTilvalg(ArrayList<HotelTilvalg> tilvalg) {
        this.tilvalg = tilvalg;
    }

    @Override
    public String toString() {
        return navn;
    }
    
}
