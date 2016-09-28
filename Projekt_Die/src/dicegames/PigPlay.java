package dicegames;

import java.io.File;
import java.util.Scanner;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

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
    
    private int winNr;

    /**
     * Points of the players
     */
    private int playerOnePoint;
    private int playerTwoPoint;

    private boolean finished = false;

    /**
     * Boolean to keep track of whose turn it is
     */
    private boolean pOneTurn = true;

    /**
     * Check who won
     */
    private boolean pOneWon = true;
    
    /**
     * Constructs the PlayRollDie game.
     */
    public PigPlay() {
        
        die = new Die();
        scan = new Scanner(System.in);
        pOneTurn = true;
    }

    /**
     * Javafx play sound function
     */
    static void play(String fileName) {
        new javafx.embed.swing.JFXPanel();
        String uriString = new File(fileName).toURI().toString();
        new MediaPlayer(new Media(uriString)).play();
    }

    /**
     * Print out a neat welcome message to the player.
     * @throws InterruptedException
     */
    private void welcomeToGame() throws InterruptedException {
        System.out.println("Velkommen til spillet gris!");
        Thread.sleep(1000);
        System.out.println("Hvad er navn på første spiller?");
        playerOne = scan.nextLine();
        System.out.println("Hvad er navn på anden spiller?");
        playerTwo = scan.nextLine();
        System.out.println("Hvad vil I spille til?");
        winNr = scan.nextInt();
        scan.nextLine();
        System.out.println("Lad spillet begynde!");
        Thread.sleep(2000);
        
    }
    
    /**
     * Finishes the game and prints out the result.
     */
    private void gameOver() {
        
        play("Applause.mp3");
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

        boolean fortsæt = true;
        int pointLost = playerOnePoint;
        while (fortsæt) {

            die.roll();
            int roll = die.getFaceValue();

            if (playerOnePoint >= winNr) {

                fortsæt = false;
                finished = true;
                
            }
            else if (die.getFaceValue() == 1) {
                System.out.println("Rolling dice...");
                play("Roll.mp3");
                Thread.sleep(1500);
                System.out.println("Øv! Du rullede 1. Ingen point denne runde");
                playerOnePoint = pointLost;
                fortsæt = false;
            }
            else {
                System.out.println("Rolling dice...");
                play("Roll.mp3");
                Thread.sleep(1500);
                System.out.println("");
                System.out.println("");
                System.out.println("Du har rullet: " + roll);
                playerOnePoint = playerOnePoint + roll;
                System.out.println("*******************************");
                System.out.println("Point: " + playerOnePoint);
                System.out.println("*******************************");

                if (playerOnePoint < winNr) {
                    System.out.println("Vil du fortsætte: Y/N");

                    String goOn = scan.nextLine();
                    if (goOn.equalsIgnoreCase("N")) {
                        fortsæt = false;
                    }

                }
            }
        }
        if (!fortsæt && finished) {
            
            System.out.println("Vi har en vinder!!!");
            Thread.sleep(250);
            System.out.println(".");
            Thread.sleep(250);
            System.out.println("..");
            Thread.sleep(250);
            System.out.println("...");
            Thread.sleep(250);
            System.out.println("....");
        }
        else {

            pOneTurn = false;
            System.out.println("**************************");
            System.out.println("Skifter spiller");
            System.out.println("");

        }
        Thread.sleep(2000);
    }
    
    /**
     * Player two takes a turn.
     */
    private void playerTwoTurn() throws InterruptedException {
        boolean fortsæt = true;
        int pointLost = playerTwoPoint;
        while (fortsæt) {
            die.roll();
            int roll = die.getFaceValue();
            
            if (playerTwoPoint >= winNr) {
                pOneWon = false;
                fortsæt = false;
                finished = true;

            }
            else if (die.getFaceValue() == 1) {
                System.out.println("Rolling dice...");
                play("Roll.mp3");
                Thread.sleep(1500);
                System.out.println("Øv! Du rullede 1. Ingen point denne runde");
                playerTwoPoint = pointLost;
                fortsæt = false;
            }
            else {
                System.out.println("Rolling dice...");
                play("Roll.mp3");
                Thread.sleep(1500);
                System.out.println("");
                System.out.println("");
                System.out.println("Du har rullet: " + roll);
                playerTwoPoint = playerTwoPoint + roll;
                System.out.println("*******************************");
                System.out.println("Point: " + playerTwoPoint);
                System.out.println("*******************************");
                
                if (playerTwoPoint < winNr) {
                    System.out.println("Vil du fortsætte: Y/N");

                    String goOn = scan.nextLine();
                    if (goOn.equalsIgnoreCase("N")) {
                        fortsæt = false;
                    }
                }
                
            }
        }
        
        if (!fortsæt && finished) {
            
            System.out.println("Vi har en vinder!!!");
            Thread.sleep(250);
            System.out.println(".");
            Thread.sleep(250);
            System.out.println("..");
            Thread.sleep(250);
            System.out.println("...");
            Thread.sleep(250);
            System.out.println("....");
        }
        else {

            pOneTurn = true;
            System.out.println("**************************");
            System.out.println("Skifter spiller");
            System.out.println("");

        }
        Thread.sleep(2000);
    }
    
    /**
     * Start the game loop.<br/>
     * The game is finished when the player chooses to not roll the die anymore.
     * @throws InterruptedException
     */
    public void startGame() throws InterruptedException {
        welcomeToGame();
        
        while (!finished) {
            
            if (pOneTurn) {
                
                System.out.println("____________________________");
                System.out.println("|");
                System.out.println("| " + playerOne + "'s tur.");
                System.out.println("| Du har " + playerOnePoint + " point.");
                System.out.println("|");
                System.out.println("____________________________");
                playerOneTurn();
            }
            else {
                System.out.println("____________________________");
                System.out.println("|");
                System.out.println("| " + playerTwo + "'s tur.");
                System.out.println("| Du har " + playerTwoPoint + " point.");
                System.out.println("|");
                System.out.println("____________________________");
                playerTwoTurn();
            }

        }
        gameOver();
    }
}