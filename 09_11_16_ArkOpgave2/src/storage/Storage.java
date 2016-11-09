package storage;

import java.util.ArrayList;

import application.model.Company;
import application.model.Costumer;
import application.model.Employee;

public class Storage {
    private static ArrayList<Company> companies = new ArrayList<>();
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static ArrayList<Costumer> costumers = new ArrayList<>();
    // -------------------------------------------------------------------------
    
    public static ArrayList<Company> getCompanies() {
        return new ArrayList<>(companies);
    }
    
    public static void addCompany(Company company) {
        companies.add(company);
    }
    
    public static void removeCompany(Company company) {
        companies.remove(company);
    }
    
    // -------------------------------------------------------------------------
    
    public static ArrayList<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }
    
    public static void addEmployee(Employee employee) {
        employees.add(employee);
    }
    
    public static void removeEmployee(Employee employee) {
        employees.remove(employee);
    }
    
    // -------------------------------------------------------------------------
    
    public static ArrayList<Costumer> getCostumers() {
        return new ArrayList<>(costumers);
    }
    
    public static void addCostumer(Costumer costumer) {
        costumers.add(costumer);
    }
    
    public static void removeCostumer(Costumer costumer) {
        costumers.remove(costumer);
    }
}
