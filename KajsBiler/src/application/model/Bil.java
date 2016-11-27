package application.model;

public class Bil {
    private double kmKørt;
    private String regNr, mærke, model, status;
    
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return mærke + " " + model;
    }

}
