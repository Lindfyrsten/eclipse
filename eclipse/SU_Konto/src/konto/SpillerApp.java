package konto;

public class SpillerApp {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Spiller s1 = new Spiller("Kristian Lindbjerg", 29, "Højre fløj");
        
        s1.kamp(2, 1, 15);
        s1.suspend();
        s1.spillerInfo();
        s1.skade();
        
    }

}
