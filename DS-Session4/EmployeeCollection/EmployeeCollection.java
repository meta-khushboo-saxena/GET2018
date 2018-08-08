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

		Collections.sort(employeeList,
				(Employee employee1, Employee employee2) -> employee1.getId() - employee2.getId());
		return employeeList;
	}

	/**
	 * Function to sort the employee list
	 * 
	 * @return
	 */
	public List<Employee> sotingByName() {
		Collections.sort(employeeList,
				(Employee employee1, Employee employee2) -> employee1.getName().compareTo(employee2.getName()));
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
		int uniqueId = id;
		if ((employeeList).stream().anyMatch(employee -> employee.getId() == id)) {
			System.out.println("!!Employee already Added!!");
			return false;
		} else {
			Employee employee = new Employee(name, uniqueId, address);
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
		employee.addEmployee("khushboo", 23, "sdsfd");
		employee.addEmployee("dfsd", 23, "sdsfd");
	}
}
