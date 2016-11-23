package opgave4;

public class Kvadrat extends Figur {
    
    /**
     * @param xPos
     * @param yPos
     * @param areal
     */

    // ===========================================================
    // Fields
    // ===========================================================
    private double side;

    // ===========================================================
    // Constructors
    // ===========================================================
    public Kvadrat(double xPos, double yPos, double side) {
        super(xPos, yPos);
        this.side = side;
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================
    @Override
    public double beregnAreal() {
        return side * side;
    }
}
