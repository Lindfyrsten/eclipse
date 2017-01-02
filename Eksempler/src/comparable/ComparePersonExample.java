package comparable;

/**
 * @author Kristian Lindbjerg
 */

public class ComparePersonExample implements Comparable<ComparePersonExample> { // Implement Comparable interface and specify which object to compare

    private String name;
    private int age;

    public ComparePersonExample(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    //---------------------------------------------------------------------------
    // overrides the compareTo method from the interface to specify how we are
    // going to compare this specific object.
    // Return 0 means it's equal
    // Return 1 or any positive number means it after in the natural order
    // Return -1 or any negative number means it comes first in the natural order
    //---------------------------------------------------------------------------
    @Override
    public int compareTo(ComparePersonExample o) {
        //we want to compare first by age and if age is equal then compare by name
        //first we check if age is the same, because if so, then we can skip that and compare name instead.
        
        // note: compareTo does not work on primitive types, therefor we use this.age - o.getAge()
        // which will return the correct order
        // for example if this person's age is 10 and o's age is 12, the result would be 10-12 = -2
        // which would mean this.age is lower or comes first in the natural order etc.
        
        if (age == o.getAge()) { //we call the get methods of the references object to compare
            return name.compareTo(o.getName());
        }
        else {
            return age - o.getAge();
        }
    }

    @Override
    public String toString() {
        return name + " " + age;
    }

}
