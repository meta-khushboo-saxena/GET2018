package EmployeeCollection;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {
	EmployeeCollection employee = new EmployeeCollection();

	@Before
	public void testAddEmployee() {
		employee.addEmployee("Khushboo", 23, "Aligarh");
		employee.addEmployee("Ananya", 44, "Patna");
		employee.addEmployee("Richa", 66, "Jaipur");
		employee.addEmployee("Himanshi", 77, "Delhi");
		employee.addEmployee("Prerna", 12, "Noida");
	}

	@Test
	public void testAddEmployee1() {
		boolean result = employee.addEmployee("Nikhil", 12, "Aligarh");
		assertEquals(false, result);
	}

	@Test
	public void testAddEmployee2() {
		boolean result = employee.addEmployee("Somi", 45, "Jaipur");
		assertEquals(true, result);
	}

	@Test
	public void testNaturalSorting() {

		List<Employee> employeeList = employee.naturalSorting();
		assertEquals(employeeList.get(0).getId(), 12);
		assertEquals(employeeList.get(1).getId(), 23);
		assertEquals(employeeList.get(2).getId(), 44);
		assertEquals(employeeList.get(3).getId(), 66);
		assertEquals(employeeList.get(4).getId(), 77);
	}

	@Test
	public void testSotingByName() {

		List<Employee> employeeList = employee.sotingByName();
		assertEquals(employeeList.get(0).getName(), "Ananya");
		assertEquals(employeeList.get(1).getName(), "Himanshi");
		assertEquals(employeeList.get(2).getName(), "Khushboo");
		assertEquals(employeeList.get(3).getName(), "Prerna");
		assertEquals(employeeList.get(4).getName(), "Richa");
	}

}
