package forcedUniDir1PersonToManyGroups;

public class Person {
    private String name;
    
    /**
     * Initialerer et person objekt
     * Pre: group!=null
     */
    public Person(String name, Group group) {
        this.name = name;
        group.addPersons(this);
    }
    
    public String getName() {
        return this.name;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
