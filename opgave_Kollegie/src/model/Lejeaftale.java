package model;

import java.time.LocalDate;

/**
 * @author Kristian Lindbjerg
 */
public class Lejeaftale {
    private LocalDate fraDato, tilDato;
    private static int MAX_SIZE = 1;
    private Lejer[] lejere = new Lejer[MAX_SIZE];

    public Lejeaftale(LocalDate fraDato) {
        this.fraDato = fraDato;
        this.tilDato = null;
    }

    public LocalDate getFraDato() {
        return fraDato;
    }

    public void setFraDato(LocalDate fraDato) {
        this.fraDato = fraDato;
    }

    public LocalDate getTilDato() {
        return tilDato;
    }

    public void setTilDato(LocalDate tilDato) {
        this.tilDato = tilDato;
    }
    
    public Lejer[] getLejere() {
        return lejere;
    }
    
    public void addLejer(Lejer lejer) {
        if (lejere[0] == null) {
            lejere[0] = lejer;

        }
        else
            if (lejere[1] == null) {
                lejere[1] = lejer;
            }
            else {
                System.out.println("Allerede to lejere tilknyttet");
            }
    }
    
    public void removeLejer(Lejer lejer) {
        if (lejere[0] == lejer) {
            lejere[0] = null;
        }
        else
            if (lejere[1] == lejer) {
                lejere[1] = null;
            }
            else {
                System.out.println("Lejer ikke fundet");
            }
    }

}
