package model;

public class Nedboer {

    public static void main(String[] args) {
        System.out.println(besteTreFerieUger());
//        System.out.println(nedboerPrUge[28]);
    }
    
    private static int[] nedboerPrUge = { 20, 10, 12, 12, 13, 14, 15, 10, 8, 7, 13,
        15, 10, 9, 6, 8, 12, 22, 14, 16, 16, 18, 23, 12, 0, 2, 0, 0, 78, 0,
        0, 0, 34, 12, 34, 23, 23, 12, 44, 23, 12, 34, 22, 22, 22, 22, 18,
        19, 21, 32, 24, 13 };
    
    /**
     * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien,
     * hvis man ønsker den minimale nedbørsmængde i de tre uger
     *
     * @return
     */
    
    public static int besteTreFerieUger() {
        int ugeNr = 0;
        
        int min = 999999;
        for (int i = 0; i < nedboerPrUge.length - 2; i++) {
            int temp = 0;
            for (int j = 0; j < 3; j++) {
                temp += nedboerPrUge[i + j];
            }
            if (temp < min) {
                min = temp;
                ugeNr = i + 1;
                
            }
        }
        return ugeNr;
    }
    
    /**
     * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien,
     * hvis man ønsker den minimale nedbørsmængde i det "antal" uger, der er
     * angivet i paramtereren
     *
     * @return
     */
    
    public int bedsteFerieUgerStart(int antal) {
        // TODO
    }
    
    /**
     * Returnerer ugenummeret på den første uge hvor nedbøren har været præcis
     * den samme flest uger i træk
     *
     * @return
     */
    public int ensNedboer() {
        // TODO
        
    }
}
