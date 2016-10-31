package architecturebidir1grouptomanypersons;

public class App {
    public static void main(String[] args) {
        Group g1 = new Group("TeamA");
        
        Person p1 = Service.createPerson("Ulla", g1);
        Person p2 = Service.createPerson("Jens", g1);
        
        System.out.printf("%s's persons: %s.%n", g1, g1.getPersons());
        for (Person p : Storage.getAllPersons()) {
            System.out.printf("%s's group: %s.%n", p, p.getGroup());
        }
        System.out.println();
        
        Service.deletePerson(p1);
        
        System.out.printf("%s's persons: %s.%n", g1, g1.getPersons());
        for (Person p : Storage.getAllPersons()) {
            System.out.printf("%s's group: %s.%n", p, p.getGroup());
        }
        
        System.out.println();
        
    }
}
