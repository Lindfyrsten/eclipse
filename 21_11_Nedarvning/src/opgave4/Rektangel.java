package opgave4;

public class Rektangel extends Figur {

    // ===========================================================
    // Fields
    // ===========================================================
    private double side1, side2;

    // ===========================================================
    // Constructors
    // ===========================================================
    public Rektangel(double xPos, double yPos, double side1, double side2) {
        super(xPos, yPos);
        this.side1 = side1;
        this.side2 = side2;
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================
    @Override
    public double beregnAreal() {
        return side1 * side2;
    }
}
