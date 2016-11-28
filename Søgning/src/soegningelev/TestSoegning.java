package soegningelev;

import java.util.ArrayList;

public class TestSoegning {
    
    public static void main(String[] args) {
        //	Soegning soeg = new Soegning();
        
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Lakrids");
        strings.add("Vingummi");
        strings.add("Marsbar");
        strings.add("Twix");
        strings.add("Peaunuts");
        strings.add("Chokolade");
        strings.add("Bridge blanding");
        
        int i = SoegningNote.linearSearchList(strings, "Twix");
        int j = strings.indexOf("Twix");
        System.out.println("Twix er på plads: " + i + " " + j);
        i = SoegningNote.linearSearchList(strings, "Bounty");
        j = strings.indexOf("Bounty");
        System.out.println("Bounty er på plads: " + i + " " + j);
        
        ArrayList<Kunde> kunder = new ArrayList<>();
        kunder.add(new Kunde("Ann", 1, 1234));
        kunder.add(new Kunde("Bente", 2, 3333));
        kunder.add(new Kunde("Dann", 3, 45555));
        kunder.add(new Kunde("Finn", 4, 66666));
        kunder.add(new Kunde("Hans", 5, 77777));
        
        Kunde k = SoegningNote.linearSearchKunde(kunder, "Finn");
        System.out.println(k);
        k = SoegningNote.linearSearchKunde(kunder, "Jane");
        System.out.println(k);
//
//		k = Soegning.binSearchList(kunder,"Finn");
//		System.out.println(k);
//		k = Soegning.binSearchList(kunder,"Jane");
//		System.out.println(k);
//
//
//		int[] arr = {2,4,6,8,9,12,24,26,37};
//		i = Soegning.binSearchArray(arr, 8);
//		System.out.println("8 er på plads: " + i);
//		i = Soegning.binSearchArray(arr, 10);
//		System.out.println("10 er på plads: " + i);
//
    
    }
    
}
