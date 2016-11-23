package opgave2;

public class Customer implements Comparable<Customer> {
    private String fornavn, efternavn;
    private int alder;

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
    
}
