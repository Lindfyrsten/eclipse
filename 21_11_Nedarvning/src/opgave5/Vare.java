package opgave5;

import java.text.DecimalFormat;

/**
 * @author Kristian
 */
public class Vare {
    // ===========================================================
    // Fields
    // ===========================================================
    private String navn, beskrivelse;
    protected double nettoPris, bruttoPris;

    // ===========================================================
    // Constructors
    // ===========================================================
    public Vare(String navn, String beskrivelse, double nettoPris) {
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.nettoPris = nettoPris;
    }
    
    // ===========================================================
    // Methods
    // ===========================================================

    public double beregnBruttoPris() {
        
        bruttoPris = nettoPris * 1.25;
        return bruttoPris;

    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        return navn + " : " + df.format(beregnBruttoPris()) + "kr. (" + nettoPris + "kr før moms)";
    }
}
