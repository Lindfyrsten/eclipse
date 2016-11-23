
package opgave3;

/**
 * @author Kristian
 */
public class Arbejdsdreng extends Ansat {

    // ===========================================================
    // Fields
    // ===========================================================
    private double timeløn;

    // ===========================================================
    // Constructors
    // ===========================================================
    public Arbejdsdreng(String navn, String addresse, double timeløn) {
        super(navn, addresse, timeløn);
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================
    
    // ===========================================================
    // Methods
    // ===========================================================
    @Override
    public double beregnLoen() {
        return 25 * timeløn;
    }
}
