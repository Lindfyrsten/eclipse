package application.model;

public class Kunde {
    private String navn, addresse;
    private int kørekortNr, tlfNr;
    private boolean erhvervskunde;
    
    public Kunde(String navn, String addresse, int tlfNr, int kørekortNr) {
        this.navn = navn;
        this.addresse = addresse;
        this.tlfNr = tlfNr;
        this.kørekortNr = kørekortNr;
    }

    public int getTelefonnr() {
        return tlfNr;
    }

    public void setTelefonnr(int tlfNr) {
        this.tlfNr = tlfNr;
    }

    public boolean isErhvervskunde() {
        return erhvervskunde;
    }

    public void setErhvervskunde(boolean erhvervskunde) {
        this.erhvervskunde = erhvervskunde;
    }

    public String getNavn() {
        return navn;
    }

    public String getAddresse() {
        return addresse;
    }

    public int getKørekortnr() {
        return kørekortNr;
    }
    
}
