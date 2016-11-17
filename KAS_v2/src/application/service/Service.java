package application.service;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

import application.model.Deltager;
import application.model.Firma;
import application.model.Hotel;
import application.model.HotelTilvalg;
import application.model.Konference;
import application.model.Tilmeldning;
import application.model.Udflugt;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
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

    /**
     * Henter alle konferencer hvor tilmeldningsfristen ikke er overskredet
     * @return
     */
    public static ArrayList<Konference> tilgængeligeKonferencer() {
        
        ArrayList<Konference> konf = new ArrayList<>();
        for (Konference k : Storage.getKonferencer()) {
            if (k.getTilmeldningsfrist() != null
                && k.getTilmeldningsfrist().isAfter(LocalDate.now())) {
                konf.add(k);
            }
        }
        return konf;
        
    }

    /**
     * Udskriver dato perioden for konferencen i tekst form
     * @param konference
     * @return
     */
    public static String printKonferencePeriod(Konference konference) {
        String timePeriod = null;
        String startDay = "" + konference.getStartDate().getDayOfMonth();
        String startMonth =
            konference.getStartDate().getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        String startYear = "" + konference.getStartDate().getYear();
        String slutDay = "" + konference.getSlutDate().getDayOfMonth();
        String slutMonth =
            konference.getSlutDate().getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        String slutYear = "" + konference.getSlutDate().getYear();
        if (konference.getStartDate().getMonthValue() == konference.getSlutDate().getMonthValue()
            && startYear.equals(slutYear)) {
            timePeriod = startDay + ". til " + slutDay + ". " + startMonth + " " + startYear;
        }
        else
            if (startYear.equals(slutYear)) {
                timePeriod = startDay + ". " + startMonth + " til " + slutDay + ". " + slutMonth
                    + " " + startYear;
            }
            else {
                timePeriod = startDay + ". " + startMonth + " " + startYear + " til " + slutDay
                    + ". " + slutMonth
                    + " " + startYear;
            }
        return timePeriod;
    }
    
    /**
     * Udskriver tilmeldningsfristen i tekst form
     * @param konference
     * @return
     */
    public static String printTilmeldningsfrist(Konference konference) {
        String str = konference.getTilmeldningsfrist().getDayOfMonth() + ". " + konference
            .getTilmeldningsfrist().getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH) + " "
            + konference.getTilmeldningsfrist().getYear();
        return str;
    }

    public static double samletPris(boolean foredragsholder, Konference konference, Hotel hotel,
        boolean ledsager, ArrayList<HotelTilvalg> tilvalg, ArrayList<Udflugt> udflugter) {
        double sum = 0;
        int dage = konference.getSlutDate().getDayOfMonth()
            - konference.getStartDate().getDayOfMonth() + 1;
        if (!foredragsholder) {
            sum += konference.getPris();
        }
        if (hotel != null) {
            if (!ledsager) {
                sum += hotel.getDagsPrisEnkelt() * dage;
            }
            else {
                sum += hotel.getDagsPrisDobbelt() * dage;
            }

            if (!tilvalg.isEmpty()) {
                
                for (HotelTilvalg tv : tilvalg) {
                    sum += tv.getPris() * dage;
                }
            }
        }

        if (!udflugter.isEmpty() && ledsager) {

            for (Udflugt u : udflugter) {
                sum += u.getPris();
            }
        }
        return sum;
    }
    
    public static void addTilmedning(Tilmeldning tilmeldning) {
        Storage.addTilmeldning(tilmeldning);
    }

    public static ArrayList<Tilmeldning> getTilmeldninger() {
        return Storage.getTilmeldninger();
    }

    //----------------------------------------------------------

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
    
    public static Deltager createDeltager(String name, int alder, String addresse,
        String land, int tlfNr, Firma firma) {
        Deltager deltager = new Deltager(name, alder, addresse, land, tlfNr, firma);

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
     * Søger efter deltager med samme tlfNr
     * @param tlfNr
     * @return
     */
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

    //----------------------------------------------------------

    /**
     * Opretter nyt firma
     * @param navn
     * @param tlfNr
     * @param addresse
     * @return
     */
    public static Firma createFirma(String navn) {
        Firma firma = new Firma(navn);
        
        if (!Storage.getFirmaer().contains(firma)) {
            Storage.addFirma(firma);
            
        }
        return firma;
    }
    
    //----------------------------------------------------------
    
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

    /**
     * Henter alle oprettede hoteller
     * @return
     */
    public static ArrayList<Hotel> getHotels() {
        ArrayList<Hotel> list = new ArrayList<>();
        for (Hotel h : Storage.getHoteller()) {
            list.add(h);
        }
        return list;
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
    
    /**
     * Henter liste over deltagere der tilknyttet hotellet
     * @param hotel
     * @return
    */
    public static String getOvernatninger(Hotel hotel) {
        String output = "";
        
        for (Tilmeldning t : getTilmeldninger()) {
            if (t.getHotel() == hotel) {
                output = output + t.getDeltager().getNavn();
                if (t.getLedsagernavn() != null) {
                    output = output + " (" + t.getLedsagernavn() + ")";
                }
                for (HotelTilvalg tv : t.getTilvalg()) {
                    output = output + " " + tv.getNavn();
                }
                output =
                    output + " (" + t.getKonference().getStartDate().toString() + " - "
                        + t.getKonference().getSlutDate().toString()
                        + ") \n";
            }
        }
        
        return output;
    }
    
    // -------------------------------------------------------------------------

    /**
     * Opretter udflugt
     * @param navn
     * @param pris
     * @param date
     * @return
     */
    public static Udflugt createUdflugt(Konference konference, String navn, double pris,
        LocalDate date) {

        Udflugt udflugt = new Udflugt(navn, pris, date);
        konference.addUdflugt(udflugt);
        Storage.addUdflugt(udflugt);
        return udflugt;

    }

    /**
     * Sletter udflugt
     * @param udflugt
     */
    public static void removeUdflugt(Udflugt udflugt, Konference konference) {
        Storage.removeUdflugt(udflugt);
        konference.removeUdflugt(udflugt);
    }
    
    /**
     * Opdaterer udflugt
     * @param udflugt
     * @param navn
     * @param pris
     * @param date
     */
    public static void updateUdflugt(Udflugt udflugt, String navn, double pris,
        LocalDate date) {
        udflugt.setNavn(navn);
        udflugt.setPris(pris);
        udflugt.setDato(date);
    }

    public static ArrayList<Udflugt> getUdflugter(Konference konference) {
        return konference.getUdflugter();
    }
    
    public static void addUdflugt(Tilmeldning tilmeldning, Udflugt udflugt) {
        tilmeldning.addUdflugt(udflugt);
    }

    // -------------------------------------------------------------------------
    
    /**
     *
     * Gør alle datoer før startdate og slutdate utilgængelige i kalenderen
     * @param dpDate
     * @param startDate
     * @param slutDate
     * @return
     */
    public static DatePicker fjernDates(DatePicker dpDate, LocalDate startDate,
        LocalDate slutDate) {
        
        dpDate = new DatePicker(startDate);
        dpDate.setDayCellFactory((p) -> new DateCell() {
            @Override
            public void updateItem(LocalDate ld, boolean bln) {
                super.updateItem(ld, bln);
                setDisable(ld.isBefore(startDate) || ld.isAfter(slutDate));
            }
        });

        return dpDate;
    }

    /**
     * Initializes the storage with some objects.
     */
    public static void initStorage() {

        HotelTilvalg t1 = new HotelTilvalg("Mad", 20);
        HotelTilvalg t2 = new HotelTilvalg("Bad", 25);
        HotelTilvalg t3 = new HotelTilvalg("WiFi", 15);
        ArrayList<HotelTilvalg> tilvalg = new ArrayList<>();
        tilvalg.add(t1);
        tilvalg.add(t2);
        tilvalg.add(t3);

        createDeltager("Finn", 50, "Boulevarden 16", "Norge", 1);
        createDeltager("Kristian Lindbjerg", 29, "Langenæs Allé 21", "Danmark", 25480745);
        Konference k = createKonference("Klima ændring", 800, LocalDate.of(2016, 12, 14),
            LocalDate.of(2016, 12, 16), LocalDate.of(2016, 12, 1));
        k.addUdflugt(new Udflugt("Tur i zoo", 499, LocalDate.of(2016, 12, 15)));
        createKonference("Nano teknologi", 499);
        createHotel("Radison", "blabla2", 150, 250, tilvalg);
        createHotel("Ez living", "Dada 12", 99, 150, new ArrayList<>());

    }
    
    public static void init() {
        
        initStorage();
        
    }
}
