/**
 *
 */
package opgave4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Kristian
 */
public class SvømmerApp {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        Svømmer s = new Svømmer("Kristian", LocalDate.of(1987, 4, 20), "AGF",
            new ArrayList<>(Arrays.asList(5.32, 6.30, 5.65, 7.15)));
        System.out.println(s.getNavn() + "'s årgang " + s.getÅrgang());
        System.out.println(s.getNavn() + "'s bedste tid: " + s.bedsteTid());
        System.out.println(s.getNavn() + "'s gennemsnitstid: " + s.gennemsnitAfTid());
        System.out.println(
            s.getNavn() + "'s gennemsnitstid uden dårligste tid: " + s.snitUdenDårligste());
    }
    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Constructors
    // ===========================================================
    
    // ===========================================================
    // Getter & Setter
    // ===========================================================
    
    // ===========================================================
    // Methods
    // ===========================================================
}
