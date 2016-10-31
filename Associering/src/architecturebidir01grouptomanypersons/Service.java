package architecturebidir01grouptomanypersons;

public class Service {
    /**
     * Creates a new person linked to the group.
     */
    public static Person createPerson(String name, Group group) {
        
        Person person = new Person(name);
        // set the bidirectional link
        person.setGroup(group);
        // group.addPerson(person);
        // add the person to storage
        Storage.addPerson(person);
        return person;
    }
    
    /**
     * Creates a new person
     */
    public static Person createPerson(String name) {
        
        Person person = new Person(name);
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
    
    /**
     *
     * Connects the person and the group.
     */
    public static void connectPersonToGroup(Person person, Group group) {
        
        group.addPerson(person);
    }
    
}
