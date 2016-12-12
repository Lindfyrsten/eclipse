package enumeration;

public class Hund {

    private String navn;
//    private boolean stamtavle;
    private int pris;
    private Race race;

    public Hund(String navn, Race race, int pris) {
        this.navn = navn;
        this.race = race;
        this.pris = pris;
    }

    public String getNavn() {
        return navn;
    }
    
    public int getPris() {
        return pris;
    }

    public Race getRace() {
        return race;
    }
}
