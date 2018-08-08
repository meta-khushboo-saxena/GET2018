package EmployeeCollection;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {
	EmployeeCollection employee = new EmployeeCollection();

	@Before
	public void testAddEmployee() {
		employee.addEmployee("khushboo", 23, "sdsfd");
		employee.addEmployee("Ananya", 44, "sdsfd");
		employee.addEmployee("Richa", 66, "sdsfd");
		employee.addEmployee("Himanshi", 77, "sdsfd");
		employee.addEmployee("Prerna", 12, "sdsfd");
	}

	@Test
	public void testAddEmployee1() {
		boolean result = employee.addEmployee("Nikhil", 12, "sdsfd");
		assertEquals(false, result);
	}

	@Test
	public void testAddEmployee2() {
		boolean result = employee.addEmployee("Somi", 45, "sdsfd");
		assertEquals(true, result);
	}

	@Test
	public void testNaturalSorting() {

		List<Employee> employeeList = employee.naturalSorting();
		employeeList.get(0).getId();

		assertEquals(employeeList.get(0).getId(), 12);
		assertEquals(employeeList.get(1).getId(), 23);
	}

	@Test
	public void testSotingByName() {

		List<Employee> employeeList = employee.sotingByName();
		employeeList.get(0).getId();

		assertEquals(employeeList.get(0).getName(), "Ananya");
		assertEquals(employeeList.get(1).getName(), "Himanshi");
	}
}
