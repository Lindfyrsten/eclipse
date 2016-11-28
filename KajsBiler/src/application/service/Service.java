package application.service;

import java.time.LocalDate;
import java.util.ArrayList;

import application.model.Bil;
import application.model.Kunde;
import application.model.Udlejning;
import storage.Storage;

public class Service {
    public static Kunde createKunde(String navn, String addresse, int tlfNr, int kørekortNr) {
        Kunde kunde = new Kunde(navn, addresse, tlfNr, kørekortNr);
        Storage.addKunde(kunde);
        return kunde;

    }

    public static Bil createBil(String regNr, String mærke, String model, double kmKørt) {
        Bil bil = new Bil(regNr, mærke, model, kmKørt);
        Storage.addBil(bil);
        return bil;
        
    }
    
    public static Udlejning createUdlejning(Bil bil, LocalDate startDate, LocalDate slutDate) {
        Udlejning udlejning = new Udlejning(bil, startDate, slutDate);
        Storage.addUdlejning(udlejning);
        bil.setUdlejet(true);
        
        return udlejning;
    }
    
    public static void afleverBil(Udlejning udlejning) {
        if (LocalDate.now().isAfter(udlejning.getSlutDate())) {
            
        }
        udlejning.getBil().setUdlejet(false);
        
    }

    public static ArrayList<Bil> getBiler() {
        return Storage.getBiler();
    }
    
    public static ArrayList<Kunde> getKunder() {
        return Storage.getKunder();
    }

    public static ArrayList<Udlejning> getUdlejninger() {
        return Storage.getUdlejninger();
    }
    
    public static void deleteBil(Bil bil) {

        Storage.removeBil(bil);

    }

    public static void updateBil(Bil bil, String regNr, String mærke, String model, int kmKørt) {
        bil.setRegNr(regNr);
        bil.setMærke(mærke);
        bil.setModel(model);
        bil.setKmKørt(kmKørt);
    }
    
    public static void opretStartBiler() {
        createBil("YX-126-233", "Ford", "Extreme", 50000);
        createBil("EW-230-111", "Mazda", "Fire", 125000);
        createBil("FA-902-123", "Opel", "Kadett", 500000);
        createBil("OA-032-32J", "Lamborghini", "Gallardo", 10000);
        
    }
    
}
