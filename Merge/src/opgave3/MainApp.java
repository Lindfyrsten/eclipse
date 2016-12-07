package opgave3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainApp {

    public static void main(String[] args) {

        Customer c1 = new Customer("Per", "Larsen", 37);
        Customer c2 = new Customer("Bente", "Hansen", 25);
        Customer c3 = new Customer("Willie", "Larsen", 54);
        Customer c4 = new Customer("Bent", "Jensen", 64);
        Customer c5 = new Customer("Per", "Toft", 25);
        Customer c6 = new Customer("Per", "Larsen", 15);

        ArrayList<Customer> l1 = new ArrayList<>();
        Customer[] l2 = { c3, c5, c6 };

        l1.add(c1);
        l1.add(c2);
        l1.add(c3);
        l1.add(c4);

        Collections.sort(l1);
        Arrays.sort(l2);
        System.out.println(goodCustomers(l1, l2).toString());

    }
    
    /**
     * Returnerer en sorteret ArrayList der indeholder alle
     * kunder fra både l1 og l2
     * Krav: l1 og l2 er sorterede
     */
    public static ArrayList<Customer> goodCustomers(ArrayList<Customer> l1,
        Customer[] l2) {
        int i1 = 0;
        int i2 = 0;
        ArrayList<Customer> list = new ArrayList<>();

        while (i1 < l1.size() && i2 < l2.length) {
            if (l1.get(i1).compareTo(l2[i2]) != 0) {
                list.add(l1.get(i1));
                i1++;
            }
            
            else {
                i1++;
                i2++;
            }
        }
        while (i1 < l1.size()) {
            list.add(l1.get(i1));
            i1++;
        }

        return list;
    }
}
