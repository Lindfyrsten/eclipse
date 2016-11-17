package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

import application.service.Service;

public class Tilmeldning {
    // ===========================================================
    // Fields
    // ===========================================================
    private String ledsagernavn;
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
    
    public Tilmeldning(String navn, int alder, String addresse, String land, int tlfNr,
        Konference konference, Hotel hotel,
        ArrayList<HotelTilvalg> tilvalgValg, ArrayList<Udflugt> udflugtValg, Firma firma) {
        this.deltager = Service.createDeltager(navn, alder, addresse, land, tlfNr, firma);
        this.konference = konference;
        this.hotel = hotel;
        this.tilvalg = tilvalgValg;
        this.udflugter = udflugtValg;

    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================
    
    public String getLedsagernavn() {
        return ledsagernavn;
    }
    
    public void setLedsagernavn(String ledsagernavn) {
        this.ledsagernavn = ledsagernavn;
    }
    
    public Hotel getHotel() {
        return hotel;
    }
    
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    
    public Konference getKonference() {
        return konference;
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
