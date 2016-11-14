package storage;

import java.util.ArrayList;

import application.model.Deltager;
import application.model.Firma;
import application.model.Hotel;
import application.model.HotelTilvalg;
import application.model.Konference;
import application.model.Udflugt;

public class Storage {
    // ===========================================================
    // Fields
    // ===========================================================
    private static ArrayList<Konference> konferencer = new ArrayList<>();
    private static ArrayList<Deltager> deltagere = new ArrayList<>();
    private static ArrayList<Hotel> hoteller = new ArrayList<>();
    private static ArrayList<Firma> firmaer = new ArrayList<>();
    private static ArrayList<HotelTilvalg> tilvalg = new ArrayList<>();
    private static ArrayList<Udflugt> udflugter = new ArrayList<>();

    // ===========================================================
    public static ArrayList<Konference> getKonferencer() {
        return new ArrayList<>(konferencer);
    }

    public static void addKonference(Konference konference) {
        konferencer.add(konference);
    }

    public static void removeKonference(Konference konference) {
        konferencer.remove(konference);
    }

    // ===========================================================
    public static ArrayList<Deltager> getDeltagere() {
        return new ArrayList<>(deltagere);
    }
    
    public static void addDeltager(Deltager deltager) {
        deltagere.add(deltager);
    }
    
    public static void removeDeltager(Deltager deltager) {
        deltagere.remove(deltager);
    }
    
    // ===========================================================
    public static ArrayList<Hotel> getHoteller() {
        return new ArrayList<>(hoteller);
    }
    
    public static void addHotel(Hotel hotel) {
        hoteller.add(hotel);
    }
    
    public static void removeHotel(Hotel hotel) {
        hoteller.remove(hotel);
    }
    
    // ===========================================================
    public static ArrayList<Firma> getFirmaer() {
        return new ArrayList<>(firmaer);
    }
    
    public static void addFirma(Firma firma) {
        firmaer.add(firma);
    }
    
    public static void removeFirma(Firma firma) {
        firmaer.remove(firma);
    }
    // ===========================================================
    
    public static ArrayList<HotelTilvalg> getTilvalg() {
        return new ArrayList<>(tilvalg);
    }
    
    public static void addTilvalg(HotelTilvalg tv) {
        tilvalg.add(tv);
    }

    public static void removeTilvalg(HotelTilvalg tv) {
        tilvalg.remove(tv);
    }
    
    // ===========================================================
    public static ArrayList<Udflugt> getudflugter() {
        return new ArrayList<>(udflugter);
    }
    
    public static void addUdflugt(Udflugt udflugt) {
        udflugter.add(udflugt);
    }
    
    public static void removeUdflugt(Udflugt udflugt) {
        udflugter.remove(udflugt);
    }

}
