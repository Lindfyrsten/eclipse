package forcedUniDir1PersonToManyGroups;

public class App {
    public static void main(String[] args) {
        Group g1 = new Group("TeamA");
        new Person("Ulla", g1);
        new Person("Lone", g1);

        System.out.printf("%s's persons: %s.%n", g1, g1.getPersons());

    }
}
