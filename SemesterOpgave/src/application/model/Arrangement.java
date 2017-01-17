package application.model;

import java.time.LocalTime;

/**
 * @author Kristian Lindbjerg
 */
public class Arrangement {
    private String beskrivelse;
    private double pris;
    private LocalTime startTid, slutTid;
    private Kategori kategori;

    public Arrangement(String beskrivelse, double pris, LocalTime startTid, LocalTime slutTid,
        Kategori kategori) {
        this.beskrivelse = beskrivelse;
        this.pris = pris;
        this.startTid = startTid;
        this.slutTid = slutTid;
        this.kategori = kategori;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public double getPris() {
        return pris;
    }

    public LocalTime getStartTid() {
        return startTid;
    }

    public LocalTime getSlutTid() {
        return slutTid;
    }
    
    public Kategori getKategori() {
        return kategori;
    }
    
}
