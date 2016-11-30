package soegningelevopgaver;

import java.util.ArrayList;

public class SoegningApp {
    
    public static void main(String[] args) {
        Soegning s = new Soegning();
        
        // Kode til afprøvning af opgave 1
        
//        int[] talArray = { 2, 4, 8, 2 };
//        int[] talArrayUdvidet = { 7, 56, 34, 3, 7, 14, 13, 4 };
//        int[] talArrayDuplicate = { 7, 8, 8, 10 };
//        System.out.println("Er der et ulige tal i talArray ? " + s.findUlige(talArray));
//        talArray[2] = 15;
//        System.out.println("Er der et ulige tal i talArray ? " + s.findUlige(talArray));
//
        // Her tilføjes kode til at afprøve opgaverne 2,3,5,6 og 7
        
        //oggave 2
//        System.out
//            .println("Første hele tag mellem 10 og 15 : " + s.findHeltalInterval(talArrayUdvidet));

        //opgave 3
        
//        System.out
//            .println("Findes der nabo duplicates? " + s.findNeighbourDuplicate(talArrayDuplicate));

        //opgave 4
//        Spiller spiller1 = new Spiller("Kristian", 188, 80, 50);
//        Spiller spiller2 = new Spiller("Christiano", 186, 84, 22);
//        Spiller spiller3 = new Spiller("Lionel", 148, 48, 2);
//        Spiller spiller4 = new Spiller("Batistuta", 194, 87, 25);
//        ArrayList<Spiller> spillere = new ArrayList<>();
//        spillere.add(spiller1);
//        spillere.add(spiller4);
//        spillere.add(spiller2);
//        spillere.add(spiller3);
//        Spillermetoder sm = new Spillermetoder();

        //4.1
//        System.out.println("Spiller med 25 mål: " + sm.findScoreLinear(spillere, 25));
        
        //4.2
//        System.out.println("Spiller med 2 mål: " + sm.findScoreBineær(spillere, 2));
        
        //4.3
//        System.out.println("Spiller over 170cm, som har score 50 eller flere mål: "
//            + sm.findSpillerHøjdeScore(spillere));

        //opgave 5
        System.out.println("Heltalskvadratroden af 111 =  " + s.findSquareRootLineær(111));
        System.out.println("Heltalskvadratroden af 10 =  " + s.findSquareRootBinær(10));

        //opgave 6

        System.out.println("********Opgave 6*********");
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(6);
        arr1.add(4);
        arr1.add(8);
        arr1.add(13);
        arr1.add(2);
        System.out.println(arr1);
        System.out.println("Nye index for tallet 13: " + s.swapFind(arr1, 13));
        System.out.println(arr1);
        
        System.out.println(-3 % 2);
    }
    
}
