package application.service;

import java.util.ArrayList;

import application.model.Company;
import application.model.Customer;
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
	public static Employee createEmployee(String name, int wage, int employmentYear) {
		Employee employee = new Employee(name, wage);
		employee.setEmploymentYear(employmentYear);
		Storage.addEmployee(employee);
		return employee;
	}

	/**
	 * Creates a new employee.<br />
	 * Requires: wage >= 0, company!=null.
	 */
	public static Employee createEmployee(String name, int wage, int employmentYear, Company company) {
		Employee employee = new Employee(name, wage);
		employee.setEmploymentYear(employmentYear);
		company.addEmployee(employee);
		employee.setCompany(company);
		Storage.addEmployee(employee);
		return employee;
	}

	/**
	 * Deletes the employee.
	 */
	public static void deleteEmployee(Employee employee) {
		Company company = employee.getCompany();
		if (company != null) {
			company.removeEmployee(employee);
			employee.setCompany(null);
		}
		Storage.removeEmployee(employee);
	}

	/**
	 * Updates the employee.<br />
	 * Requires: wage >= 0.
	 */
	public static void updateEmployee(Employee employee, String name, int wage, int employmentYear) {
		employee.setName(name);
		employee.setWage(wage);
		employee.setEmploymentYear(employmentYear);
	}

	/**
	 * Get all the employees.
	 */
	public static ArrayList<Employee> getEmployees() {
		return Storage.getEmployees();
	}

	// -------------------------------------------------------------------------

	/**
	 * Updates the employee's company.
	 */
	public static void connectEmployeeToCompany(Employee employee, Company company) {
		Company oldCompany = employee.getCompany();
		if (oldCompany != null) {
			oldCompany.removeEmployee(employee);
			employee.setCompany(null);
		}
		employee.setCompany(company);
		company.addEmployee(employee);
	}

	/**
	 * Clears the company of the employee.
	 */
	public static void clearCompanyOfEmployee(Employee employee) {
		Company company = employee.getCompany();
		if (company != null) {
			company.removeEmployee(employee);
			employee.setCompany(null);
		}
	}

	// -------------------------------------------------------------------------

	public static Customer createCustomer(String name) {
		Customer customer = new Customer(name);
		Storage.addCustomer(customer);
		return customer;
	}

	public static void deleteCustomer(Customer customer) {
		Storage.removeCustomer(customer);
	}

	public static void updateCustomer(Customer customer, String name) {
		customer.setName(name);
	}

	public static ArrayList<Customer> getCustomers() {
		return Storage.getCustomers();
	}

	/**
	 * Updates the employee's company.
	 */
	public static void connectCustomerToCompany(Customer customer, Company company) {

		company.addCustomer(customer);
	}

	/**
	 * Clears the company of the employee.
	 */
	public static void clearCustomerCompany(Customer customer, Company company) {
		company.removeCustomer(customer);
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

		Employee e1 = Service.createEmployee("Bob Dole", 210, 2012, c2);
		Employee e2 = Service.createEmployee("Alice Schmidt", 250, 2011, c1);
		Employee e3 = Service.createEmployee("George Down", 150, 2013, c2);

		Service.createEmployee("Rita Uphill", 300, 2014);

		Customer cu1 = Service.createCustomer("Jane Jensen");
		Customer cu2 = Service.createCustomer("Lene Christensen");
		Customer cu3 = Service.createCustomer("Mette Sørensen");

		Service.connectCustomerToCompany(cu1, c1);
		Service.connectCustomerToCompany(cu2, c1);
		Service.connectCustomerToCompany(cu3, c2);
	}

	public static void init() {

		initStorage();

	}

}
