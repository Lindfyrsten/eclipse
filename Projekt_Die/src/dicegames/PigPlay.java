package dicegames;

import java.io.File;
import java.io.IOException;
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
    /**
     * Terninger fra Dice klassen
     */
    private Dice d;

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

        d = new Dice();
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
        System.out.println("");
        System.out.println("▒█▀▀█ █▀▀█ ░▀░ █▀▀");
        System.out.println("▒█░▄▄ █▄▄▀ ▀█▀ ▀▀█");
        System.out.println("▒█▄▄█ ▀░▀▀ ▀▀▀ ▀▀▀");
        System.out.println("");

        Thread.sleep(1000);
        System.out.println("Antal spillere? 1/2");
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

        System.out.println("Hvad skal der spilles til?");
        winNr = scan.nextInt();
        scan.nextLine();
        System.out.println("Held og lykke ٩(●̮̃•)۶\n");
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
    }

    private void rulTerning() throws InterruptedException {
        System.out.println("");
        System.out.println("");
        System.out.print("█");
        Thread.sleep(400);
        System.out.print("░░░░");
        play("Roll.mp3");
        Thread.sleep(250);
        System.out.print("░░░");
        Thread.sleep(250);
        System.out.print("░░█\n");
        System.out.println("");
        d.d1(die.getFaceValue());
        Thread.sleep(1000);
    }
    
    /**
     * Player one takes a turn.
     * @throws InterruptedException
     * @throws IOException
     */
    private void playerOneTurn() throws InterruptedException, IOException {
        
        System.out.println("\nTryk enter for starte " + playerOne + "'s tur.");
        System.in.read();
        scan.nextLine();
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
                rulTerning();
                System.out.println("Øv! Du rullede 1. Ingen point denne runde");
                playerOnePoint = pointLost;
                fortsæt = false;
            }
            else {
                rulTerning();
                playerOnePoint = playerOnePoint + roll;
                System.out.println("\n▒█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█▒");
                System.out.println("▒█ Point før tur  : " + pointLost + "     █▒");
                System.out.println("▒█ Nuværende point: " + playerOnePoint + "     █▒");
                System.out.println("▒█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█▒\n");
                
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
            System.out.println("");
            System.out.println("Skifter spiller...");
            System.out.println("");
            
        }
        Thread.sleep(2000);
    }

    /**
     * Player two takes a turn.
     * @throws IOException
     */
    private void playerTwoTurn() throws InterruptedException, IOException {
        System.out.println("\nTryk enter for starte " + playerTwo + "'s tur.");
        System.in.read();
        scan.nextLine();
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
                rulTerning();
                System.out.println("Øv! Du rullede 1. Ingen point denne runde");
                playerTwoPoint = pointLost;
                fortsæt = false;
            }
            else {
                rulTerning();
                playerOnePoint = playerTwoPoint + roll;
                System.out.println("\n▒█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█▒");
                System.out.println("▒█ Point før tur  : " + pointLost + "     █▒");
                System.out.println("▒█ Nuværende point: " + playerTwoPoint + "     █▒");
                System.out.println("▒█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█▒\n");

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
                rulTerning();
                System.out.println("Computer rullede 1. Ingen point denne runde");
                playerTwoPoint = pointLost;
                fortsæt = false;
            }
            else {
                rulTerning();
                playerTwoPoint = playerTwoPoint + roll;
                System.out.println("\n▒█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█▒");
                System.out.println("▒█ Point før tur  : " + pointLost + "     █▒");
                System.out.println("▒█ Nuværende point: " + playerTwoPoint + "     █▒");
                System.out.println("▒█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█▒\n");

                Random rnd = new Random();
                int abc = rnd.nextInt(4) + 1;
                if (abc == 1 && playerTwoPoint < winNr) {
                    fortsæt = false;
                    System.out.println("Computeren valgte at stoppe.");
                }
                Thread.sleep(2000);
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
            System.out.println("");
            System.out.println("Skifter spiller...");
            System.out.println("");

        }
        Thread.sleep(2000);

    }

    /**
     * Start the game loop.<br/>
     * The game is finished when the player chooses to not roll the die anymore.
     * @throws InterruptedException
     * @throws IOException
     */
    public void startGame() throws InterruptedException, IOException {
        welcomeToGame();

        while (!finished) {

            if (pOneTurn) {
                turnsOne++;
                System.out.println("▒█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█");
                System.out.println("▒█                ▀");
                System.out.println("▒█ " + playerOne + "'s tur. ");
                System.out.println("▒█                ▄");
                System.out.println("▒█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
                playerOneTurn();
            }
            else {
                turnsTwo++;
                System.out.println("▒█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█");
                System.out.println("▒█                ▀");
                System.out.println("▒█ " + playerTwo + "'s tur. ");
                System.out.println("▒█                ▄");
                System.out.println("▒█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
                playerTwoTurn();
            }
            
        }
        gameOver();
    }
}