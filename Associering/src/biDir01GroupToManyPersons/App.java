package biDir01GroupToManyPersons;

public class App {
    public static void main(String[] args) {
        Group g1 = new Group("TeamA");
        
        Person p1 = new Person("Ulla");
//        g1.addPerson(p1);
        p1.setGroup(g1);
        
        Person p2 = new Person("Jens");
        g1.addPerson(p2);
        // p2.setGroup(g1);
        
        System.out.printf("%s's persons: %s.%n", g1, g1.getPersons());
        System.out.printf("%s's group: %s.%n", p1, p1.getGroup());
        System.out.printf("%s's group: %s.%n", p2, p2.getGroup());
        System.out.println();
        
        g1.removePerson(p1);
        // p1.setGroup(null);
//
        System.out.printf("%s's persons: %s.%n", g1, g1.getPersons());
        System.out.printf("%s's group: %s.%n", p2, p2.getGroup());
    }
}
