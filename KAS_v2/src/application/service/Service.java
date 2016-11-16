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
    
    public static Konference createKonference(String titel, double pris, LocalDate startDate,
        LocalDate slutDate, LocalDate frist) {
        Konference konference = new Konference(titel, pris, startDate, slutDate, frist);
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
        LocalDate startDate, LocalDate slutDate, LocalDate frist) {
        konference.setTitel(titel);
        konference.setPris(pris);
        konference.setStartDate(startDate);
        konference.setSlutDate(slutDate);
        konference.setTilmeldningsfrist(frist);
    }

    public static void updateKonference(Konference konference, String titel, double pris) {
        konference.setTitel(titel);
        konference.setPris(pris);
    }

    /**
     * Henter alle konferencerne
     * @return
     */
    public static ArrayList<Konference> getKonferencer() {
        return Storage.getKonferencer();
    }
    
    public static ArrayList<Konference> tilgængeligeKonferencer() {
        ArrayList<Konference> konf = new ArrayList<>();
        for (Konference k : Storage.getKonferencer()) {
            if (k.getStartDate() != null && k.getStartDate().isAfter(LocalDate.now())) {
                konf.add(k);
            }
        }
        return konf;

    }

//    public static void addTilmeldning(Tilmeldning tilmeldning, String ledsager,
//    }
    
    /**
     * Opretter ny deltager
     * @param name
     * @param alder
     * @return
     */
    public static Deltager createDeltager(String name, int alder, String addresse,
        String land, int tlfNr) {
        Deltager deltager = new Deltager(name, alder, addresse, land, tlfNr);
        
        if (!Storage.getDeltagere().contains(deltager)) {
            Storage.addDeltager(deltager);
        }
        return deltager;
    }
    
    /**
     * Sletter deltageren
     * @param deltager
     */
    public static void deleteDeltager(Deltager deltager) {

        Storage.removeDeltager(deltager);
    }
    
    /**
     * Opdaterer deltager
     * @param deltager
     * @param name
     * @param alder
     */
    public static void updateDeltager(Deltager deltager, String name, int alder, String addresse,
        String land, int tlfNr) {
        deltager.setNavn(name);
        deltager.setAlder(alder);
        deltager.setAddresse(addresse);
        deltager.setLand(land);
        deltager.setTlfNr(tlfNr);
        
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
    public static Hotel createHotel(String navn, String addresse, double enkelt, double dobbelt,
        ArrayList<HotelTilvalg> tilvalg) {
        Hotel hotel = new Hotel(navn, addresse, enkelt, dobbelt, tilvalg);
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
        double dobbelt, ArrayList<HotelTilvalg> tilvalg) {
        hotel.setNavn(navn);
        hotel.setAddresse(addresse);
        hotel.setDagsPrisEnkelt(enkelt);
        hotel.setDagsPrisDobbelt(dobbelt);
        hotel.setTilvalg(tilvalg);
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
    public static HotelTilvalg createTilvalg(String navn, double dagsPris) {
        HotelTilvalg tv = new HotelTilvalg(navn, dagsPris);
        return tv;

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
                    output =
                        output + " (" + t.getStart().toString() + " - " + t.getSlut().toString()
                            + ") \n";
                }
            }
        }
        return output;
    }

    public static Deltager findDeltager(String tlfNr) {
        Deltager deltager = null;
        int i = 0;
        boolean keepSearching = true;
        while (keepSearching && i < Storage.getDeltagere().size()) {
            if (Integer.toString(Storage.getDeltagere().get(i).getTlfNr()).equals(tlfNr)) {
                deltager = Storage.getDeltagere().get(i);
                keepSearching = false;
            }
            i++;
        }
        return deltager;
    }

    /**
     * Initializes the storage with some objects.
     */
    public static void initStorage() {
        
        ArrayList<HotelTilvalg> tilvalg = new ArrayList<>();
        
        Konference k1 = Service.createKonference("Klima ændring", 250);
        Konference k2 = Service.createKonference("Nano teknologi", 499);
        Konference k3 = Service.createKonference("Fremtidens energi", 799,
            LocalDate.of(2017, 01, 7), LocalDate.of(2017, 01, 9), LocalDate.of(2017, 01, 7));
        Service.createHotel("Radison", "blabla2", 150, 250, tilvalg);
        Service.createHotel("Ez living", "Dada 12", 99, 150, tilvalg);
        Tilmeldning t = new Tilmeldning("Bob", 19, "Dalgas Avenue 21", "Danmark", 1, k3,
            LocalDate.of(2017, 01, 9), LocalDate.of(2017, 01, 7), Storage.getHoteller().get(0));
//        Tilmeldning t =
        
        Service.createDeltager("Bob", 19, "Dalgas Avenue 21", "Danmark", 1);
        Service.createDeltager("Finn", 50, "Boulevarden 16", "Norge", 2);
//        Service.createDeltager("Peter", 54, "Green Street 192", "USA", 3);
        System.out.println(Storage.getDeltagere());
        Storage.getDeltagere().get(1).addTilmeldning(t);
        
    }

    public static void init() {

        initStorage();

    }
}
