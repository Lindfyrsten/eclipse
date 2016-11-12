package application.model;

public class Costumer {
    private String firstName;
    private String lastName;
    private int age;

    public Costumer(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        
    }
    
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public int getAge() {
        return age;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
}
