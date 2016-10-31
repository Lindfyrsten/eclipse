package biDir01GroupTo01Person;

public class App {
    public static void main(String[] args) {
        Group g1 = new Group("TeamA");

        Person p1 = new Person("Ulla");
        p1.setGroup(g1);
        
        System.out.printf("%s's person: %s.%n", g1, g1.getPerson());
        System.out.printf("%s's group: %s.%n", p1, p1.getGroup());
        System.out.println();

        Person p2 = new Person("Jens");
        g1.setPerson(p2);

        System.out.printf("%s's person: %s.%n", g1, g1.getPerson());
        System.out.printf("%s's group: %s.%n", p2, p2.getGroup());
        System.out.printf("%s's group: %s.%n", p1, p1.getGroup());
        System.out.println();
    }
}
