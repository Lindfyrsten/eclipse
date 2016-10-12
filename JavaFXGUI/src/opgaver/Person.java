package opgaver;

public class Person {
    private String firstName;
    private String lastName;
    
    private String email;
    private boolean senior = false;
    
    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public boolean isSenior() {
        return senior;
    }
    
    public void setSenior(boolean senior) {
        this.senior = senior;
    }
    
    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + email + ")" + " | Senior:  " + senior;
    }
    
}
