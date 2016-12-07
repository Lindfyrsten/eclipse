package application.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import application.model.Bil;
import application.model.Kunde;
import application.model.Udlejning;
import storage.Storage;

public class Service {
    public static Kunde createKunde(Kunde kunde) {
        Storage.addKunde(kunde);
        return kunde;

    }

    public static Bil createBil(String regNr, String mærke, String model, double kmKørt) {
        Bil bil = new Bil(regNr, mærke, model, kmKørt);
        Storage.addBil(bil);
        return bil;
        
    }
    
    public static Udlejning createUdlejning(Bil bil, LocalDate startDate, LocalDate slutDate,
        Kunde kunde) {
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

    public static ArrayList<Kunde> kundeValg() {
        ArrayList<Kunde> choices = new ArrayList<>();
        for (Kunde k : getKunder()) {
            choices.add(k);
        }
        Collections.sort(choices);
        return choices;
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

    public static Kunde findKunde(String tlfNr) {
        if (tlfNr.length() > 0) {
            
            Kunde kunde = null;
            int i = 0;
            boolean keepSearching = true;
            while (keepSearching && i < Storage.getKunder().size()) {
                if (Integer.toString(Storage.getKunder().get(i).getTelefonnr()).equals(tlfNr)) {
                    kunde = Storage.getKunder().get(i);
                    keepSearching = false;
                }
                i++;
            }
            
            return kunde;
        }
        else {
            return null;
        }
    }
    
}
