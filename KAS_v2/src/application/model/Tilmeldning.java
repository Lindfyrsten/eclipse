package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tilmeldning {
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
    private LocalDate start;
    private LocalDate slut;
    
    // ===========================================================
    // Constructors
    // ===========================================================
    
    public Tilmeldning(Deltager deltager, Konference konference, LocalDate start, LocalDate slut) {
        this.start = start;
        this.slut = slut;
        this.deltager = deltager;
        this.konference = konference;
        deltager.addTilmeldning(this);
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
    
    public ArrayList<Udflugt> getUdflugter() {
        return udflugter;
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
        if (!foredragsholder) {
            sum += konference.getPris();
        }
        if (hotel != null) {
            if (ledsagernavn.isEmpty()) {
                sum += hotel.getDagsPrisEnkelt();
            }
            else {
                sum += hotel.getDagsPrisDobbelt();
            }
            for (HotelTilvalg tv : tilvalg) {
                sum += tv.getDagsPris();
            }
        }
        sum = sum * slut.compareTo(start); // alle ovenstående priser er dagspriser.

        for (Udflugt u : udflugter) {
            sum += u.getPris();
        }
        return sum;
    }
    
    public void clearDeltager() {
        this.hotel = null;
        this.udflugter.clear();
        this.tilvalg.clear();
        this.konference = null;
    }
    
    public ArrayList<HotelTilvalg> getTilvalg() {
        return tilvalg;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getSlut() {
        return slut;
    }
}
