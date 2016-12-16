package application.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;

import application.model.Bil;
import application.model.Parkeringshus;
import application.model.Parkeringsplads;
import storage.Storage;

public class Service {
    public static void opretParkeringshus(String addresse) {
        Storage.addParkeringshus(new Parkeringshus(addresse));
    }

    public static Bil opretBil(String regNr, String model) {
        Bil b = new Bil(regNr, model);
        if (!Storage.getBiler().contains(b)) {

            Storage.addBil(new Bil(regNr, model));
        }
        return b;
    }

    public static void opretPlads(Parkeringshus hus, int antal) {
        hus.newPlads(antal);
    }

    public static ArrayList<Bil> getBiler() {
        return Storage.getBiler();
    }

    public static ArrayList<Parkeringshus> getParkeringshuse() {
        return Storage.getParkeringshuse();
    }

    public static void nyParkering(Parkeringsplads p, Bil bil, LocalTime ankomst) {
        p.nyParkering(bil, ankomst);
    }
    
    public static double afleverBil(Parkeringsplads p, LocalTime afgang) {
        return p.hentBil(afgang);
    }

    /**
     * @param hus
     * @param filnavn
     * Udskriver parkeringshusets optagne pladser til text fil
     */
    public static void writeOptagnePladser(Parkeringshus hus, String filnavn) {
        File optagetPladser = new File("optagetPladser.txt");
        try {
            PrintWriter printWriter = new PrintWriter(optagetPladser);
            
            for (Parkeringsplads p : hus.getPladser()) {
                if (p.getBil() != null) {
                    
                    printWriter.println("Nummer: " + p.getNummer() + "| Registreringsnummer: "
                        + p.getBil().getRegNr() + "| Ankomst : " + p.getAnkomst());
                }
            }
            printWriter.flush();
            printWriter.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param hus
     * @return
     * Henter parkeringshusets optagede pladser
     */
    public static ArrayList<Parkeringsplads> getOptagnePladser(Parkeringshus hus) {
        ArrayList<Parkeringsplads> optagnePladser = new ArrayList<>();
        for (Parkeringsplads p : hus.getPladser()) {
            if (p.getBil() != null) {
                optagnePladser.add(p);
            }
        }
        return optagnePladser;
    }
    
    public static void init() {
        Parkeringshus p1 = new Parkeringshus("Langenaes 21");
        Parkeringshus p2 = new Parkeringshus("Kystvejen 15");
        Bil b1 = new Bil("FEWJIFJ-32", "Audi");
        Bil b2 = new Bil("FJFVASS-Y4", "Skoda");
        Bil b3 = new Bil("OPEWASd-GD", "Mazda");
        Bil b4 = new Bil("EWETVSD-32", "Ford");
        Storage.addBil(b1);
        Storage.addBil(b2);
        Storage.addBil(b3);
        Storage.addBil(b4);
        Storage.addParkeringshus(p1);
        Storage.addParkeringshus(p2);
        opretPlads(p1, 20);
        opretPlads(p2, 10);

        nyParkering(p1.getPladser().get(5), b1, LocalTime.now().minusMinutes(50));
        nyParkering(p2.getPladser().get(0), b2, LocalTime.now().minusHours(2));
        nyParkering(p1.getPladser().get(0), b3, LocalTime.now().minusMinutes(15));
        nyParkering(p1.getPladser().get(1), b4, LocalTime.now().minusHours(5));
        
    }
}
