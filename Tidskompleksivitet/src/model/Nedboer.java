package model;

public class Nedboer {
    
    public static void main(String[] args) {
        System.out.println("Uge at tage afsted for 3 bedste uger: " + besteTreFerieUger());
        System.out.println("Uge at tage afsted for bedste antal uger: " + bedsteFerieUgerStart(7));
        System.out.println("Startugen for flest ens nedbørsmængde i træk: " + ensNedboer());
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

    public static int bedsteFerieUgerStart(int antal) {
        int ugeNr = 0;
        int min = 999999;
        for (int i = 0; i < nedboerPrUge.length - antal; i++) {
            int temp = 0;
            for (int j = 0; j < antal; j++) {
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
     * Returnerer ugenummeret på den første uge hvor nedbøren har været præcis
     * den samme flest uger i træk
     *
     * @return
     */

    public static int ensNedboer() {
        
        int countMax = 1;
        int ugeNr = 0;
        int i = 0;
        while (i < nedboerPrUge.length - countMax) {
            
            int count = 1;
            int j = 1;
            while (nedboerPrUge[i] == nedboerPrUge[i + j]) {
                count++;
                j++;
            }
            if (count > countMax) {
                ugeNr = i + 1;
                countMax = count;
            }
            i++;
            
        }
        return ugeNr;
        
    }
}
