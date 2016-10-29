package model;

/**
 * A Passenger for a Flight
 */
public class Passenger {
    private String name;
    private int age;
    
    /**
     * Constructs a passenger with a name and an age
     * @param name
     * @param age
     */
    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Gets the name of the passenger
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the passenger
     * Precondition: name is not empty or null
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the age of the passenger
     * @return
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Sets the age of the passenger
     * Precondition: age >= 0;
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }
    
    
}
