package com.employee;

/**
 * Class containing all queries
 */
public class Queries {

	public static final String insertQuery = "insert into employee_detail(first_name,last_name,email,age)VALUES" + " (?,?,?,?) ";
	public static final String selectQuery = "SELECT id,first_name,last_name,email,age FROM employee_detail";
	public static final String searchQuery = "SELECT * FROM employee_detail WHERE first_name = ? AND last_name = ? ";
	public static final String selectQueryWithId = "SELECT * FROM employee_detail WHERE id = ? ";
	public static final String updateQuery = "UPDATE employee_detail SET first_name = ? , last_name = ? , email = ? , age = ? "
			+ " WHERE id = ?";
	public static final String selectQueryByEmail = "SELECT * FROM employee_detail WHERE email = ?";
}