package dicegames;

import java.util.Scanner;

public class PlayPairOfDice {

    /**
     * attributes
     */
    
    private Scanner scan;
    private PairOfDices PairOfDices;

    /**
     * constructor
     */
    
    public PlayPairOfDice() {
        PairOfDices = new PairOfDices();
        scan = new Scanner(System.in);
    }

    /**
     * calls the method that rolls both dice. It prints out the sum of this roll.
     */

    private void takeTurn() {
        PairOfDices.rollBothDices();

        System.out.println("Summen af dit kast er: " + PairOfDices.getSumOfDices());
    }

    /**
     * when the game is over it gives you some statistics.
     */

    private void gameOver() {

        System.out.println("Tak for spillet du. Du har slået par " + PairOfDices.getPair() + " "
            + "gange.");
        System.out.println("Dit største kast var på " + PairOfDices.getRekord());
        System.out.println("Du har slået et " + PairOfDices.getOne() + " gange");
        System.out.println("Du har slået to " + PairOfDices.getTwo() + " gange");
        System.out.println("Du har slået tre " + PairOfDices.getThree() + " gange");
        System.out.println("Du har slået fire " + PairOfDices.getFour() + " gange");
        System.out.println("Du har slået fem " + PairOfDices.getFive() + " gange");
        System.out.println("Du har slået seks " + PairOfDices.getSix() + " gange");
        System.out.println("Du har slået par " + PairOfDices.getPair() + " gange");
        System.out.println("Du har slået " + PairOfDices.totalRolls() + " gange");
        scan.close();

    }
    
    public void startGame() {

        boolean finished = false;

        while (!finished) {
            System.out.println(
                "Vil du kaste dine terninger eller starte forfra? Angiv Ja, nej eller reset: ");
            String goOn = scan.nextLine();

            if (goOn.equalsIgnoreCase("Nej")) {
                finished = true;
            }
            else if (goOn.equalsIgnoreCase("reset")) {
                finished = false;
                PairOfDices.resetPairOfDice();
                
            }
            
            else {
                takeTurn();
            }
        }
        gameOver();
    }

}
