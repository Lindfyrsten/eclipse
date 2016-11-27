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
        return udlejning;
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
    
}
