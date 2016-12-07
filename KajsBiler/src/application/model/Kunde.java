package application.model;

import java.util.ArrayList;

public class Kunde implements Comparable<Kunde> {
    private String navn, addresse, kørekortNr;
    private int tlfNr, alder;
    private boolean erhvervskunde;
    private ArrayList<Udlejning> udlejninger = new ArrayList<>();

    public Kunde(String navn, String addresse, int alder, int tlfNr, String kørekortNr) {
        this.navn = navn;
        this.addresse = addresse;
        this.tlfNr = tlfNr;
        this.kørekortNr = kørekortNr;
    }
    
    public int getTelefonnr() {
        return tlfNr;
    }
    
    public void setTelefonnr(int tlfNr) {
        this.tlfNr = tlfNr;
    }
    
    public boolean isErhvervskunde() {
        return erhvervskunde;
    }
    
    public void setErhvervskunde(boolean erhvervskunde) {
        this.erhvervskunde = erhvervskunde;
    }
    
    public String getNavn() {
        return navn;
    }
    
    public int getAlder() {
        return alder;
    }
    
    public String getAddresse() {
        return addresse;
    }
    
    public String getKørekortnr() {
        return kørekortNr;
    }
    
    public void addUdlejning(Udlejning udlejning) {
        udlejninger.add(udlejning);
    }
    
    public ArrayList<Udlejning> getUdlejninger() {
        return new ArrayList<>(udlejninger);
    }

    @Override
    public int compareTo(Kunde k) {
        
        return getNavn().compareTo(k.getNavn());
    }
    
    @Override
    public String toString() {
        return navn;
    }
    
}
