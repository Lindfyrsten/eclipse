package opgave5;

/**
 * @author Kristian
 */
public class Spiritus extends Vare {

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Constructors
    // ===========================================================

    /**
     * @param navn
     * @param beskrivelse
     * @param nettoPris
     * @param moms
     */
    public Spiritus(String navn, String beskrivelse, double nettoPris) {
        super(navn, beskrivelse, nettoPris);
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================
    @Override
    public double beregnBruttoPris() {

        double bruttoPris = nettoPris * 1.8;
        if (nettoPris > 90) {
            bruttoPris = nettoPris * 2.2;
        }
        return bruttoPris;
        
    }
}
