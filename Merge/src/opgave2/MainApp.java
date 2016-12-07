package opgave2;

import java.util.ArrayList;
import java.util.Arrays;

public class MainApp {
    
    public static void main(String[] args) {
        int[] l1 = { 2, 4, 6, 8, 10, 12, 14 };
        int[] l2 = { 1, 2, 4, 5, 6, 9, 12, 17 };

        System.out.println(Arrays.toString(fællesTal(l1, l2)));

    }

    /**
     * Returnerer et sorteret array der indeholder alle
     * elementer l1 og l2 har til fælles
     * Krav: l1 og l2 er sorterede, indeholder ikke dubletter og
     * indeholder ikke tomme pladser
     */
    public static int[] fællesTal(int[] l1, int[] l2) {
        ArrayList<Integer> result = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        int count = 0;
        while (i1 < l1.length && i2 < l2.length) {
            if (l1[i1] < l2[i2]) {
                i1++;
            }
            else if (l1[i1] > l2[i2]) {
                i2++;
            }
            else {
                result.add(l1[i1]);
                count++;
                i1++;
                i2++;
            }
        }
        int[] list = new int[count];
        for (int i = 0; i < list.length; i++) {
            list[i] = result.get(i);
        }
        return list;
    }
    
}
