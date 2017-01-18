package application.model;

public class KonsolPlads extends Plads {
    private String type;

    public KonsolPlads(int nummer, Område område, String type) {
        super(nummer, område);
        this.type = type;
    }

    public String getType() {
        return type;
    }
    
    @Override
    public double pris(int timer) {
        if (super.getOmråde() == Område.BØRNE) {
            return super.pris(timer) * 1.1;
        }
        else {
            return super.pris(timer) * 1.25;
        }
    }

    @Override
    public String toString() {
        return "Konsol" + super.toString() + ", " + type;
    }
    
}
