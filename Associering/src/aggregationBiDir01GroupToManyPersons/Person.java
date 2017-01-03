package aggregationBiDir01GroupToManyPersons;

public class Person {
    private String name;
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
    
    public Group getGroup() {
        return group;
    }
    
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
