package dicegames;

import java.util.Scanner;

public class PigPlay {

    /**
     * The scanner used for reading user input.
     */
    private Scanner scan;

    /**
     * Name of the players
     */
    private String playerOne;
    private String playerTwo;
    /**
     * The die used in the game.
     */
    private Die die;
    
    /**
     * Points of the players
     */
    private int playerOnePoint;
    private int playerTwoPoint;
    
    /**
     * Boolean to keep track of whose turn it is
     */
    private boolean pOneTurn = true;
    
    /**
     * Check who won
     */
    private boolean pOneWon;

    /**
     * Constructs the PlayRollDie game.
     */
    public PigPlay() {

        die = new Die();
        scan = new Scanner(System.in);
        pOneTurn = true;
    }

    public int getPlayerOnePoint() {
        return playerOnePoint;
    }

    public void setPlayerOnePoint(int playerOnePoint) {
        this.playerOnePoint = playerOnePoint;
    }

    public int getPlayerTwoPoint() {
        return playerTwoPoint;
    }

    public void setPlayerTwoPoint(int playerTwoPoint) {
        this.playerTwoPoint = playerTwoPoint;
    }

    /**
     * Print out a neat welcome message to the player.
     * @throws InterruptedException
     */
    private void welcomeToGame() throws InterruptedException {
        System.out.println("Velkommen til PIG");
        System.out.println("Hvad er navn på første spiller?");
        playerOne = scan.nextLine();
        System.out.println("Hvad er navn på anden spiller?");
        playerTwo = scan.nextLine();
        System.out.println("Lad spillet begynde!");
        Thread.sleep(2000);

    }

    /**
     * Finishes the game and prints out the result.
     */
    private void gameOver() {

        if (pOneWon) {
            System.out.println(playerOne + " vandt!");
            System.out.println("Tak for spillet");
        }
        
        else {
            System.out.println(playerTwo + " vandt!");
            System.out.println("Tak for spillet");
        }
        
        scan.close();
    }

    /**
     * Player one takes a turn.
     * @throws InterruptedException
     */
    private void playerOneTurn() throws InterruptedException {

        System.out.println(playerOne + "'s tur.");
        System.out.println("Du har " + playerOnePoint + " point.");
        boolean fortsæt = true;
        int pointLost = playerOnePoint;
        while (fortsæt) {
            System.out.println("Rolling dice...");
            Thread.sleep(1000);
            
            die.roll();
            int roll = die.getFaceValue();

            if (die.getFaceValue() == 1) {
                System.out.println("Øv! Du rullede 1. Ingen point denne runde");
                playerOnePoint = pointLost;
                fortsæt = false;
            }
            else if (playerOnePoint >= 100) {
                fortsæt = false;
            }
            else {
                System.out.println("Du har rullet: " + roll);
                playerOnePoint = playerOnePoint + roll;
                System.out.println("____________________________");
                System.out.println("Point: " + playerOnePoint);
                System.out.println("____________________________");
                System.out.println("Vil du fortsætte: Y/N");
                String goOn = scan.nextLine();
                if (goOn.equalsIgnoreCase("N")) {
                    fortsæt = false;
                }
            }
        }
        pOneTurn = false;
        System.out.println("**************************");
        System.out.println("Skifter spiller");
        System.out.println("**************************");
        Thread.sleep(2000);
    }

    /**
     * Player two takes a turn.
     */
    private void playerTwoTurn() throws InterruptedException {
        System.out.println(playerTwo + "'s tur.");
        System.out.println("Du har " + playerTwoPoint + " point.");
        boolean fortsæt = true;
        int pointLost = playerTwoPoint;
        while (fortsæt) {
            System.out.println("Rolling dice...");
            Thread.sleep(1000);
            die.roll();
            int roll = die.getFaceValue();

            if (die.getFaceValue() == 1) {
                System.out.println("Øv! Du rullede 1. Ingen point denne runde");
                playerTwoPoint = pointLost;
                fortsæt = false;
            }
            
            else if (playerTwoPoint >= 100) {
                fortsæt = false;
                pOneWon = false;
            }
            else {
                System.out.println("Du har rullet: " + roll);
                playerTwoPoint = playerTwoPoint + roll;
                System.out.println("____________________________");
                System.out.println("Point: " + playerTwoPoint);
                System.out.println("____________________________");
                System.out.println("Vil du fortsætte: Y/N");
                String goOn = scan.nextLine();
                if (goOn.equalsIgnoreCase("N")) {
                    fortsæt = false;
                }
            }
        }
        pOneTurn = true;
        System.out.println("**************************");
        System.out.println("Skifter spiller");
        System.out.println("**************************");
        Thread.sleep(2000);
    }

    /**
     * Start the game loop.<br/>
     * The game is finished when the player chooses to not roll the die anymore.
     * @throws InterruptedException
     */
    public void startGame() throws InterruptedException {
        welcomeToGame();
        
        boolean finished = false;
        
        while (!finished) {
            if (playerOnePoint >= 100 || playerTwoPoint >= 100) {
                finished = true;
            }
            else if (pOneTurn) {
                playerOneTurn();
            }
            else {
                playerTwoTurn();
            }
            
        }
        gameOver();
    }
}