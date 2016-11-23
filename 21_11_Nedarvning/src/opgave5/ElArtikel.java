package opgave5;

/**
 * @author Kristian
 */
public class ElArtikel extends Vare {

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
    public ElArtikel(String navn, String beskrivelse, double nettoPris) {
        super(navn, beskrivelse, nettoPris);
        // TODO Auto-generated constructor stub
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================
    @Override
    public double beregnBruttoPris() {
        double moms = nettoPris * 0.3;
        if (moms < 3) {
            moms = 3;
        }
        return nettoPris + moms;

    }
}
