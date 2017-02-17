package opgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class LaesFilTilTreeSet {
    private static Set<String> output;
    
    public static void main(String[] args) throws FileNotFoundException {
        output = new TreeSet<>();
        int count = 0;
        File file = new File("Gjøngehøvdingen.txt");
        Scanner scan = new Scanner(file);
        scan.useDelimiter("(\\p{javaWhitespace}|\\.|,|:|;|\\?|\"|!|-)+");
        while (scan.hasNext()) {
            count++;
            output.add(scan.next().toLowerCase());
        }
        scan.close();
        System.out.println(output);
        System.out.println("Unikke ord: " + output.size());
        System.out.println("Ord i alt: " + count);

        for (int i = 0; i < output.size(); i++) {

        }
        
    }

}
