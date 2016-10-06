package konto;

public class Konto {

    private int nr;
    private int saldo;
    private String kontotype;
    
    public Konto(String kontotype, int nr) {
        
        this.kontotype = kontotype;
        this.nr = nr;
    }
    
    public void indsætBeløb(int beløb) {
        saldo = saldo + beløb;
    }

    public int getSaldo() {
        return this.saldo;
    }
    
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getNr() {
        return this.nr;
    }
    
    public String getKontotype() {
        return this.kontotype;
    }

    public void checkBalance() {
        System.out.println("*****************************");
        System.out.println("Kontotype: " + getKontotype());
        System.out.println("Kontonummer: " + getNr());
        System.out.println("Saldo :" + getSaldo());
        System.out.println("*****************************");
    }
    
}
