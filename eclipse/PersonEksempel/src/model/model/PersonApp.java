package model.model;

public class PersonApp {

    public static void main(String[] args) {
        Person p = new Person("Bent", "Christensen", 20, 4, 1987);
        p.printPerson();
        System.out.println("Initialer: " + p.getInit());
        System.out.println("Username: " + p.getUserName());

        System.out.println("Age: " + p.age(21, 9, 2016)); // p's age today
        int year = 2016;
        System.out.println("Er " + year + " skudår: " + p.leapYear(year));

    }
}
