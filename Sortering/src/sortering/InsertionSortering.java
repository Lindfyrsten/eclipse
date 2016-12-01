package sortering;

import java.util.ArrayList;

import model.Customer;

public class InsertionSortering {

    public static void insertioneSort(String[] list) {
        for (int i = 1; i < list.length; i++) {
            String next = list[i];
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.compareTo(list[j - 1]) > 0) {
                    found = true;
                }
                else {
                    list[j] = list[j - 1];
                    j--;
                }
            }
            list[j] = next;
        }
    }

    public static void insertioneSort(ArrayList<Customer> list) {
        for (int i = 1; i < list.size(); i++) {
            Customer next = list.get(i);
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.compareTo(list.get(j - 1)) > 0) {
                    found = true;
                }
                else {
                    list.set(j, list.get(j - 1));
                    j--;
                }
            }
            list.set(j, next);
        }
    }

}
