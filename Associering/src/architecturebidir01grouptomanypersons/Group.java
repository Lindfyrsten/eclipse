package architecturebidir01grouptomanypersons;

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
     * Pre: person != null, person is not attached to a group
     */
    public void addPerson(Person person) {
        persons.add(person);
        if (person.getGroup() != this) {
            person.setGroup(this);
        }
        
    }
    
    /**
     * Removes the person from this group.
     */
    public void removePerson(Person person) {
        persons.remove(person);
        if (person.getGroup() == this) {
            person.setGroup(null);
        }
        
    }
}
