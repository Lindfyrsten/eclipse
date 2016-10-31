package uniDirManyPersonTo01Group;

public class App {
    public static void main(String[] args) {
        Person p1 = new Person("Ulla");
        Group g1 = new Group("TeamA");

        p1.setGroup(g1);

        System.out.printf("%s's group: %s.%n", p1, p1.getGroup());

        p1.setGroup(null);

        System.out.printf("%s's group: %s.%n", p1, p1.getGroup());
    }
}
