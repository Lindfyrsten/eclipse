package application.model;

public class Firma {
    // ===========================================================
    // Fields
    // ===========================================================
    private String navn;

    // ===========================================================
    // Constructors
    // ===========================================================
    public Firma(String navn) {
        this.navn = navn;

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
    
}
