package com.employee;

/**
 * Class to store the Employee details
 */
public class EmployeeDetail {
	private String firstName;
	private String lastName;
	private String email;
	private int age;

	/**
	 * Constructor to initialize the employee details
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param age
	 */
	public EmployeeDetail(String firstName, String lastName, String email, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public int getAge() {
		return age;
	}

}