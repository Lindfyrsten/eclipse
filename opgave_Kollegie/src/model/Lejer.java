package model;

/**
 * @author Kristian Lindbjerg
 */
public class Lejer implements Comparable<Lejer> {
    private String navn, uddannelse;

    public Lejer(String navn, String uddannelse) {
        this.navn = navn;
        this.uddannelse = uddannelse;
    }
    
    public String getNavn() {
        return navn;
    }
    
    public void setNavn(String navn) {
        this.navn = navn;
    }
    
    public String getUddannelse() {
        return uddannelse;
    }
    
    public void setUddannelse(String uddannelse) {
        this.uddannelse = uddannelse;
    }
    
    @Override
    public int compareTo(Lejer o) {
        return this.navn.compareTo(o.getNavn());
    }

}
