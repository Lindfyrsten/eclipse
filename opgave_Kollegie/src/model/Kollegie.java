package model;

import java.time.Period;
import java.util.ArrayList;

public class Kollegie {
    private String navn, adresse;
    private ArrayList<Bolig> boliger = new ArrayList<>();
    
    public Kollegie(String navn, String adresse) {
        this.navn = navn;
        this.adresse = adresse;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
    
    public String getNavn() {
        return navn;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    public String getAdresse() {
        return adresse;
    }
    
    public ArrayList<Bolig> getBoliger() {
        return new ArrayList<>(boliger);
    }

    public Bolig createBolig(String adresse, double kvm, double prisPrMaaned) {
        Bolig bolig = new Bolig(adresse, kvm, prisPrMaaned, this);
        return bolig;
    }

    public void addBolig(Bolig bolig) {
        boliger.add(bolig);
        if (bolig.getKollegie() != this) {
            bolig.setKollegie(this);
        }
    }
    
    public void removeBolig(Bolig bolig) {
        if (bolig.getKollegie() == this) {
            bolig.setKollegie(null);
        }
    }

    public int getAntalLejeAftaler() {
        int sum = 0;
        for (Bolig b : getBoliger()) {
            sum += b.getLejeaftaler().size();
        }
        return sum;
    }

    public double gennemsnitligeAntalDage() {
        int antal = 0;
        int dage = 0;

        for (Bolig b : getBoliger()) {
            for (Lejeaftale l : b.getLejeaftaler()) {
                if (l.getTilDato() != null && l.getFraDato() != null) {
                    antal++;
                    dage += Period.between(l.getTilDato(), l.getFraDato()).getDays();
                }
            }
        }
        return dage / antal;
    }
}
