package opgave1;

public class Synsmand extends Mekaniker {

    private int antalSyn;

    private double tillæg;
    
    public Synsmand(String navn, String addresse, int svendeprøveår, double timelønsats,
        double tillæg, int antalSyn) {
        super(navn, addresse, svendeprøveår, timelønsats);
        this.antalSyn = antalSyn;
        this.tillæg = tillæg;
    }
    
    @Override
    
    public double getUgentligLøn() {
        return super.getUgentligLøn() + tillæg * 37;
    }
    
    public int getSyn() {
        return antalSyn;
    }
}
