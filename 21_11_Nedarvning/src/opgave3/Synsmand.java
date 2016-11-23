package opgave3;

public class Synsmand extends Mekaniker {

    private int antalSyn;

    public Synsmand(String navn, String addresse, double timeløn, int svendeprøveår) {
        super(navn, addresse, timeløn, svendeprøveår);
    }
    
    @Override
    
    public double beregnLoen() {
        return super.beregnLoen() + antalSyn * 29;
    }
    
    public int getSyn() {
        return antalSyn;
    }

    public void setAntalSyn(int antalSyn) {
        this.antalSyn = antalSyn;
    }

    public int getAntalSyn() {
        return antalSyn;
    }
}
