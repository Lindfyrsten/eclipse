package model.model;

/**
 * Write a description of class Person here.
 *
 * @author (Margrethe Dybdahl)
 * @version (16/09/2016)
 */
public class Person {
    private String firstName;
    private String middleName;
    private String lastName;
    private int dayOfBirth; // 1..31
    private int monthOfBirth; // 1..12
    private int yearOfBirth; // 1900..2010
    private boolean leapYear;
    
    /**
     * Constructor for objects of class Person
     */
    
    public Person(String firstName, String middleName, String lastName,
        int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;

    }

    public Person(String firstName, String lastName,
        int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;

    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getMiddleName() {
        return this.middleName;
    }
    
    public void setMiddleName(String middleName) {

        this.middleName = middleName;
        
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void printPerson() {
        System.out.println(firstName + " " + middleName + " " + lastName + " "
            + dayOfBirth + "." + monthOfBirth + "." + yearOfBirth);
        
    }
    
    public String getInit() {
        
        if (middleName != null) {
            return "" + firstName.charAt(0) + middleName.charAt(0)
                + lastName.charAt(0);
        }
        
        else {
            return "" + firstName.substring(0, 2).toUpperCase() + lastName.charAt(0);
        }
    }
    
    public String getUserName() {

        if (middleName == null) {

            String tekst1 = firstName.substring(0, 2).toUpperCase();
            String tekst2 = "" + (firstName.length() - lastName.length());
            String tekst3 = lastName.substring(0, 2).toLowerCase();
            return tekst1 + tekst2 + tekst3;

        }
        String tekst1 = firstName.substring(0, 2).toUpperCase();
        String tekst2 = middleName.length() + "";
        String tekst3 = lastName.substring(lastName.length() - 2);
        return tekst1 + tekst2 + tekst3;
        
    }
    
    public int age(int dayToDay, int monthToDay, int yearToDay) {
        int age = -1 + yearToDay - yearOfBirth;

        if (monthOfBirth == monthToDay && dayOfBirth <= dayToDay) {
            age++;
            
        }
        else if (monthOfBirth < monthToDay) {
            age++;
        }
        return age;
    }
    
    /**
     * Returns whether year is a leapyear
     *
     * @param year
     * @return
     */
    public boolean leapYear(int year) {
        
        if (year % 100 == 0 && !((year % 400) == 0)) {
            leapYear = false;
        }

        else if (year % 4 == 0 && !((year % 100 == 0))) {
            leapYear = true;
            
        }
        else {
            leapYear = false;
        }
        return leapYear;

    }
}
