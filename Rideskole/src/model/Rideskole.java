package model;

import java.util.ArrayList;

public class Rideskole {

    private String navn;
    private ArrayList<Hest> heste = new ArrayList<>();

    public Rideskole(String navn) {
        this.navn = navn;

    }

    public String getNavn() {
        return navn;
    }
    
    public void addHest(Hest hest) {
        heste.add(hest);
    }

    public ArrayList<Hest> getHeste() {
        return new ArrayList<>(heste);
    }
    
    public String getYngsteHest() {
        Hest yngste = null;
        if (!heste.isEmpty()) {
            yngste = heste.get(0);
            for (int i = 1; i < heste.size(); i++) {
                if (heste.get(i).getFødselsaar() > yngste.getFødselsaar()) {
                    yngste = heste.get(i);
                }
            }

        }
        return yngste.toString();
    }

}
