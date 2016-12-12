package opgave3;

import java.util.Arrays;

public class Customer implements Comparable<Customer> {
    private String fornavn, efternavn;
    private int alder;

    public Customer(String fornavn, String efternavn, int alder) {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.alder = alder;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    @Override
    public int compareTo(Customer c) {
        
        if (getEfternavn().equals(c.getEfternavn())) {
            if (getFornavn().equals(c.getFornavn())) {
                if (getAlder() == c.getAlder()) {
                    return 0;
                }
                else if (getAlder() < c.getAlder()) {
                    return -1;
                }
                else {
                    return 1;
                }
            }
            else {
                return getFornavn().compareTo(c.getEfternavn());
            }

        }
        else {

            return this.efternavn.compareTo(c.getEfternavn());
        }
    }
    
    public static Customer lastCustomer(Customer[] customers) {
        Arrays.sort(customers);
        return customers[customers.length - 1];
    }
    
    public static Customer[] afterCustomer(Customer[] customers, Customer customer) {
        boolean b = false;
        int i = 0;
        int arrNr = 0;
        if (customers.length > 0) {
            while (!b) {
                
                if (customer == customers[i]) {
                    b = true;
                    arrNr = i + 1;
                }
                i++;
            }
            
        }
        return Arrays.copyOfRange(customers, arrNr, customers.length);
    }
    
    @Override
    public String toString() {
        return efternavn + " " + fornavn;
    }
}
