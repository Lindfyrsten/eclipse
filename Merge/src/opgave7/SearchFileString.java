
package opgave7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchFileString {

    public static void main(String[] args) {
        String fileName = "C:/Users/Lindbjerg/Dropbox/Programmering/personer.txt";
        System.out.println(linFileSearchPerson(fileName, "Jensen"));
    }

    public static String linFileSearchPerson(String fileName, String target) {
        
        boolean found = false;
        File filein = new File(fileName);
        String result = null;
        try {
            Scanner scan = new Scanner(filein);
            while (scan.hasNextLine() && !found) {
                result = scan.nextLine();
                if (result.endsWith(target)) {
                    found = true;
                }

            }
            scan.close();
        }
        catch (FileNotFoundException e) {
            e.getMessage();
        }
        
        if (found) {
            return result;
        }
        else {
            
            return "Ingen person fundet";
        }

    }

}
