package application.service;

import java.util.ArrayList;

import application.model.Company;
import application.model.Employee;
import storage.Storage;

public class Service {
    /**
     * Creates a new Company.<br />
     * Requires: hours >= 0.
     */
    public static Company createCompany(String name, int hours) {
        Company company = new Company(name, hours);
        Storage.addCompany(company);
        return company;
    }
    
    /**
     * Deletes the company.<br />
     * Requires: The company has no employees.
     */
    public static void deleteCompany(Company company) {
        Storage.removeCompany(company);
    }
    
    /**
     * Updates the company.<br />
     * Requires: hours >= 0.
     */
    public static void updateCompany(Company company, String name, int hours) {
        company.setName(name);
        company.setHours(hours);
    }
    
    /**
     * Get all the companies
     */
    public static ArrayList<Company> getCompanies() {
        return Storage.getCompanies();
    }
    
    // -------------------------------------------------------------------------
    
    /**
     * Creates a new employee.<br />
     * Requires: wage >= 0.
     */
    public static Employee createEmployee(String name, int wage, int employeeYear) {
        Employee employee = new Employee(name, wage);
        employee.setEmployeeYear(employeeYear);
        Storage.addEmployee(employee);
        return employee;
    }
    
    /**
     * Creates a new employee.<br />
     * Requires: wage >= 0, company!=null.
     */
    public static Employee createEmployee(String name, int wage, int employeeYear,
        Company company) {
        Employee employee = createEmployee(name, wage, employeeYear);
        company.addEmployee(employee);
        return employee;
    }
    
    /**
     * Deletes the employee.
     */
    public static void deleteEmployee(Employee employee) {
        Company company = employee.getCompany();
        if (company != null) {
            company.removeEmployee(employee);
        }
        Storage.removeEmployee(employee);
    }
    
    /**
     * Updates the employee.<br />
     * Requires: wage >= 0.
     */
    public static void updateEmployee(Employee employee, String name, int wage, int employeeYear,
        Company company) {
        employee.setName(name);
        employee.setWage(wage);
        employee.setEmployeeYear(employeeYear);
        employee.setCompany(company);
    }

    /**
     * Get all the employees.
     */
    public static ArrayList<Employee> getEmployees() {
        return Storage.getEmployees();
    }
    
    // -------------------------------------------------------------------------
    
    /**
     * Initializes the storage with some objects.
     */
    public static void initStorage() {
        Company c1 = Service.createCompany("IBM", 37);
        Company c2 = Service.createCompany("AMD", 40);
        Service.createCompany("SLED", 45);
        Service.createCompany("Vector", 32);
        
        Service.createEmployee("Bob Dole", 210, 2010, c2);
        Service.createEmployee("Alice Schmidt", 250, 1999, c1);
        Service.createEmployee("George Down", 150, 1810, c2);
        
        Service.createEmployee("Rita Uphill", 300, 2015);
    }
    
    public static void init() {
        
        initStorage();
        
    }
    
}
