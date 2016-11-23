package opgave3;

public class Mekaniker extends Ansat {
    private int svendeprøveår;
    private double timeløn;

    public Mekaniker(String navn, String addresse, double timeløn, int svendeprøveår) {
        super(navn, addresse, timeløn);
        this.svendeprøveår = svendeprøveår;
        this.timeløn = timeløn;
    }

    public int getSvendeprøveår() {
        return svendeprøveår;
    }

    public void setSvendeprøveår(int svendeprøveår) {
        this.svendeprøveår = svendeprøveår;
    }

    public double getTimelønindsats() {
        return timeløn;
    }

    public void setTimelønindsats(double timeløn) {
        this.timeløn = timeløn;
    }

    @Override
    public double beregnLoen() {
        return super.beregnLoen();
    }
    
}
