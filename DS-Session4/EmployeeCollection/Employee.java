package EmployeeCollection;

/**
 * Class Employee
 */
public class Employee {

	private String name;
	private int uniqueId;
	private String address;

	/**
	 * Constructer to set the name, id and address of employee
	 * 
	 * @param name
	 * @param uniqueId
	 * @param address
	 */
	public Employee(String name, int uniqueId, String address) {
		this.name = name;
		this.uniqueId = uniqueId;
		this.address = address;
	}

	/**
	 * Function to get the name of the employee
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Function to get the Id of the employee
	 * 
	 * @return
	 */
	public int getId() {
		return this.uniqueId;
	}

	/**
	 * Function to get the Address of the employee
	 * 
	 * @return
	 */
	public String getAddress() {
		return address;
	}
}
