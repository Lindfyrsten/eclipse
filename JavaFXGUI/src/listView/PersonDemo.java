package listView;

public class PersonDemo
{
    private String firstName;
    private String lastName;
    private String email;

    public PersonDemo(String firstName, String lastName, String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getEmail()
    {
        return this.email;
    }

    @Override
    public String toString()
    {
        return firstName + " " + lastName + " (" + email + ")";
    }

}
