package application.model;

public class Invalideplads extends Parkeringsplads {
    private double areal;
    
    public Invalideplads(int nummer, double areal) {
        super(nummer);
        this.areal = areal;

    }

    public double getAreal() {
        return areal;
    }

}
