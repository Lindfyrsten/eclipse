package dicegames;

import java.util.Scanner;

public class CrapsPlay {

    /**
     * The scanner used for reading user input.
     */
    private Scanner scan;
    /**
     * The first die used in the game.
     */
    private Die die1;
    
    /**
     * The second die used in the game.
     */
    private Die die2;
    
    /**
     * Boolean to tell if you won or lost game
     */
    private boolean gameWon = false;
    /**
     * Boolean to tell if you won or lost game
     */
    private boolean gameFinished = false;
    
    /**
     * Holder styr på point
     */
    private int point = 0;
    
    /**
     * Constructs the PlayRollDie game.
     */
    public CrapsPlay() {
        die1 = new Die();
        die2 = new Die();
        scan = new Scanner(System.in);
    }
    
    public void retry() {
        System.out.println("Vil du prøve igen? Y/N");
        String goOn = scan.nextLine();
        if (goOn.equalsIgnoreCase("N")) {
            gameFinished = true;
        }
        else {
            point = 0;
        }
    }

    /**
     * Print out a neat welcome message to the player.
     */
    private void welcomeToGame() {
        System.out.println("Velkommen til spillet Craps!");
    }
    
    /**
     * Finishes the game and prints out the result.
     */
    private void gameOver() {
        
        if (gameWon) {
            System.out.println("Sådan! Du vandt!");
        }
        else {
            System.out.println("Buhhhhh... Du tabte.");
            
        }
        
    }
    
    /**
     * Take another turn in the game.
     */
    private void takeTurn() {

        die1.roll();
        die2.roll();

        int sum = die1.getFaceValue() + die2.getFaceValue();
        System.out.println("Du har kastet " + sum);
        if (point == 0) {
            point = sum;
            if (sum == 7 || sum == 11) {
                gameWon = true;
                gameOver();
                retry();
            }
            else if (sum == 2 || sum == 3 || sum == 12) {
                gameOver();
                retry();
            }
        }
        else {

            if (sum == 7) {
                gameOver();
                retry();
            }
            else if (sum == point) {
                System.out.println("Du ramte dit point!");
                gameWon = true;
                gameOver();
                retry();
            }
        }

    }
    
    /**
     * Start the game loop.<br/>
     * The game is finished when the player chooses to not roll the die anymore.
     */
    public void startGame() {
        welcomeToGame();

        while (!gameFinished) {
            System.out.println("Roll the dice? Y/N");
            String goOn = scan.nextLine();
            if (goOn.equalsIgnoreCase("N")) {
                gameFinished = true;
                
            }
            else {
                takeTurn();
            }

        }
        System.out.println("Tak for spillet :)");
        scan.close();
    }
}
