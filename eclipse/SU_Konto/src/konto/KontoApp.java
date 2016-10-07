package konto;

public class KontoApp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Konto k1 = new Konto("Opsparing", 1234);

        k1.setSaldo(5000);
        k1.checkBalance();
        k1.indsætBeløb(7000);
        k1.checkBalance();
    }
    
}
