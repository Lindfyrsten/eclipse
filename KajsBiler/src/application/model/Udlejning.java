package application.model;

import java.time.LocalDate;

public class Udlejning {
    private int kontraktNr;
    private double depositum;
    private LocalDate startDate, slutDate;
    private Bil bil;
    private Kunde kunde;
    
    public Udlejning(Bil bil, LocalDate startDate, LocalDate slutDate) {
        this.bil = bil;
        this.startDate = startDate;
        this.slutDate = slutDate;
    }
    
    public int getKontraktNr() {
        return kontraktNr;
    }
    
    public void setKontraktNr(int kontraktNr) {
        this.kontraktNr = kontraktNr;
    }
    
    public LocalDate getStartDate() {
        return startDate;
    }
    
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    
    public LocalDate getSlutDate() {
        return slutDate;
    }
    
    public void setSlutDate(LocalDate slutDate) {
        this.slutDate = slutDate;
    }
    
    public Bil getBil() {
        return bil;
    }
    
    public void setBil(Bil bil) {
        this.bil = bil;
    }
    
    public double getDepositum() {
        return depositum;
    }
    
    public void nyUdlejning(Kunde kunde, Bil bil, LocalDate startDate, LocalDate slutDate) {
        
    }

}
