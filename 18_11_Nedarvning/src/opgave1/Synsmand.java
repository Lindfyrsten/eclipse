package opgave1;

public class Synsmand extends Mekaniker {
    
    private int antalSyn;
    
    public Synsmand(String navn, String addresse, int svendeprøveår, double timelønsats) {
        super(navn, addresse, svendeprøveår, timelønsats);
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
