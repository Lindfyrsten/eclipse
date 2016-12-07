package filer;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ScannerRead {
    
    public static void main(String[] args) {
        try {
            File filein = new File("C:/Users/Lindbjerg/Dropbox/Programmering/tal.txt");
            Scanner scan = new Scanner(filein);
            while (scan.hasNext()) {
                System.out.println(scan.nextLine());
            }
            scan.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
