package dicegames;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Dice {

    public Dice() {
    }

    /**
     * Javafx play sound function
     */
    
    public static void playSound(String fileName) {
        new javafx.embed.swing.JFXPanel();
        Media m = new Media(
            "file:///" + System.getProperty("user.dir").replace('\\', '/') + "/" + fileName);
        MediaPlayer player = new MediaPlayer(m);
        player.play();
    }

    /**
     * Grafiske illustrationer af terninger
     * @param di
     * @return
     */
    public int d1(int di) {

        if (di == 1) {
            System.out.println("        ██████████");
            System.out.println("        ██████████");
            System.out.println("        ███   ████");
            System.out.println("        ██████████");
            System.out.println("        ██████████");
            
        }
        else if (di == 2) {
            System.out.println("        ██████████");
            System.out.println("        ██  ██████");
            System.out.println("        ██████████");
            System.out.println("        ██████  ██");
            System.out.println("        ██████████");
        }
        else if (di == 3) {
            System.out.println("        ██████████");
            System.out.println("        █  ███████");
            System.out.println("        ████  ████");
            System.out.println("        ███████  █");
            System.out.println("        ██████████");
        }
        else if (di == 4) {
            System.out.println("        ██████████");
            System.out.println("        ██  ██  ██");
            System.out.println("        ██████████");
            System.out.println("        ██  ██  ██");
            System.out.println("        ██████████");

        }
        else if (di == 5) {
            System.out.println("        █▀▀████▀▀█");
            System.out.println("        █▄▄████▄▄█");
            System.out.println("        ███   ████");
            System.out.println("        █▀▀████▀▀█");
            System.out.println("        █▄▄████▄▄█");
        }
        else if (di == 6) {
            System.out.println("        █▀▀████▀▀█");
            System.out.println("        █▄▄████▄▄█");
            System.out.println("        █  ████  █");
            System.out.println("        █▀▀████▀▀█");
            System.out.println("        █▄▄████▄▄█");

        }
        return di;
    }
    
}