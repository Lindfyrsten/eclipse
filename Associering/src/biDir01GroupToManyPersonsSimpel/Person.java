package biDir01GroupToManyPersonsSimpel;

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
     */
    public void setGroup(Group group) {
        this.group = group;
        if (!group.getPersons().contains(this)) {
            group.addPerson(this);
        }
    }
}
