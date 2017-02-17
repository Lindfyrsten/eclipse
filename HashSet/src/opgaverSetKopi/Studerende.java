package opgaverSetKopi;

import java.util.ArrayList;
import java.util.List;

public class Studerende implements Comparable<Studerende> {
    private int studieNr;
    private String navn;
    private List<Integer> karakterer;

    public Studerende(int studieNr, String navn) {
        this.studieNr = studieNr;
        this.navn = navn;
        karakterer = new ArrayList<>();
    }

    public int getStudieNr() {
        return studieNr;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void addKarakter(int karakter) {
        karakterer.add(karakter);
    }

    public List<Integer> getKarakterer() {
        return karakterer;
    }

    @Override
    public String toString() {
        return navn + ": " + studieNr;
    }
    
    @Override
    public int compareTo(Studerende o) {
        return studieNr - o.getStudieNr();
    }
}
