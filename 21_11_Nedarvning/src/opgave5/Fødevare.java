package opgave5;

/**
 * @author Kristian
 */
public class Fødevare extends Vare {

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
    public Fødevare(String navn, String beskrivelse, double nettoPris) {
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
        return nettoPris * 1.05;
        
    }
}
