package application.model;

public class Bil {

    private String regNr, model;

    public Bil(String regNr, String model) {
        this.regNr = regNr;
        this.model = model;
    }

    public String getRegNr() {
        return regNr;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return regNr + ", " + model;
    }
}
