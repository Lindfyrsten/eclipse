package architecturebidir1grouptomanypersons;

public class Service {
    /**
     * Creates a new person linked to the group. group != null
     */
    public static Person createPerson(String name, Group group) {
        
        Person person = new Person(name, group);
        
        // add the person to storage
        Storage.addPerson(person);
        return person;
    }
    
    /**
     * Deletes the person.
     */
    public static void deletePerson(Person person) {
        // remove an existing link from a group to the person
        Group group = person.getGroup();
        if (group != null) {
            group.removePerson(person);
        }
        // remove person from storage
        Storage.removePerson(person);
    }
    
}
