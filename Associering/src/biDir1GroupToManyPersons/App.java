package biDir1GroupToManyPersons;

public class App {
    public static void main(String[] args) {
        Group g1 = new Group("TeamA");

        Person p1 = new Person("Ulla", g1);
        
        Person p2 = new Person("Jens", g1);

        System.out.printf("%s's persons: %s.%n", g1, g1.getPersons());
        System.out.printf("%s's group: %s.%n", p1, p1.getGroup());
        System.out.printf("%s's group: %s.%n", p2, p2.getGroup());
        System.out.println();

        Group g2 = new Group("TeamB");

        g1.removePerson(p1);
        g2.addPerson(p1); //    eller  p1.setGroup(g2);
//
        System.out.printf("%s's persons: %s.%n", g1, g1.getPersons());
        System.out.printf("%s's persons: %s.%n", g2, g2.getPersons());
        
        System.out.printf("%s's group: %s.%n", p1, p1.getGroup());
        System.out.printf("%s's group: %s.%n", p2, p2.getGroup());
    }
}
