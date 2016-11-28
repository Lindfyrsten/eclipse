package application.model;

public class PrisGruppe {
    private char gruppe;
    private double prisPrDag, prisPrTime, prisPrKm;
//    private ArrayList<Bil> biler = new ArrayList<>();

    public PrisGruppe(char gruppe, double prisPrTime, double prisPrDag, double prisPrKm) {
        this.gruppe = gruppe;
        this.prisPrTime = prisPrTime;
        this.prisPrDag = prisPrDag;
        this.prisPrKm = prisPrKm;
    }
    
    public char getGruppe() {
        return gruppe;
    }
    
    public void setGruppe(char gruppe) {
        this.gruppe = gruppe;
    }
    
    public double getPrisPrDag() {
        return prisPrDag;
    }
    
    public void setPrisPrDag(double prisPrDag) {
        this.prisPrDag = prisPrDag;
    }
    
    public double getPrisPrTime() {
        return prisPrTime;
    }
    
    public void setPrisPrTime(double prisPrTime) {
        this.prisPrTime = prisPrTime;
    }
    
    public double getPrisPrKm() {
        return prisPrKm;
    }
    
    public void setPrisPrKm(double prisPrKm) {
        this.prisPrKm = prisPrKm;
    }

}
