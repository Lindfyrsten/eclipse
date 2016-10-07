package konto;

public class Spiller {

    private String navn;
    private int alder;
    private String position;
    private int guleKort;
    private int rødeKort;
    private boolean suspenderet;
    private boolean skadet;
    private int mål;
    
    public Spiller(String navn, int alder, String position) {
        
        guleKort = 0;
        rødeKort = 0;
        this.navn = navn;
        this.alder = alder;
        this.position = position;
    }
    
    public String getNavn() {
        return navn;
    }
    
    public void setNavn(String navn) {
        this.navn = navn;
    }
    
    public int getAlder() {
        return alder;
    }
    
    public void setAlder(int alder) {
        this.alder = alder;
    }
    
    public String getPosition() {
        return position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    
    public void kamp(int gul, int rød, int goal) {
        guleKort = guleKort + gul;
        rødeKort = rødeKort + rød;
        mål = mål + goal;
    }
    
    public void skade() {
        if (!skadet) {
            skadet = true;
        }
        else {
            skadet = false;
        }
    }

    public void suspend() {
        if (!suspenderet) {
            suspenderet = true;
        }
        else {
            suspenderet = false;
        }
    }
    
    public void spillerInfo() {
        System.out.println("*****************************");
        System.out.println("Spillernavn: " + navn);
        System.out.println("Alder: " + alder);
        System.out.println("Position: " + position);
        System.out.println("Mål: " + mål);
        System.out.println("Gule kort: " + guleKort);
        System.out.println("Røde kort: " + rødeKort);
        System.out.println("Skadet: " + skadet);
        System.out.println("Suspenderet: " + suspenderet);
        System.out.println("*****************************");
    }
}
