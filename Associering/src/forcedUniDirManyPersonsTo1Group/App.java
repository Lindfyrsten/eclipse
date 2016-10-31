package forcedUniDirManyPersonsTo1Group;

public class App {
    public static void main(String[] args) {
        Group g1 = new Group("TeamA");
        Person p1 = new Person("Ulla", g1);

        System.out.printf("%s's group: %s.%n", p1, p1.getGroup());

        Group g2 = new Group("TeamB");
        p1.setGroup(g2);

        System.out.printf("%s's group: %s.%n", p1, p1.getGroup());
    }
}
