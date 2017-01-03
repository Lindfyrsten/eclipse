package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Kristian Lindbjerg
 */
public class Bolig {
    private double kvm, prisPrMaaned;
    private String adresse;
    private Kollegie kollegie;
    private ArrayList<Lejeaftale> lejeaftaler = new ArrayList<>();

    public Bolig(String adresse, double kvm, double prisPrMaaned, Kollegie kollegie) {
        this.adresse = adresse;
        this.kvm = kvm;
        this.prisPrMaaned = prisPrMaaned;
        this.kollegie = kollegie;
        kollegie.addBolig(this);
    }
    
    public double getKvm() {
        return kvm;
    }
    
    public void setKvm(double kvm) {
        this.kvm = kvm;
    }
    
    public double getPrisPrMaaned() {
        return prisPrMaaned;
    }
    
    public void setPrisPrMaaned(double prisPrMaaned) {
        this.prisPrMaaned = prisPrMaaned;
    }
    
    public String getAdresse() {
        return adresse;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    public void setKollegie(Kollegie kollegie) {
        Kollegie oldKollegie = this.kollegie;
        this.kollegie = kollegie;
        if (oldKollegie != null) {
            oldKollegie.removeBolig(this);
        }
        if (kollegie != null && !kollegie.getBoliger().contains(this)) {
            kollegie.addBolig(this);
        }
        
    }

    public Kollegie getKollegie() {
        return kollegie;
    }
    
    public ArrayList<Lejeaftale> getLejeaftaler() {
        return new ArrayList<>(lejeaftaler);
    }
    
    public Lejeaftale createLejeaftale(LocalDate fraDato) {
        Lejeaftale lejeaftale = new Lejeaftale(fraDato);
        try {
            
            lejeaftaler.add(lejeaftale);
        }
        catch (RuntimeException e) {
            System.out.println("Allerede en lejeaftale på datoen");
            
        }
        return lejeaftale;
    }
    
    public void deleteLejeaftale(Lejeaftale lejeaftale) {
        lejeaftaler.remove(lejeaftale);
    }
    
}
