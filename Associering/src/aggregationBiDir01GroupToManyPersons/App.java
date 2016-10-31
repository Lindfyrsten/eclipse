package aggregationBiDir01GroupToManyPersons;

public class App {
    public static void main(String[] args) {
        Group g1 = new Group("TeamA");
        
        Person p1 = g1.createPerson("Ulla");
        
        System.out.println(p1.getGroup());
        g1.createPerson("Jens");
        
        System.out.printf("%s's persons: %s.%n", g1, g1.getPersons());
        System.out.println();
        
        g1.removePerson(p1);
        
        System.out.printf("%s's persons: %s.%n", g1, g1.getPersons());
        
        Person p2 = new Person("Peter");
        p2.setGroup(g1);
        
        System.out.printf("%s's persons: %s.%n", g1, g1.getPersons());
        System.out.println();

    }
}
