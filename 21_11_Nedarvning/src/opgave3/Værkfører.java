package opgave3;

public class Værkfører extends Ansat {
    private int udnævnelse;
    private double tillæg;

    public Værkfører(String navn, String addresse, double timeløn, int udnævnelse, double tillæg) {
        super(navn, addresse, timeløn);
        this.udnævnelse = udnævnelse;
        this.tillæg = tillæg;
    }
    
    @Override
    public double beregnLoen() {
        return super.beregnLoen() + 37 * tillæg;
    }
}
