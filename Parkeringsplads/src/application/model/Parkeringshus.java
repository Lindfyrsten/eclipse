package application.model;

import java.util.ArrayList;

/**
 * @author Lindbjerg
 *
 */
public class Parkeringshus {
    
    private String addresse;
    private double saldo;
    private ArrayList<Parkeringsplads> pladser = new ArrayList<>();
    private int pladsNummer = 1;
    
    public Parkeringshus(String addresse) {
        this.addresse = addresse;
    }

    public String getAddresse() {
        return addresse;
    }
    
    public void newPlads(int antal) {
        int i = 0;
        while (i < antal) {
            
            pladser.add(new Parkeringsplads(pladsNummer));
            pladsNummer++;
            i++;
        }

    }
    
    public ArrayList<Parkeringsplads> getPladser() {
        return pladser;
    }

    public double getSaldo() {
        return saldo;
    }

    public void addSaldo(double saldo) {
        this.saldo += saldo;
    }

    /**
     * Finder antal ledige pladser
     */
    public int antalLedigePladser() {
        int isEmpty = 0;
        for (Parkeringsplads p : pladser) {
            if (p.getBil() == null) {
                isEmpty++;
            }
        }
        return isEmpty;
    }
    
    public ArrayList<Parkeringsplads> getLedigePladser() {
        ArrayList<Parkeringsplads> ledigListe = new ArrayList<>();
        for (Parkeringsplads p : pladser) {
            if (p.getBil() == null) {
                ledigListe.add(p);
            }
        }
        return ledigListe;
    }
    
    /**
     * @param regNr
     * Finder parkeringspladsnummer på bilen med registreringsnummer regNr, hvis findes
     */
    public int findBil(String regNr) {
        boolean found = false;
        int i = 0;
        int nummer = -1;
        while (!found && i < pladser.size()) {
            if (pladser.get(i).getBil() != null) {
                if (pladser.get(i).getBil().getRegNr().equalsIgnoreCase(regNr)) {
                    nummer = pladser.get(i).getNummer();
                    found = true;
                }
            }
            else {
                i++;
            }
        }

        return nummer;
        
    }

    @Override
    public String toString() {
        return addresse + " (" + (antalLedigePladser()) + " pladser, Saldo: " + saldo + ")";
    }

}
