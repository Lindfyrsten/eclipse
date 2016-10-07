package modelfravaer;

public class AfproevFravaersSystem {
    
    public static void main(String[] args) {
        int[][] fravaer16S =
            { { 2, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 2, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 0 }, { 1, 2, 1, 2, 1, 2, 0, 2, 0, 0, 4, 0 },
                { 5, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0 } };
        
        FravaersSystem karakterSystem = new FravaersSystem();
        karakterSystem.udskrivFravaer(fravaer16S);
        System.out.println();
        
    }
}
