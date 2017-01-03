package arrrayList;

import java.util.ArrayList;

/**
 * @author Kristian Lindbjerg
 */
public class Eksempler {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hugo");  // add tilføjer bagest i listen
        list.add("Keld");
        list.add("Børge");
        list.add("Egon");

        int size = list.size(); // size returnerer listens størrelse
        System.out.println("Listen inedholder " + size + " elementer");

        System.out.println(list.get(2)); // returnerer indholdet på plads 2 i listen
        System.out.println(list.size());
        list.add("Finn"); // tilføjer Finn bagest i listen
        list.add(1, "Dan"); // indsætter Dan på plads 1. Elementerne på plads 1 og frem rykkes en plads til højre
        list.remove(1); // sletter elementet på indeks plads 1 og rykker elementerne en plads til venstre
        list.set(1, "Ib"); // overskriver elemetet på plads 1 med Ib

        System.out.println(list);
        
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("-------------------------------------------------");
        for (String s : list) {
            System.out.println(s);
        }
        
    }

}
