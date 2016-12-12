package model;

import java.util.ArrayList;

public class Rideskole {

    private String navn;
    private ArrayList<Hest> heste = new ArrayList<>();

    public Rideskole(String navn) {

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
    
    public Hest getYngsteHest() {
        Hest yngste = heste.get(0);
        if (!heste.isEmpty()) {

            for (int i = 1; i < heste.size(); i++) {
                if (heste.get(i).getFødselsaar() > yngste.getFødselsaar()) {
                    yngste = heste.get(i);
                }
            }

        }
        return yngste;
    }

}
