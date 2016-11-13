package application.model;

import java.util.ArrayList;

public class Deltagelse {
    // ===========================================================
    // Fields
    // ===========================================================
    private boolean foredragsholder = false;
    private String ledsagernavn;
//    private LocalDate period;
    private Hotel hotel;
    private Konference konference;
    private Deltager deltager;
    private ArrayList<HotelTilvalg> tilvalg = new ArrayList<>();
    private ArrayList<Udflugt> udflugter = new ArrayList<>();
    
    // ===========================================================
    // Constructors
    // ===========================================================
    
    public Deltagelse(Deltager deltager, Konference konference) {
        this.deltager = deltager;
        this.konference = konference;
//        this.period = period;
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================
    
    public boolean isForedragsholder() {
        return foredragsholder;
    }
    
    public void setForedragsholder(boolean foredragsholder) {
        this.foredragsholder = foredragsholder;
    }
    
    public String getLedsagernavn() {
        return ledsagernavn;
    }
    
    public void setLedsagernavn(String ledsagernavn) {
        this.ledsagernavn = ledsagernavn;
    }
    
//    public LocalDate getPeriod() {
//        return period;
//    }
//
//    public void setPeriod(LocalDate period) {
//        this.period = period;
//    }
    
    public Hotel getHotel() {
        return hotel;
    }
    
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    
    public Konference getKonference() {
        return konference;
    }
    
    public void setKonference(Konference konference) {
        this.konference = konference;
    }
    
    public Deltager getDeltager() {
        return deltager;
    }

    // ===========================================================
    // Methods
    // ===========================================================
    public void addTilvalg(HotelTilvalg tv) {
        tilvalg.add(tv);
    }

    public void addUdflugt(Udflugt uf) {
        udflugter.add(uf);
    }

    public double samletPris() {
        double sum = 0;
        
        return sum;
    }
    
    public void clearDeltager() {
        this.hotel = null;
        this.udflugter.clear();
        this.tilvalg.clear();
        this.konference = null;
    }
}
