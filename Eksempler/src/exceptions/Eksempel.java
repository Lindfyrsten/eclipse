package exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Kristian Lindbjerg
 */
public class Eksempel {
    public static void main(String[] args) {
        
// Opretter ny exception
        double withdrawValue = 0;
        
        if (withdrawValue < 0) {
            String errmsg = "withdraw value " +
                "cannot be negative";
            throw new IllegalArgumentException(errmsg);
        }
        
// Fange exeptions
        String s = "42 ";
        int input = -1;

        try {
            input = Integer.parseInt(s.trim());
        }
        catch (NumberFormatException e) {
            System.out.println("NumberFormatException: ”+ e.getMessage()");
        }
        
        // fil findes ikke
        try {
            String filename = "";
            Scanner in = new Scanner(new File(filename));
            in.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Filen fandtes ikke");
        }

    }
}
