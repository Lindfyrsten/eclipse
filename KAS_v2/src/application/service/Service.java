package application.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import application.model.Deltager;
import application.model.Firma;
import application.model.Hotel;
import application.model.HotelTilvalg;
import application.model.Konference;
import application.model.Tilmeldning;
import application.model.Udflugt;
import storage.Storage;

/**
 * @author Kristian
 */
public class Service {

    /**
     * Opretter ny konference
     * @param titel
     * @param pris
     * @param startDate
     * @param slutDate
     * @return
     */
    public static Konference createKonference(String titel, double pris) {
        Konference konference = new Konference(titel, pris);
        Storage.addKonference(konference);
        return konference;
    }
    
    /**
     * Sletter konferencen
     * @param konference
     */
    public static void deleteKonference(Konference konference) {
        Storage.removeKonference(konference);
    }
    
    /**
     * Opdaterer konferencen
     * @param konference
     * @param titel
     * @param pris
     * @param startDate
     * @param slutDate
     */
    public static void updateKonference(Konference konference, String titel, double pris,
        LocalDate startDate, LocalDate slutDate) {
        konference.setTitel(titel);
        konference.setPris(pris);
        konference.setStartDate(startDate);
        konference.setSlutDate(slutDate);
    }

    /**
     * Henter alle konferencerne
     * @return
     */
    public static ArrayList<Konference> getKonference() {
        return Storage.getKonferencer();
    }

    /**
     * Opretter ny deltager
     * @param name
     * @param alder
     * @return
     */
    public static Deltager createDeltager(String name, int alder, String addresse,
        String nationalitet) {
        Deltager deltager = new Deltager(name, alder, addresse, nationalitet);
        Storage.addDeltager(deltager);
        return deltager;
    }
    
    /**
     * Sletter deltageren
     * @param deltager
     */
    public static void deleteDeltager(Deltager deltager) {

        Storage.removeDeltager(deltager);
    }
    
    public static void addTilmeldning(Tilmeldning tildmeldning, Konference konference) {
        konference.addDeltager(tildmeldning);
    }
    
    /**
     * Opdaterer deltager
     * @param deltager
     * @param name
     * @param alder
     */
    public static void updateDeltager(Deltager deltager, String name, int alder) {
        deltager.setNavn(name);
        deltager.setAlder(alder);
    }
    
    /**
     * Henter deltagere
     * @return
     */
    public static ArrayList<Deltager> getDeltagere() {
        return Storage.getDeltagere();
    }
    
    /**
     * Opretter nyt firma
     * @param navn
     * @param tlfNr
     * @param addresse
     * @return
     */
    public static Firma createFirma(String navn, int tlfNr, String addresse) {
        Firma firma = new Firma(navn, tlfNr, addresse);
        Storage.addFirma(firma);
        return firma;
    }

    /**
     * Sletter firma
     * @param firma
     */
    public static void deleteFirma(Firma firma) {
        Storage.removeFirma(firma);
    }

    /**
     * Opdater firma
     * @param firma
     * @param navn
     * @param tlfNr
     * @param addresse
     */
    public static void updateFirma(Firma firma, String navn, int tlfNr, String addresse) {
        firma.setNavn(navn);
        firma.setTlfNummer(tlfNr);
        firma.setAddresse(addresse);
    }
    
    /**
     * Henter alle firmaer
     * @return
     */
    public static ArrayList<Firma> getFirmaer() {
        return Storage.getFirmaer();
    }

    /**
     * Opretter hotel
     * @param navn
     * @param addresse
     * @return
     */
    public static Hotel createHotel(String navn, String addresse, double enkelt, double dobbelt) {
        Hotel hotel = new Hotel(navn, addresse, enkelt, dobbelt);
        Storage.addHotel(hotel);
        return hotel;
    }
    
    /**
     * Sletter hotel
     * @param hotel
     */
    public static void deleteHotel(Hotel hotel) {
        Storage.removeHotel(hotel);
    }

    /**
     * Opdaterer hotel
     * @param hotel
     * @param navn
     * @param addresse
     * @param rooms
     */
    public static void updateHotel(Hotel hotel, String navn, String addresse, double enkelt,
        double dobbelt) {
        hotel.setNavn(navn);
        hotel.setAddresse(addresse);
        hotel.setDagsPrisEnkelt(enkelt);
        hotel.setDagsPrisDobbelt(dobbelt);
    }
    
    public static ArrayList<Hotel> getHotels() {
        return Storage.getHoteller();
    }
    
    /**
     * Opretter nyt tilvalg
     * @param navn
     * @param dagsPris
     * @return
     */
    public static HotelTilvalg createTilvalg(String navn, int dagsPris) {
        HotelTilvalg tv = new HotelTilvalg(navn, dagsPris);
        Storage.addTilvalg(tv);
        return tv;
        
    }

    /**
     * Sletter tilvalg
     * @param tv
     */
    public static void removeTilvalg(HotelTilvalg tv) {
        Storage.removeTilvalg(tv);
    }
    
    /**
     * Opdaterer tilvalget
     * @param tv
     * @param navn
     * @param dagsPris
     */
    public static void updateTilvalg(HotelTilvalg tv, String navn, int dagsPris) {
        tv.setNavn(navn);
        tv.setDagsPris(dagsPris);
    }
    
    // -------------------------------------------------------------------------
    
    /**
     * Opretter udflugt
     * @param navn
     * @param pris
     * @param date
     * @return
     */
    public static Udflugt createUdflugt(String navn, double pris, LocalDateTime date) {
        Udflugt udflugt = new Udflugt(navn, pris, date);
        Storage.addUdflugt(udflugt);
        return udflugt;
    }
    
    /**
     * Sletter udflugt
     * @param udflugt
     */
    public static void removeUdflugt(Udflugt udflugt) {
        Storage.removeUdflugt(udflugt);
    }

    /**
     * Opdaterer udflugt
     * @param udflugt
     * @param navn
     * @param pris
     * @param date
     */
    public static void updateUdflugt(Udflugt udflugt, String navn, double pris,
        LocalDateTime date) {
        udflugt.setNavn(navn);
        udflugt.setPris(pris);
        udflugt.setDato(date);
    }

    public static String getOvernatninger(Hotel hotel) {
        String output = "";
        for (Deltager d : Storage.getDeltagere()) {
            for (Tilmeldning t : d.getTilmeldninger()) {
                if (t.getHotel() == hotel) {
                    output = output + d.getNavn();
                    if (t.getLedsagernavn() != null) {
                        output = output + " (" + t.getLedsagernavn() + ")";
                    }
                    for (HotelTilvalg tv : t.getTilvalg()) {
                        output = output + " " + tv.getNavn();
                    }
                    output = output + t.getStart().toString() + " " + t.getSlut().toString() + "\n";
                }
            }
        }
        return output;
    }

    /**
     * Initializes the storage with some objects.
     */
    public static void initStorage() {
        Konference k1 = Service.createKonference("Klima ændring", 250);
        Konference k2 = Service.createKonference("Nano teknologi", 499);
        Service.createHotel("Radison", "blabla2", 150, 250);
        Service.createHotel("Ez living", "Dada 12", 99, 150);
        
        Service.createDeltager("Bob", 19, "Dalgas Avenue 21", "Danmark");
        Service.createDeltager("Finn", 50, "Boulevarden 16", "Norge");
        Service.createDeltager("Peter", 54, "Green Street 192", "USA");
        
    }

    public static void init() {

        initStorage();

    }
}
