package compositionUniDirGroupToManyPersons;

public class App {
    public static void main(String[] args) {
        Group g1 = new Group("TeamA");

        Person p1 = g1.createPerson("Ulla");
        g1.createPerson("Jens");

        System.out.printf("%s's persons: %s.%n", g1, g1.getPersons());
        System.out.println();

        g1.deletePerson(p1);

        System.out.printf("%s's persons: %s.%n", g1, g1.getPersons());
    }
}
