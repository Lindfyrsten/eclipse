package opgave4_5_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FilFletningFælles {
    
    public static void main(String[] args) {
        String path1 = "C:/Users/Kristian/Dropbox/Programmering/talfil.txt";
        String path2 = "C:/Users/Kristian/Dropbox/Programmering/talfil2.txt";
        String pathFlettet = "C:/Users/Kristian/Dropbox/Programmering/talfilFlettet.txt";
        String pathFælles = "C:/Users/Kristian/Dropbox/Programmering/talfilFælles.txt";
        fletAlleHeltal(path1, path2, pathFlettet);
        findfællesTal(path1, path2, pathFælles);
    }
    
    /**
     * Laver en sorteret fil i fileNameNy der indeholder alle
     * heltal fra fileName1 og fileName2 (MAX_VALUE skal ikke i
     * resultatet)
     * Krav: filename1 og filename2 er navne på to sorterede filer.
     */
    public static void fletAlleHeltal(String fileName1, String fileName2, String fileNameNy) {
        ArrayList<Integer> printList = new ArrayList<>();
        File file1 = new File(fileName1);
        File file2 = new File(fileName2);
        
        try {
            Scanner scan1 = new Scanner(file1);
            Scanner scan2 = new Scanner(file2);
            while (scan1.hasNextInt() && scan2.hasNextInt()) {
                printList.add(scan1.nextInt());
                printList.add(scan2.nextInt());
            }
            while (scan1.hasNextInt()) {
                printList.add(scan1.nextInt());
            }
            while (scan2.hasNextInt()) {
                printList.add(scan2.nextInt());
            }
            scan1.close();
            scan2.close();
            
            Collections.sort(printList);
            
            PrintWriter printWriter = new PrintWriter(fileNameNy);

            for (int i : printList) {
                printWriter.println(i);
            }
            printWriter.flush();
            printWriter.close();
            
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }

    /**
     * Laver en sorteret fil i fileNameNy der indeholder alle
     * heltal som de to filer har til fælles
     * Krav: filename1 og filename2 er navne på to sorterede filer.
     */
    public static void findfællesTal(String fileName1, String fileName2, String fileNameNy) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        File file1 = new File(fileName1);
        File file2 = new File(fileName2);
        try {
            Scanner scan1 = new Scanner(file1);
            Scanner scan2 = new Scanner(file2);
            PrintWriter printWriter = new PrintWriter(fileNameNy);
            while (scan1.hasNextInt() && scan2.hasNextInt()) {
                list1.add(scan1.nextInt());
                list2.add(scan2.nextInt());
            }
            while (scan1.hasNextInt()) {
                list1.add(scan1.nextInt());
            }
            while (scan2.hasNextInt()) {
                list2.add(scan2.nextInt());
            }
            scan1.close();
            scan2.close();
            
            Collections.sort(list1);
            Collections.sort(list2);
            int i1 = 0;
            int i2 = 0;
            while (i1 < list1.size() && i2 < list2.size()) {
                if (list1.get(i1) < list2.get(i2)) {
                    i1++;
                }
                else
                    if (list1.get(i1) > list2.get(i2)) {
                        i2++;
                    }
                    else {
                        printWriter.println(list1.get(i1));
                        i1++;
                        i2++;
                    }
            }
            
            printWriter.flush();
            printWriter.close();
            
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
