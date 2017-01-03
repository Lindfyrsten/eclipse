package sortering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TestApp {
    public static void main(String[] args) {
// String[] s = { "Erna", "Elly", "Laurits", "Bertha", "Christian",
// "August", "Marius", "John", "Tove", "Poul", "Torkild" };
// System.out.println(Arrays.toString(s));
// SelectionSort.selectionSort(s);
// SortMethods.bubbleSort(s);
// InsertionSortering.insertioneSort(s);
// System.out.println(Arrays.toString(s));
//
// System.out.println("******************************");
        
        Customer c1 = new Customer("Nielsen", "Per", 19);
        Customer c2 = new Customer("Andersen", "Søren", 19);
        Customer c3 = new Customer("Andersen", "Ninna", 19);
        Customer c4 = new Customer("Wurtze", "Sebastian", 19);
        Customer c5 = new Customer("Clementin", "Gustav", 19);
        Customer c6 = new Customer("Delta", "Børge", 95);
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        customers.add(c4);
        customers.add(c5);
        Collections.sort(customers);
        System.out.println(customers.toString());
        Customer.indsætKunde(customers, c6);
        System.out.println(customers.toString());

        Customer[] customerArr = { c2, c3, c5, c1, c4, null, null, null, null };
        System.out.println(Arrays.toString(customerArr));
        
        Customer.indsætKunde(customerArr, c6);
        System.out.println(Arrays.toString(customerArr));
        
        SelectionSort.selectionSortCustomer(customers);
        System.out.println(customers.toString());
        
        System.out.println(SortMethods.findEnsIRække("Jubiiii", 2));
        System.out.println(SortMethods.findEnsIRække("Jubiiii", 5));

    }
}
