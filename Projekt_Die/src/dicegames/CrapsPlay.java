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
     * Constructs the PlayRollDie game.
     */
    public CrapsPlay() {
        die1 = new Die();
        die2 = new Die();
        scan = new Scanner(System.in);
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
            scan.close();
        }
        else {
            System.out.println("Buhhhhh... Du tabte.");
        }
    }

    /**
     * Take another turn in the game.
     */
    private void takeTurn() {
        
        int point = 0;
        
        if (point == 0) {
            
            die1.roll();
            die2.roll();
            int sum = die1.getFaceValue() + die2.getFaceValue();
            System.out.println("Du har kastet: " + sum);
            
            if (sum == 7 || sum == 11) {
                gameWon = true;
                gameFinished = true;
            }
            else if (sum == 2 || sum == 3 || sum == 12) {
                gameFinished = true;
            }
            else if (point == 0) {
                sum = point;
            }
            else if (point == sum) {
                gameFinished = true;
            }
            else {
                point = sum;
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
            System.out.println("Vil du kaste en terning? Y/N: ");
            String goOn = scan.nextLine();
            if (goOn.equalsIgnoreCase("N")) {
                gameFinished = true;
            }
            else {
                takeTurn();
            }
        }
        gameOver();
    }
}
