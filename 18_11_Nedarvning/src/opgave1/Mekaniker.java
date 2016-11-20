package opgave1;

public class Mekaniker extends Person {
    private int svendeprøveår;
    private double timelønindsats;
    
    public Mekaniker(String navn, String addresse, int svendeprøveår, double timelønidsats) {
        super(navn, addresse);
        this.svendeprøveår = svendeprøveår;
        this.timelønindsats = timelønidsats;
    }
    
    public int getSvendeprøveår() {
        return svendeprøveår;
    }
    
    public void setSvendeprøveår(int svendeprøveår) {
        this.svendeprøveår = svendeprøveår;
    }
    
    public double getTimelønindsats() {
        return timelønindsats;
    }
    
    public void setTimelønindsats(double timelønindsats) {
        this.timelønindsats = timelønindsats;
    }
    
    public double beregnLoen() {
        return timelønindsats * 37;
    }
    
}
