package application.model;

/**
 * @author Kristian Lindbjerg
 */
public class Plads {
    private Område område;
    private int nummer;
    private boolean ledig;

    public Plads(int nummer) {
        this.nummer = nummer;
        ledig = true;

    }

    public int getNummer() {
        return nummer;
    }

    public boolean isLedig() {
        return ledig;
    }
    
    public Område getOmråde() {
        return område;
    }
    
    public void setOmråde(Område område) {
        Område oldOmråde = this.område;
        this.område = område;
        if (oldOmråde != null) {
            oldOmråde.removePlads(this);
        }
    }
}
