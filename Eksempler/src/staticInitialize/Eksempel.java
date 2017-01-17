package staticInitialize;

import java.util.Scanner;

/**
 * @author Kristian Lindbjerg
 */
public class Eksempel {
    /*
     * Static initializing bruges når vi skal sætte nogle værdier fra starten.
     */
    private static boolean flag = initialize();
    private static int B, H;
    
    private static boolean initialize() {

        Scanner scan = new Scanner(System.in);
        B = scan.nextInt();
        H = scan.nextInt();
        if (B <= 0 || H <= 0) {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
            return false;
        }
        else {
            return true;
        }
    }

    public static void main(String[] args) {
        if (flag) {
            int area = B * H;
            System.out.println(area);
        }

    }
}
