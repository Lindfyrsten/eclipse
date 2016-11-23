package opgave3;

public class Person {
    private String navn, addresse;

    public Person(String navn, String addresse) {
        this.navn = navn;
        this.addresse = addresse;
    }
    
    @Override
    public String toString() {
        return navn + addresse;
    }
}
