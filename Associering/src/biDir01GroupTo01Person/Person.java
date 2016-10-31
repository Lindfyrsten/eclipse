package biDir01GroupTo01Person;

public class Person {
    private String name;
    // link to Group object (--> 0..1)
    private Group group;
    
    public Person(String name) {
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
     * Returns the group of this person. Note: Returns null, if this person has
     * no group.
     */
    public Group getGroup() {
        return group;
    }
    
    /**
     * Sets the group of this person.
     * Pre: group is not connected to any person
     */
    public void setGroup(Group group) {
        Group oldGroup = this.group;
        this.group = group;
        if (oldGroup != null) {
            oldGroup.setPerson(null);
            
        }
        if (group != null && group.getPerson() != this) {
            group.setPerson(this);
        }
        
    }
}
