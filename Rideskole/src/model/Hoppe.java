package model;

public class Hoppe extends Hest {

    private int antalFoel;
    
    public Hoppe(String navn, int fødselsaar) {
        super(navn, fødselsaar);

    }
    
    public void setAntalFoel(int antalFoel) {
        this.antalFoel = antalFoel;
    }
    
    public int getAntalFoel() {
        return antalFoel;
    }
    
    @Override
    public String toString() {
        return super.toString() + " (Føl : " + antalFoel + ")";
    }

}
