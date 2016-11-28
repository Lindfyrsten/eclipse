package application.model;

public class Bil implements Comparable<Bil> {
    private double kmKørt;
    private String regNr, mærke, model;
    private boolean udlejet = false;

    public Bil(String regNr, String mærke, String model, double kmKørt) {
        this.regNr = regNr;
        this.mærke = mærke;
        this.model = model;
        this.kmKørt = kmKørt;

    }
    
    public double getKmKørt() {
        return kmKørt;
    }
    
    public void setKmKørt(double kmKørt) {
        this.kmKørt = kmKørt;
    }
    
    public String getRegNr() {
        return regNr;
    }
    
    public void setRegNr(String regNr) {
        this.regNr = regNr;
    }
    
    public String getMærke() {
        return mærke;
    }
    
    public void setMærke(String mærke) {
        this.mærke = mærke;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public void setUdlejet(boolean udlejet) {
        this.udlejet = udlejet;
    }
    
    public boolean isUdlejet() {
        return udlejet;
    }
    
    @Override
    public String toString() {
        return mærke + " " + model;
    }
    
    @Override
    public int compareTo(Bil bil) {
        if (getMærke().compareTo(bil.getMærke()) == 0) {
            return getModel().compareTo(bil.getModel());
        }
        else {
            
            return getMærke().compareTo(bil.getMærke());
        }

    }
    
}
