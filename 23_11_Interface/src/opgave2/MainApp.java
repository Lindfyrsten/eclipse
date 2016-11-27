package opgave2;

import java.util.Arrays;

public class MainApp {

    public static void main(String[] args) {

        Customer c1 = new Customer("Per", "Larsen", 37);
        Customer c2 = new Customer("Bente", "Hansen", 25);
        Customer c3 = new Customer("Willie", "Larsen", 54);
        Customer c4 = new Customer("Bent", "Jensen", 64);
        Customer c5 = new Customer("Per", "Toft", 25);
        Customer c6 = new Customer("Per", "Larsen", 15);

        Customer[] customers = { c1, c2, c3, c4, c5, c6 };
        for (Customer c : customers) {
            System.out.println(c.toString());

        }
        System.out.println("********************************");
        Arrays.sort(customers);

        for (Customer c : customers) {
            System.out.println(c.toString());

        }
        System.out.println("********************************");
        System.out.println(Customer.lastCustomer(customers));
        System.out.println("********************************");
        
        for (Customer c : Customer.afterCustomer(customers, c6)) {
            System.out.println(c.toString());
        }
        
    }
    
}
