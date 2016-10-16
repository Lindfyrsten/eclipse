package modelfravaer;

/**
 * @author Kristian
 */
public class AfproevFravaersSystem {
    
    public static void main(String[] args) {
        int[][] fravaer16S =
            { { 2, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 2, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 0 }, { 1, 2, 1, 2, 1, 2, 0, 2, 0, 0, 4, 0 },
                { 5, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0 } };
        
        FravaersSystem karakterSystem = new FravaersSystem();
        karakterSystem.udskrivFravaer(fravaer16S);
        karakterSystem.samletFravaer(fravaer16S, 5);
        karakterSystem.gennemsnit(fravaer16S, 5);
        karakterSystem.antalUdenFravaer(fravaer16S);
        karakterSystem.mestFravaer(fravaer16S);
        karakterSystem.nulstil(fravaer16S, 5);
        karakterSystem.samletFravaer(fravaer16S, 5);
        
    }
}
