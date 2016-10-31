package biDirManyGroupsToManyPersons;

public class App {
    public static void main(String[] args) {
        Group g1 = new Group("TeamA");
        
        Person p1 = new Person("Ulla");
        g1.addPersons(p1);

        Person p2 = new Person("Jens");
        p2.addGroup(g1);
        
        Group g2 = new Group("TeamB");
        g2.addPersons(p1);
        
        System.out.printf("%s's persons: %s.%n", g1, g1.getPersons());
        System.out.printf("%s's persons: %s.%n", g2, g2.getPersons());
        System.out.printf("%s's groups: %s.%n", p1, p1.getGroups());
        System.out.printf("%s's groups: %s.%n", p2, p2.getGroups());
        System.out.println();
        
        g1.removePerson(p1);
        
        System.out.printf("%s's persons: %s.%n", g1, g1.getPersons());
        System.out.printf("%s's persons: %s.%n", g2, g2.getPersons());
        System.out.printf("%s's groups: %s.%n", p1, p1.getGroups());
        System.out.printf("%s's groups: %s.%n", p2, p2.getGroups());
    }
}
