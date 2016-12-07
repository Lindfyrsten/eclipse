package opgave4_5_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchFile {

    public static void main(String[] args) {

        System.out
            .println(linFileSearch("C:/Users/Kristian/Dropbox/Programmering/talfil.txt", 959));
        
    }

    public static boolean linFileSearch(String filNavn, int target) {

        boolean found = false;
        File filein = new File(filNavn);
        
        try {
            Scanner scan = new Scanner(filein);
            while (scan.hasNextInt() && !found) {
                if (scan.nextInt() == target) {
                    found = true;
                }
            }
            scan.close();
        }
        catch (FileNotFoundException e) {
            e.getMessage();
        }

        return found;
    }
}
