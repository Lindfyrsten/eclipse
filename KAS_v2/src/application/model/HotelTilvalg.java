package application.model;

public class HotelTilvalg {
    // ===========================================================
    // Fields
    // ===========================================================
    private String navn;
    private double dagsPris;
    
    // ===========================================================
    // Constructors
    // ===========================================================
    public HotelTilvalg(String navn, double dagsPris) {
        this.navn = navn;
        this.dagsPris = dagsPris;
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
    
    public double getDagsPris() {
        return dagsPris;
    }
    
    public void setDagsPris(double dagsPris) {
        this.dagsPris = dagsPris;
    }

    // ===========================================================
    // Methods
    // ===========================================================
}
