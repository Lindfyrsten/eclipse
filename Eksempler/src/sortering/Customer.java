package sortering;

import java.util.ArrayList;

public class Customer implements Comparable<Customer> {
    private String lastName;
    private String firstName;
    private int age;

    public Customer(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    @Override
    public int compareTo(Customer customer) {
        if (lastName.equals(customer.getLastName())) {
            return firstName.compareTo(customer.getFirstName());
        }
        else {
            return lastName.compareTo(customer.getLastName());
        }
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public static void indsætKunde(ArrayList<Customer> customers, Customer customer) {
        boolean found = false;
        int i = 0;
        while (!found && i < customers.size()) {
            if (customers.get(i).compareTo(customer) > 0) {
                found = true;

            }
            i++;
        }
        if (found) {
            customers.add(i - 1, customer);
        }
        
    }

    public static void indsætKunde(Customer[] customers, Customer customer) {
        int j = customers.length - 1;
        while (customers[j] == null && j >= 0) {
            j--;
        }
        j++;
        boolean found = false;
        while (!found && j > 0) {
            System.out.println();
            if (customer.compareTo(customers[j - 1]) > 0) {
                found = true;
            }
            else {
                customers[j] = customers[j - 1];
                j--;
            }
            customers[j] = customer;
        }

    }
    
    @Override
    public String toString() {
        return lastName + " " + firstName + " " + age;
    }
}
