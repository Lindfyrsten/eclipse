package model;

import java.util.ArrayList;

public class ArrayListApp {
    
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("Hans");
        list.add("Viggo");
        list.add("Jens");
        list.add("Børge");
        list.add("Bent");

        int size = list.size();
        System.out.println("Listen indeholder " + size + " elementer."); //Udskriver antal elementer i listen

        list.add(2, "Jane"); // Tilføjer tekststrengen ”Jane” på indeks plads 2 i listen

        list.remove(1); //Sletter elementet på indeks plads 1 i listen
        list.add(1, "Pia");
        list.add("Ib");
        System.out.println("Listen indeholder nu " + list.size() + " elementer.");

        list.set(2, "Hansi");
        System.out.println("Listen indeholder nu " + list.size() + " elementer.");
        System.out.println("Listen: " + list);
        System.out.println("Længden på elementerne er: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).length() + " | ");
        }
        System.out.println("\n_______________________________");
        for (String i : list) {
            System.out.print(i.length() + " | ");
        }
    }
    
}
