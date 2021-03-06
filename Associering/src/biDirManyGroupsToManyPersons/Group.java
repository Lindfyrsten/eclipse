package biDirManyGroupsToManyPersons;

import java.util.ArrayList;

public class Group {
    private String name;
    // link to Person objects (--> 0..*)
    private ArrayList<Person> persons = new ArrayList<>();
    
    public Group(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    // -------------------------------------------------------------------------
    
    /**
     * Returns a list of persons in this group.
     */
    public ArrayList<Person> getPersons() {
        return new ArrayList<>(persons);
    }
    
    /**
     * Adds the person to this group.
     * Pre: The group do not already have the person
     */
    public void addPersons(Person person) {
        
        persons.add(person);
        if (!person.getGroups().contains(this)) {
            person.addGroup(this);
        }
        
    }
    
    /**
     * Removes the person from this group.
     */
    public void removePerson(Person person) {
        persons.remove(person);
        if (person.getGroups().contains(this)) {
            person.removeGroup(this);
        }
        
    }
}
