package sortering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import model.Customer;

public class TestApp {
    public static void main(String[] args) {
        String[] s = { "Erna", "Elly", "Laurits", "Bertha", "Christian",
            "August", "Marius", "John", "Tove", "Poul", "Torkild" };
        System.out.println(Arrays.toString(s));
//        SelectionSort.selectionSort(s);
//        bubbleSort(s);
        InsertionSortering.insertioneSort(s);
        System.out.println(Arrays.toString(s));

        System.out.println("******************************");

        Customer c1 = new Customer("Nielsen", "Per", 19);
        Customer c2 = new Customer("Andersen", "Søren", 19);
        Customer c3 = new Customer("Andersen", "Ninna", 19);
        Customer c4 = new Customer("Wurtze", "Sebastian", 19);
        Customer c5 = new Customer("Clementin", "Gustav", 19);
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        customers.add(c4);
        customers.add(c5);
        System.out.println(customers.toString());
//        SelectionSort.selectionSortCustomer(customers);
//        InsertionSortering.insertioneSort(customers);
        Collections.sort(customers);
        System.out.println(customers.toString());

    }
}
