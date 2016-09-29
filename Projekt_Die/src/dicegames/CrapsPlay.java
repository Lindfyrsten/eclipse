package dicegames;

import java.io.File;
import java.util.Scanner;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

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
     * Terninger fra Dice klassen
     */
    private Dice d;
    
    /**
     * Boolean to tell if you won or lost game
     */
    private boolean gameWon = false;
    /**
     * Boolean to tell if game if finished
     */
    private boolean gameFinished = false;
    
    /**
     * Sets the point
     */
    private int point = 0;
    
    /**
     * Counts won and lost games
     */
    private int won;
    private int lost;

    /**
     * Javafx play sound function
     */
    private static void play(String fileName) {
        new javafx.embed.swing.JFXPanel();
        String uriString = new File(fileName).toURI().toString();
        new MediaPlayer(new Media(uriString)).play();
    }
    
    /**
     * Constructs the PlayRollDie game.
     */
    public CrapsPlay() {
        die1 = new Die();
        die2 = new Die();
        d = new Dice();
        scan = new Scanner(System.in);
        
    }
    
    /**
     * Print out a neat welcome message to the player.
     * @throws InterruptedException
     */
    private void welcomeToGame() throws InterruptedException {
        System.out.println("");
        System.out.println("▒█▀▀█ █▀▀█ █▀▀█ █▀▀█ █▀▀");
        System.out.println("▒█░░░ █▄▄▀ █▄▄█ █░░█ ▀▀█ ");
        System.out.println("▒█▄▄█ ▀░▀▀ ▀░░▀ █▀▀▀ ▀▀▀ \n");
        Thread.sleep(2000);
    }
    
    /**
     * Start the game loop.<br/>
     * The game is finished when the player chooses to not roll the die anymore.
     * @throws InterruptedException
     */
    public void startGame() throws InterruptedException {
        welcomeToGame();

        while (!gameFinished) {
            System.out.println("Rul terning?  Y/N");
            String goOn = scan.nextLine();
            if (goOn.equalsIgnoreCase("N")) {
                gameFinished = true;
                
            }
            else {
                takeTurn();
            }
            
        }
        System.out.println("Tak for spillet :)");
        Thread.sleep(500);
        System.out.println("Vundet spil: " + won);
        System.out.println("Tabte spil: " + lost);
        scan.close();
        System.exit(0);
    }

    /**
     * Take a turn in the game.
     * @throws InterruptedException
     */
    private void takeTurn() throws InterruptedException {
        
        die1.roll();
        die2.roll();
        Thread.sleep(1000);
        play("/dicegames/Roll.mp3");
        System.out.println("");
        System.out.println("");
        d.d1(die1.getFaceValue());
        System.out.println("");
        d.d1(die2.getFaceValue());
        System.out.println("");
        Thread.sleep(500);
        int sum = die1.getFaceValue() + die2.getFaceValue();
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
            else {
                System.out.println("▒█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█▒");
                if (point < 10) {
                    System.out.println("▒█Dit point er sat til " + point + "  █▒");
                }
                else {
                    System.out.println("▒█Dit point er sat til " + point + " █▒");
                }
                System.out.println("▒█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█▒\n");
                Thread.sleep(500);
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
     * Finishes the game and prints out the result.
     * @throws InterruptedException
     */
    private void gameOver() throws InterruptedException {
        Thread.sleep(1000);
        if (gameWon) {
            won++;
            System.out.println("Sådan! Du vandt!");
            play("Applause.mp3");
        }
        else {
            lost++;
            System.out.println("Buhhhhh... Du tabte.");
            play("Boo.mp3");
            
        }
    }
    
    /**
     * Asks if user wants to retry
     * @throws InterruptedException
     */
    public void retry() throws InterruptedException {
        System.out.println("Vil du prøve igen? Y/N");
        String goOn = scan.nextLine();
        if (goOn.equalsIgnoreCase("N")) {
            gameFinished = true;
        }
        else {
            point = 0;
        }
    }
}
