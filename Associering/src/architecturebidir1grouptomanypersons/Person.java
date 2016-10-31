package architecturebidir1grouptomanypersons;

public class Person {
    private String name;
    // link to Group object (--> 1)
    private Group group;

    public Person(String name, Group group) {
        this.name = name;
        setGroup(group);
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
        Group oldGroup = this.group;
        this.group = group;
        if (oldGroup != null) {
            oldGroup.removePerson(this);
        }
        if (group != null && !group.getPersons().contains(this)) {
            group.addPerson(this);
        }

    }
}
