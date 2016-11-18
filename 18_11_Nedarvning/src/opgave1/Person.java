package opgave1;

public class Person {
    private String navn, addresse;
    
    public Person(String navn, String addresse) {
        this.navn = navn;
        this.addresse = addresse;
    }

    public double getUgentligLøn() {
        return 0;
    }

    @Override
    public String toString() {
        return navn;
    }
}
