package modelfravaer;

/**
 * @author Kristian
 */
public class FravaersSystem {

    /**
     * Summen af en elevs årlige fraværsdage
     */
    private int sum;

    /**
     * Boolean der bestemmer om summen skal udskrives
     */
    private boolean udskrivSum = true;
    
    /**
     * Frafaldstallene udskrives på skærmen
     *
     * @param fravaer
     */
    public void udskrivFravaer(int[][] fravaer) {
        System.out
            .println(
                "Elev\\Måned   | 1 | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  | 10 | 11 | 12 |");
        System.out
            .println(
                "_________________________________________________________________________");
        for (int row = 0; row < fravaer.length; row++) {
            System.out.print(row + 1 + "            | ");
            for (int col = 0; col < fravaer[row].length; col++) {
                if (fravaer[row][col] >= 10) {
                    System.out.print(fravaer[row][col] + "|  ");
                }
                else {
                    System.out.print(fravaer[row][col] + " |  ");
                }
                
            }
            System.out.println();
            System.out
                .println(
                    "_________________________________________________________________________");
        }
    }
    
    /**
     * Returnerer det samlede antal fravaerdage over 12 måneder for eleven med
     * elevnr.
     *
     * @param fravaer
     * @param elevNr
     * @return
     */
    public int samletFravaer(int[][] fravaer, int elevNr) {
        int row = elevNr - 1;
        sum = 0;
        int col = 0;
        while (col < fravaer[row].length) {
            sum += fravaer[row][col];
            col++;

        }

        if (udskrivSum) {
            System.out.println("\nElev " + elevNr + "'s årlige fraværsdage: " + sum);
        }
        return sum;

    }

    /**
     * Returnerer det gennemsnitlige antal fraværsdage pr måned for eleven med
     * elevNr.
     *
     * @param fravaer
     * @param elevNr
     * @return
     */
    public double gennemsnit(int[][] fravaer, int elevNr) {
        udskrivSum = false;
        samletFravaer(fravaer, elevNr);
        System.out.println(
            "\nElev " + elevNr + "'s gennemsnitlige fraværsdage per måned: " + (double) sum / 12);
        udskrivSum = true;
        return (double) sum / 12;
    }

    /**
     * Returnerer antallet af elever der ikke har haft fravær i de 12 måneder.
     *
     * @param fravaer
     * @return
     */
    public int antalUdenFravaer(int[][] fravaer) {
        udskrivSum = false;
        int nulFravaer = 0;
        for (int row = 0; row < fravaer.length; row++) {

            samletFravaer(fravaer, row + 1);
            if (sum == 0) {
                nulFravaer++;
            }
        }
        System.out.println("\nAntal elever uden fravær over et år: " + nulFravaer);
        udskrivSum = true;
        return nulFravaer;
    }

    /**
     * Returnerer elevNr for den elev der har haft mest fravær igennem de 12
     * måneder. Hvis flere elever har haft højst fravær, returneres elevnummer
     * for en af disse.
     *
     * @param fravaer
     * @return
     */
    public int mestFravaer(int[][] fravaer) {
        udskrivSum = false;
        int mestFravaer = samletFravaer(fravaer, 1);
        int row;
        for (row = 0; row < fravaer.length; row++) {
            samletFravaer(fravaer, row + 1);
            if (samletFravaer(fravaer, row + 1) > mestFravaer) {
                mestFravaer = samletFravaer(fravaer, row + 1);
            }
        }
        udskrivSum = true;
        System.out.println("\nEleven med mest fravær: Elev " + row + " (" + mestFravaer + " dage)");
        return row;
    }

    /**
     * Registrerer at elenven med elevNr ikke har haft fravær i nogen af de 12
     * måneder.
     *
     * @param fravaer
     * @param elevNr
     */
    public void nulstil(int[][] fravaer, int elevNr) {
        int col = 0;
        while (col < fravaer[elevNr - 1].length) {

            fravaer[elevNr - 1][col] = 0;
            col++;
        }
        System.out.println();
        System.out.println("Elev " + elevNr + "'s fravær er blevet nulstillet.");
    }
}
