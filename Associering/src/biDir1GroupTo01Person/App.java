package biDir1GroupTo01Person;

public class App {
    public static void main(String[] args) {
        Group g1 = new Group("TeamA");
        
        Person p1 = new Person("Ulla", g1);
        
        System.out.printf("%s's person: %s.%n", g1, g1.getPerson());
        System.out.printf("%s's group: %s.%n", p1, p1.getGroup());
        System.out.println();
        
        Group g2 = new Group("TeamB");
        g2.setPerson(p1);

        System.out.printf("%s's person: %s.%n", g1, g1.getPerson());
        System.out.printf("%s's person: %s.%n", g2, g2.getPerson());
        System.out.printf("%s's group: %s.%n", p1, p1.getGroup());
        System.out.println();
        
        Person p2 = new Person("Jens", g1);

        System.out.printf("%s's person: %s.%n", g1, g1.getPerson());
        System.out.printf("%s's person: %s.%n", g2, g2.getPerson());
        System.out.printf("%s's group: %s.%n", p2, p2.getGroup());
        System.out.printf("%s's group: %s.%n", p1, p1.getGroup());
        System.out.println();
        
    }
}
