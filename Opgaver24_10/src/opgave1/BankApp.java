package opgave1;

public class BankApp {
    
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount(1000);
        BankAccount b2 = new BankAccount(500);
        BankAccount b3 = new BankAccount(0);
        
        System.out.println(b1.getBalance() + " " + b2.getBalance() + " " + b3.getBalance());
        System.out.println(b1.getId() + " " + b2.getId() + " " + b3.getId());

    }
    
}
