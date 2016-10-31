package architecturebidir1grouptomanypersons;

import java.util.ArrayList;

public class Storage
{
    private static ArrayList<Person> allPersons = new ArrayList<>();

    public static ArrayList<Person> getAllPersons()
    {
        return new ArrayList<>(allPersons);
    }

    public static void addPerson(Person person)
    {
        allPersons.add(person);
    }

    public static void removePerson(Person person)
    {
        allPersons.remove(person);
    }
}
