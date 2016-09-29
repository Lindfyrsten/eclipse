package dicegames;

import java.io.IOException;
import java.util.Random;
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
     * Tælder antallet af ture
     */
    private int turnsOne;
    private int turnsTwo;

    /**
     * tæller antallet rolls per spiller
     */
    private int pOneRolls;
    private int pTwoRolls;
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
                System.out.println("▒█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█");
                System.out.println("▒█                           █");
                System.out.println("▒█ " + playerOne + "'s tur. ");
                System.out.println("▒█                           █ ");
                System.out.println("▒█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
                playerOneTurn();
            }
            else {
                turnsTwo++;
                System.out.println("▒█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█");
                System.out.println("▒█                           █");
                System.out.println("▒█ " + playerTwo + "'s tur. ");
                System.out.println("▒█                           █");
                System.out.println("▒█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
                playerTwoTurn();
            }
            
        }
        gameOver();
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
     * Roll die effects
     * @throws InterruptedException
     */
    private void rulTerning() throws InterruptedException {
        System.out.println("");
        System.out.println("");
        Dice.playSound("src/lyde/Roll.mp3");
        d.d1(die.getFaceValue());
        System.out.println("");
        System.out.println("");
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

            pOneRolls++;
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
                if (playerOnePoint < 10) {
                    System.out.println("▒█ Nuværende point: " + playerOnePoint + "     █▒");
                }
                else {
                    System.out.println("▒█ Nuværende point: " + playerOnePoint + "    █▒");
                }
                
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

            pTwoRolls++;
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
                playerTwoPoint = playerTwoPoint + roll;
                System.out.println("\n▒█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█▒");
                System.out.println("▒█ Point før tur  : " + pointLost + "     █▒");
                if (playerTwoPoint < 10) {
                    System.out.println("▒█ Nuværende point: " + playerTwoPoint + "     █▒");
                }
                else {
                    System.out.println("▒█ Nuværende point: " + playerTwoPoint + "    █▒");
                }
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

            pTwoRolls++;
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
                if (playerTwoPoint < 10) {
                    System.out.println("▒█ Nuværende point: " + playerTwoPoint + "     █▒");
                }
                else {
                    System.out.println("▒█ Nuværende point: " + playerTwoPoint + "    █▒");
                }
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
     * Finishes the game and prints out the result.
     */
    private void gameOver() {

        if (pOneWon) {
            System.out.println(playerOne + " vandt!");

        }

        else {
            System.out.println(playerTwo + " vandt!");
        }

        double snit = (double) pOneRolls / (double) turnsOne;
        System.out.println("\nTak for spillet\n");
        System.out.println("▒█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
        System.out.println("▒█ " + playerOne + " brugte " + turnsOne + " ture.");
        System.out.println("▒█ " + playerOne + " kastede " + pOneRolls + " gange i alt.");
        System.out.print("▒█ " + playerOne + " kastede i gennemsnit ");
        System.out.printf("%.1f", snit);
        System.out.println(" gange.");
        System.out.println("▒█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");

        snit = (double) pTwoRolls / (double) turnsTwo;
        
        System.out.println("▒█ " + playerTwo + " brugte " + turnsTwo + " ture.");
        System.out.println("▒█ " + playerTwo + " kastede " + pTwoRolls + " gange i alt.");
        System.out.print("▒█ " + playerTwo + " kastede i gennemsnit ");
        System.out.printf("%.1f", snit);
        System.out.println(" gange.");
        System.out.println("▒█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");

        if (npc == true && pOneWon == false) {
            Dice.playSound("src/lyde/Boo.mp3");
        }
        else {
            
            Dice.playSound("src/lyde/Applause.mp3");
        }
        
    }
    
}