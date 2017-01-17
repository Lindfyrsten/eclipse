package application.model;

import java.util.ArrayList;

/**
 * @author Kristian Lindbjerg
 */
public class Område {
    private String navn;
    private int antalPladser;
    private double prisMedlem, pris;
    private ArrayList<Plads> pladser = new ArrayList<>();
    
    public Område(String navn, int antalPladser, double prisMedlem, double pris) {
        this.navn = navn;
        this.antalPladser = antalPladser;
        this.pris = pris;
        this.prisMedlem = prisMedlem;
    }
    
    public String getNavn() {
        return navn;
    }
    
    public int getAntalPladser() {
        return antalPladser;
    }
    
    public double getPrisMedlem() {
        return prisMedlem;
    }
    
    public double getPris() {
        return pris;
    }

    public Plads createPlads() {
        Plads p = new Plads(antalPladser + 1);
        addPlads(p);
        return p;

    }

    public void addPlads(Plads p) {
        pladser.add(p);
        if (p.getOmråde() != this) {
            p.setOmråde(this);
        }
    }

    public ArrayList<Plads> getPladser() {
        return new ArrayList<>(pladser);
    }

    public void removePlads(Plads plads) {
        pladser.remove(plads);
        if (plads.getOmråde() == this) {
            plads.setOmråde(null);
        }
    }

    public int getLedigePladser() {
        int count = 0;
        if (!pladser.isEmpty()) {
            for (Plads p : pladser) {
                if (p.isLedig()) {
                    count++;
                }
            }
        }
        return count;
    }

}
