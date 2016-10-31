package uniDir01PersonTo01Group.copy;

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
     * Returns the group of this person.
     * Note: Returns null, if this person has no group.
     */
    public Group getGroup() {
        return group;
    }
    
    /**
     * Sets the group of this person.
     * Pre: No other person is connected to the group.
     */
    public void setGroup(Group group) {
        this.group = group;
    }
    
}
