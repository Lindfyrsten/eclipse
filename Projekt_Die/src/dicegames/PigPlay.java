package dicegames;

import java.io.File;
import java.util.Random;
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
     * Tælder antallet af ture
     */
    private int turnsOne;
    private int turnsTwo;

    /**
     * Boolean to use for single player
     */
    private boolean npc = false;

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
        System.out.println("Hvor mange spillere? 1/2");
        int twoP = scan.nextInt();
        scan.nextLine();
        if (twoP == 1) {
            npc = true;
            playerTwo = "Computer";
        }
        System.out.println("Hvad er navn på spiller 1?");
        playerOne = scan.nextLine();
        if (npc == false) {
            System.out.println("Hvad er navn på spiller 2?");
            playerTwo = scan.nextLine();
        }

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

        if (pOneWon) {
            System.out.println(playerOne + " vandt!");

        }

        else {
            System.out.println(playerTwo + " vandt!");
        }
        System.out.println("Tak for spillet");
        System.out.println(playerOne + " brugte " + turnsOne + " ture.");
        System.out.println(playerTwo + " brugte " + turnsTwo + " ture.");
        play("Applause.mp3");
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
        while (fortsæt && npc == false) {
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
        while (fortsæt && npc == true) {

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
                System.out.println("Computer rullede 1. Ingen point denne runde");
                playerTwoPoint = pointLost;
                fortsæt = false;
            }
            else {
                System.out.println("Rolling dice...");
                play("Roll.mp3");
                Thread.sleep(1500);
                System.out.println("");
                System.out.println("");
                System.out.println("Computer har rullet: " + roll);
                playerTwoPoint = playerTwoPoint + roll;
                System.out.println("*******************************");
                System.out.println("Point: " + playerTwoPoint);
                System.out.println("*******************************");
                Random rnd = new Random();
                int abc = rnd.nextInt(4) + 1;
                System.out.println(abc);
                if (abc == 1 && playerTwoPoint < winNr) {
                    fortsæt = false;
                    System.out.println("Computeren valgte at stoppe.");
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
                turnsOne++;
                System.out.println("____________________________");
                System.out.println("|");
                System.out.println("| " + playerOne + "'s tur.");
                System.out.println("| Du har " + playerOnePoint + " point.");
                System.out.println("|");
                System.out.println("____________________________");
                playerOneTurn();
            }
            else {
                turnsTwo++;
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