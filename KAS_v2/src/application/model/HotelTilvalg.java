package application.model;

public class HotelTilvalg {
    // ===========================================================
    // Fields
    // ===========================================================
    private String navn;
    private double pris;

    // ===========================================================
    // Constructors
    // ===========================================================
    public HotelTilvalg(String navn, double pris) {
        this.navn = navn;
        this.pris = pris;
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
    
    // ===========================================================
    // Methods
    // ===========================================================
}
