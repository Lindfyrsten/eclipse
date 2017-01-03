package sortering;

import java.util.ArrayList;

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

    public static void insertioneSort(ArrayList<String> list) {
        for (int i = 1; i < list.size(); i++) {
            String next = list.get(i);
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
