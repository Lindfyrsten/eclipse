package opgave1;

public class Værkfører extends Mekaniker {
    private int udnævnelse;
    private double tillæg;
    
    public Værkfører(String navn, String addresse, int svendeprøveår, double timelønindsats,
        int udnævnelse, double tillæg) {
        super(navn, addresse, svendeprøveår, timelønindsats);
    }

    @Override
    public double getUgentligLøn() {
        return super.getUgentligLøn() + 37 * tillæg;
    }
}
