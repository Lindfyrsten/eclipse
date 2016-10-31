package uniDir01GroupToManyPersons;

public class App {
    public static void main(String[] args) {
        Group g1 = new Group("TeamA");
        
        Person p1 = new Person("Ulla");
        g1.addPersons(p1);
        
        Person p2 = new Person("Jens");
        g1.addPersons(p2);
        
        System.out.printf("%s's persons: %s.%n", g1, g1.getPersons());
        
        g1.removePerson(p1);
        
        System.out.printf("%s's persons: %s.%n", g1, g1.getPersons());
    }
}
