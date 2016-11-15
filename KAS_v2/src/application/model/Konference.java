package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {
    // ===========================================================
    // Fields
    // ===========================================================
    private String titel;
    private LocalDate startDate;
    private LocalDate slutDate;
    private double pris;
    private LocalDate tilmeldningsfrist;
    private ArrayList<Hotel> hoteller = new ArrayList<>();
    private ArrayList<Tilmeldning> tilmeldninger = new ArrayList<>();
    private ArrayList<Udflugt> udflugter = new ArrayList<>();
    
    // ===========================================================
    // Constructors
    // ===========================================================
    public Konference(String titel, double pris) {
        this.titel = titel;
        this.pris = pris;
    }

    public Konference(String titel, double pris, LocalDate startDate, LocalDate slutDate,
        LocalDate tilmeldningsfrist) {
        this.titel = titel;
        this.pris = pris;
        this.startDate = startDate;
        this.slutDate = slutDate;
        this.tilmeldningsfrist = tilmeldningsfrist;

    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getSlutDate() {
        return slutDate;
    }

    public void setSlutDate(LocalDate slutDate) {
        this.slutDate = slutDate;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public LocalDate getTilmeldningsfrist() {
        return tilmeldningsfrist;
    }

    public void setTilmeldningsfrist(LocalDate tilmeldningsfrist) {
        this.tilmeldningsfrist = tilmeldningsfrist;
    }

    public ArrayList<Hotel> getHoteller() {
        return hoteller;
    }
    
    public ArrayList<Udflugt> getUdflugter() {
        return udflugter;
    }

    @Override
    public String toString() {
        return titel + " (" + pris + " kr)";
    }

    public ArrayList<Tilmeldning> getTilmeldninger() {
        return new ArrayList<>(tilmeldninger);
    }

    public void addDeltager(Tilmeldning deltager) {
        tilmeldninger.add(deltager);
    }

    public void removeDeltager(Deltager deltager) {
        tilmeldninger.remove(deltager);

    }
    
    // ===========================================================
    // Methods
    // ===========================================================

    public String getUdflugtDeltager(Udflugt udflugt) {
        String output = "";
        for (Tilmeldning d : tilmeldninger) {
            if (d.getUdflugter().contains(udflugt)) {
                output = output + d.getLedsagernavn() + " (" + d.getDeltager().getNavn() + ")\n";
            }
        }
        return output;
    }
}
