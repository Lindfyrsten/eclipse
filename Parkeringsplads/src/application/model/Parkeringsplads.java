package application.model;

import java.time.LocalTime;

public class Parkeringsplads {
    private int nummer;
    private LocalTime ankomst = null;
    private Bil bil;
    private boolean invalidePlads = false;
    
    public Parkeringsplads(int nummer) {
        this.nummer = nummer;
    }

    public int getNummer() {
        return nummer;
    }
    
    public Bil getBil() {
        return bil;
    }

    public LocalTime getAnkomst() {
        return ankomst;
    }
    
    public void setAnkomst(LocalTime ankomst) {
        this.ankomst = ankomst;
    }
    
    /**
     * @param bil
     * @param ankomst
     * Opretter ny parkering
     */
    public void nyParkering(Bil bil, LocalTime ankomst) {
        this.bil = bil;
        this.ankomst = ankomst;
    }
    
    /**
     * @param afgangstidspunkt
     * Afleverer bilen
     */
    public double hentBil(LocalTime afgangstidspunkt) {
        double pris = beregnPris(afgangstidspunkt);
        this.bil = null;
        this.ankomst = null;
        return pris;

    }
    
    /**
     * @return
     * Beregner pris på parkering
     */
    public double beregnPris(LocalTime afgangstidspunkt) {
        double pris = 0;
        if (!invalidePlads) {

            int hours = afgangstidspunkt.getHour() - ankomst.getHour();
            int minutes = afgangstidspunkt.getMinute() - ankomst.getMinute();
            pris = hours * 36 + minutes / 10 * 6;
        }
        return pris;

    }
    
    @Override
    public String toString() {
        if (bil != null) {
            return "Plads " + nummer + ", " + bil.toString();
        }
        else {
            
            return "Plads " + nummer;
        }
    }
    
}
