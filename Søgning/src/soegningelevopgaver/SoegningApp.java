package soegningelevopgaver;

public class SoegningApp {
    
    public static void main(String[] args) {
        Soegning s = new Soegning();
        
        // Kode til afprøvning af opgave 1
        int[] talArray = { 2, 4, 8, 2 };
        int[] talArrayUdvidet = { 7, 56, 34, 3, 7, 14, 13, 4 };
        int[] talArrayDuplicate = { 7, 8, 8, 10 };
        System.out.println("Er der et ulige tal i talArray ? " + s.findUlige(talArray));
        talArray[2] = 15;
        System.out.println("Er der et ulige tal i talArray ? " + s.findUlige(talArray));
        
        // Her tilføjes kode til at afprøve opgaverne 2,3,5,6 og 7
        
        System.out
            .println("Første hele tag mellem 10 og 15 : " + s.findHeltalInterval(talArrayUdvidet));
        System.out
            .println("Findes der nabo duplicates? " + s.findNeighbourDuplicate(talArrayDuplicate));
        System.out.println(s.findSquareRoot(111));

    }
    
}
