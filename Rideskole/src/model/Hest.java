package model;

import java.time.LocalDate;

public class Hest {
    private String navn;
    private int fødselsaar;

    public Hest(String navn, int fødselsaar) {
        this.navn = navn;
        this.fødselsaar = fødselsaar;
    }
    
    public String getNavn() {
        return navn;
    }
    
    public int getFødselsaar() {
        return fødselsaar;
    }

    public int getAlder() {
        return LocalDate.now().getYear() - fødselsaar;
    }
    
    @Override
    public String toString() {
        return navn + " " + fødselsaar;
    }
}
