package application.model;

import java.io.Serializable;

public class Employee implements Serializable {
    private String name;
    private int wage; // hourly wage
    
    // link to company class (--> 0..1)
    private Company company;
    
    // Opgave1
    private int employmentYear;
    
    public Employee(String name, int wage) {
        this.name = name;
        this.wage = wage;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getWage() {
        return wage;
    }
    
    public void setWage(int wage) {
        this.wage = wage;
    }
    
    @Override
    public String toString() {
        return name + " (kr " + wage + ")";
    }
    
    // -----------------------------------------------------------------------------
    
    public Company getCompany() {
        return company;
    }
    
    public void setCompany(Company company) {
        this.company = company;
    }
    
    // -----------------------------------------------------------------------------
    
    /**
     * Returns the weekly salary of this employee.
     */
    public int weeklySalary() {
        int salary = wage * company.getHours();
        return salary;
    }
    
    public int getEmploymentYear() {
        return employmentYear;
    }
    
    public void setEmploymentYear(int employmentYear) {
        this.employmentYear = employmentYear;
    }
    
}
