package EmployeeCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class containing the collection of Employee
 */
public class EmployeeCollection {

	private List<Employee> employeeList = new ArrayList<Employee>();

	/**
	 * Function to sort the employee according to the employee id
	 * 
	 * @return
	 */
	public List<Employee> naturalSorting() {
		if (this.employeeList.size() == 0) {
			System.out.println("!!No data to sort!!");
		} else {
			Collections.sort(this.employeeList,
					(Employee employee1, Employee employee2) -> employee1.getId() - employee2.getId());
		}
		return employeeList;
	}

	/**
	 * Function to sort the employee list
	 * 
	 * @return
	 */
	public List<Employee> sotingByName() {
		if (this.employeeList.size() == 0) {
			System.out.println("!!No data to sort!!");
		} else {
			Collections.sort(this.employeeList,
					(Employee employee1, Employee employee2) -> employee1.getName().compareTo(employee2.getName()));
		}
		return employeeList;
	}

	/**
	 * Function to add new Employee in the list
	 * 
	 * @param name
	 * @param id
	 * @param address
	 * @return true when added
	 */
	public boolean addEmployee(String name, int id, String address) {

		if ((this.employeeList).stream().anyMatch(employee -> employee.getId() == id)) {
			System.out.println("!!Employee already Added!!");
			return false;
		} else {
			Employee employee = new Employee(name, id, address);
			employeeList.add(employee);
		}
		return true;
	}

	/**
	 * main function
	 * 
	 * @param arg
	 */
	public static void main(String arg[]) {
		EmployeeCollection employee = new EmployeeCollection();
		employee.naturalSorting();
		employee.sotingByName();
		employee.addEmployee("khushboo", 23, "Aligarh");
		employee.addEmployee("Ananya", 23, "Jaipur");
	}
}
