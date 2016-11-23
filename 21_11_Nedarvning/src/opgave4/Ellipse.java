package opgave4;

public class Ellipse extends Figur {
    
    // ===========================================================
    // Fields
    // ===========================================================
    private double radius1, radius2;
    
    // ===========================================================
    // Constructors
    // ===========================================================
    public Ellipse(double xPos, double yPos, double radius1, double radius2) {
        super(xPos, yPos);
        this.radius1 = radius1;
        this.radius2 = radius2;
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================
    
    // ===========================================================
    // Methods
    // ===========================================================
    @Override
    public double beregnAreal() {
        return 3.14 * radius1 * radius2;
    }
}
