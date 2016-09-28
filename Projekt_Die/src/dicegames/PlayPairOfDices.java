package dicegames;

import java.io.File;
import java.util.Scanner;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * This class models one pair of dices.
 *
 */
public class PlayPairOfDices {
    /**
     * The first die in the pair.
     */
    private Die die1;
    
    /**
     * The second die in the pair.
     */
    
    private Die die2;
    /**
     * Holder styr på antallet af rolls
     */
    private int rolls;
    /**
     * Tjekker input i menuen
     */
    private int result;
    private Scanner scan;
    private int sum;
    /**
     * Tæller antallet af gange slået 1-6
     */

    private int one;
    private int two;
    private int three;
    private int four;
    private int five;
    private int six;
    /**
     * Tæller antallet af gange slået 1-5
     */
    /**
     * Tæller antallet af gange slået par
     */
    private int pairs;
    /**
     * Boolean der fortæller om programmet kører eller ej
     */
    private boolean isOn;
    
    /**
     * Boolean der fortæller om vi ruller videre
     */
    private boolean keepRollin;
    
    /**
     * Gemmer rekorden af højeste sum
     */
    private int rekord;

    /**
     * Constructor for objects of class PairOfDices
     */
    
    public PlayPairOfDices(int sides) {
        die1 = new Die(6);
        die2 = new Die(6);
        scan = new Scanner(System.in);
        isOn = true;
        keepRollin = false;
        
    }
    
    /**
     * Javafx play sound funktion
     */
    private static void play(String fileName) {
        new javafx.embed.swing.JFXPanel();
        String uriString = new File(fileName).toURI().toString();
        new MediaPlayer(new Media(uriString)).play();
    }

    public int getRekord() {
        return rekord;
    }
    
    /**
     * Resetter hukommelsen
     */
    private void resetPairOfDice() {
        rolls = 0;
        sum = 0;
        pairs = 0;
        rekord = 0;
        six = 0;
        one = 0;
        two = 0;
        three = 0;
        four = 0;
        five = 0;

    }

    /**
     * Looping menu indtil app er lukket.
     */
    private void menu() {
        
        System.out.println("*************************");
        System.out.println("\u001b[1;31mRecord\u001b[1;0m: " + getRekord());
        System.out.println("*************************");
        System.out.println("Press 1 to roll the die.");
        System.out.println("Press 2 to reset.");
        System.out.println("Press 3 to quit.");
        System.out.println("__________________________");
        result = scan.nextInt();
        
    }

    private void keepRollinMenu() throws InterruptedException {
        System.out.println("*************************");
        System.out.println("Press 1 to roll again.");
        System.out.println("Press 2 to return to menu.");
        System.out.println("*************************");
        while (keepRollin == true) {
            result = scan.nextInt();
            if (getResult() == 1) {
                //play("Rollin.mp3");
                RollBothDices();
                
            }
            else if (getResult() == 2) {
                keepRollin = false;
            }
            else {
                menuRepeat();
            }
        }
    }

    private void menuRepeat() {

        System.out.println("Please press a valid number.");
    }

    public int getResult() {
        return result;
        
    }

    /**
     * Velkomst
     */
    private void greeting() {
        System.out.println("");
        System.out.println("Welcome to ");
        System.out.println("\u001b[1;35mDICE ROLLER 9000!\u001b[0m");
        System.out.println("");

    }
    
    /**
     * Lukket programmet og udskriver de forskellige stats
     */
    private void quit() throws InterruptedException {
        System.out.println("You rolled a total of " + rolls + " times.");
        System.out.println("You rolled 6: " + six + " times.");
        System.out.println("You rolled 5: " + five + " times.");
        System.out.println("You rolled 4: " + four + " times.");
        System.out.println("You rolled 3: " + three + " times.");
        System.out.println("You rolled 2: " + two + " times.");
        System.out.println("You rolled 1: " + one + " times.");
        System.out.println("Pairs hit: " + pairs);
        System.out.println("Your record was: " + rekord);
        
        System.out
            .println(
                "\u001b[1;35mThank you for using DICE ROLLER 9000! Have a nice day.\u001b[0m");
        //play("Goodbye.mp3");

        scan.close();
        isOn = false;

    }

    /**
     * starter spillet
     */
    public void StartGame() throws InterruptedException {
        greeting();

        //play("Welcome.mp3");
        Thread.sleep(5000);

        while (isOn == true) {

            menu();

            if (getResult() == 1) {
                RollBothDices();
            }

            else if (getResult() == 2) {
                resetPairOfDice();
            }

            else if (getResult() == 3) {

                quit();
            }

            else {

                menuRepeat();
            }

        }
    }
    
    /**
     * Ruller begge terninger og opdaterer nye værdier
     */
    private void RollBothDices() throws InterruptedException {

        keepRollin = true;
        
        System.out.println("Rolling die...");
        play("Roll.mp3");
        die1.roll();
        die1.getFaceValue();
        die2.roll();
        die2.getFaceValue();
        rolls++;
        sum = die1.getFaceValue() + die2.getFaceValue();
        Thread.sleep(1000);
        if (sum >= 10) {
            System.out.println("Wow! You rolled " + sum);
            play("Applause.mp3");
        }
        
        else if (sum >= 6) {
            System.out.println("Not bad. You rolled " + sum);
        }
        
        else {
            System.out.println("Better luck next time! You only rolled " + sum);
        }
        
        if (sum > rekord) {
            rekord = sum;
            System.out.println("\u001B[32mNew record!\u001B[0m");
            
        }
        
        if (die1.getFaceValue() == 6 && die2.getFaceValue() == 6) {
            six = six + 2;
        }

        else if (die1.getFaceValue() == 6 || die2.getFaceValue() == 6) {
            six++;
        }
        if (die1.getFaceValue() == 5 && die2.getFaceValue() == 5) {
            five = five + 2;
        }

        else if (die1.getFaceValue() == 5 || die2.getFaceValue() == 5) {
            five++;
        }
        if (die1.getFaceValue() == 4 && die2.getFaceValue() == 4) {
            four = four + 2;
        }

        else if (die1.getFaceValue() == 4 || die2.getFaceValue() == 4) {
            four++;
        }
        if (die1.getFaceValue() == 3 && die2.getFaceValue() == 3) {
            three = three + 2;
        }

        else if (die1.getFaceValue() == 3 || die2.getFaceValue() == 3) {
            three++;
        }
        
        if (die1.getFaceValue() == 2 && die2.getFaceValue() == 2) {
            two = two + 2;
        }

        else if (die1.getFaceValue() == 2 || die2.getFaceValue() == 2) {
            two++;
        }
        if (die1.getFaceValue() == 1 && die2.getFaceValue() == 1) {
            one = one + 2;
        }

        else if (die1.getFaceValue() == 1 || die2.getFaceValue() == 1) {
            one++;
        }
        if (die1.getFaceValue() == die2.getFaceValue()) {
            System.out.println(
                "\u001B[32mAmazing! You rolled a pair of " + die1.getFaceValue()
                    + "'s\u001B[0m");
            pairs++;
        }
        
        keepRollinMenu();
        
    }
    
}
