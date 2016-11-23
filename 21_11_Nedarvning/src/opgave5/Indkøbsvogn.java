package opgave5;

import java.util.ArrayList;

/**
 * @author Kristian
 */
public class Indkøbsvogn {

    private String navn;
    private ArrayList<Vare> varer = new ArrayList<>();
    
    public Indkøbsvogn(String navn) {
        this.navn = navn;
    }

    public void tilføjVare(Vare vare) {
        varer.add(vare);

    }
    
    public String getNavn() {
        return navn;
    }
    
    public ArrayList<Vare> getVarer() {
        return new ArrayList<>(varer);
    }

    public double samletPris() {
        double sum = 0;
        for (Vare v : varer) {
            sum += v.beregnBruttoPris();
        }
        return sum;
    }

    @Override
    public String toString() {
        String str = "";
        for (Vare v : varer) {
            str += v.toString() + "\n";
        }
        return str;
    }

}
