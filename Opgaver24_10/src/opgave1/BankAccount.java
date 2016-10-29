package opgave1;

public class BankAccount {
    private double balance;
    private static int accountsCreated = 1;
    private int id;
    
    /**
     * @param initialBalance
     * Start balancen på en nyoprettet konto
     */
    public BankAccount(double initialBalance) {
        
        balance = initialBalance;
        id = accountsCreated;
        accountsCreated++;
    }
    
    /**
     * @param amount
     * Indsætter nyt beløb til konto
     */
    public void deposit(double amount) {
        balance += amount;
    }
    
    /**
     * @param amount
     * Fratrækker beløbet fra konto
     */
    public void withdraw(double amount) {
        balance -= amount;
        
    }
    
    /**
     * @return
     * Henter kontobalancen
     */
    public double getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    public static int getAccountsCreated() {
        return accountsCreated;
    }

}
