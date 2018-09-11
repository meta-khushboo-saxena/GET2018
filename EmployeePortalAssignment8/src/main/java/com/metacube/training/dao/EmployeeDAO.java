package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.metacube.training.model.Employee;
import com.metacube.training.util.ConnectionManager;

/**
 * Employee dao class
 */
@Repository
public class EmployeeDAO implements DAOInterface<Employee> {

	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	// Database queries
	private final String SQL_INSERT_EMPLOYEE = " INSERT INTO employee(first_name, middle_name, last_name, dob, gender, email, contact, skype_id,"
			+ "profile_picture, password) " + "VALUES " + "(?,?,?,?,?,?,?,?,?,?)";
	private final String SQL_GET_ALL = "SELECT * FROM employee WHERE enabled = 'true' ";

	private final String SQL_FIND_EMPLOYEE = "SELECT * FROM employee WHERE code = ?";

	private final String SQL_UPDATE_EMPLOYEE = "UPDATE employee SET first_name = ? , middle_name = ? , last_name = ? , dob = ? , gender = ?,"
			+ " email = ? , contact = ? , skype_id = ? , profile_picture = ? WHERE code = ?";

	private final String SQL_Disable_Employee = "UPDATE employee SET enabled = 'false'  WHERE code = ?";

	@Override
	public boolean create(Employee employee) {
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement statement = conn.prepareStatement(SQL_INSERT_EMPLOYEE);) {
			try {
				statement.setString(1, employee.getFirstName());
				statement.setString(2, employee.getMiddleName());
				statement.setString(3, employee.getLastName());
				statement.setDate(4, employee.getDob());
				statement.setString(5, employee.getGender());
				statement.setString(6, employee.getEmailId());
				statement.setString(7, employee.getContact());
				statement.setString(8, employee.getSkypeId());
				statement.setString(9, employee.getProfilePicture());
				statement.setString(10, employee.getPassword());
				int result = statement.executeUpdate();
				if (result != 0) {
					return true;
				}
				return false;
			} catch (SQLException ex) {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public Employee getInfoById(int id) {
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement statement = conn.prepareStatement(SQL_FIND_EMPLOYEE);) {
			try {
				statement.setInt(1, id);
				ResultSet resultSet = statement.executeQuery();
				resultSet.next();

				Employee employee = new Employee();
				employee.setCode(resultSet.getInt("code"));
				employee.setFirstName(resultSet.getString("first_name"));
				employee.setMiddleName(resultSet.getString("middle_name"));
				employee.setLastName(resultSet.getString("last_name"));
				employee.setDob(resultSet.getDate("dob"));
				employee.setGender(resultSet.getString("gender"));
				employee.setEmailId(resultSet.getString("email"));
				employee.setContact(resultSet.getString("contact"));
				employee.setSkypeId(resultSet.getString("skype_id"));
				employee.setProfilePicture(resultSet.getString("profile_picture"));
				employee.setPassword(resultSet.getString("password"));

				return employee;

			} catch (SQLException ex) {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public List<Employee> getAllInfo() {
		List<Employee> employeeList = new ArrayList<Employee>();
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement statement = conn.prepareStatement(SQL_GET_ALL);) {
			try {
				ResultSet resultSet = statement.executeQuery();
				while (resultSet.next()) {

					Employee employee = new Employee();
					employee.setCode(resultSet.getInt("code"));
					employee.setFirstName(resultSet.getString("first_name"));
					employee.setMiddleName(resultSet.getString("middle_name"));
					employee.setLastName(resultSet.getString("last_name"));
					employee.setDob(resultSet.getDate("dob"));
					employee.setGender(resultSet.getString("gender"));
					employee.setEmailId(resultSet.getString("email"));
					employee.setContact(resultSet.getString("contact"));
					employee.setSkypeId(resultSet.getString("skype_id"));
					employee.setProfilePicture(resultSet.getString("profile_picture"));
					employee.setPassword(resultSet.getString("password"));

					employeeList.add(employee);
				}
				return employeeList;

			} catch (SQLException ex) {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public boolean deleteInfo(int id) {
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement statement = conn.prepareStatement(SQL_Disable_Employee);) {
			try {
				statement.setInt(1, id);
				int rows = statement.executeUpdate();
				return true;
			} catch (SQLException ex) {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean updateInfo(Employee employee) {
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement statement = conn.prepareStatement(SQL_UPDATE_EMPLOYEE);) {
			try {
				statement.setString(1, employee.getFirstName());
				statement.setString(2, employee.getMiddleName());
				statement.setString(3, employee.getLastName());
				statement.setDate(4, employee.getDob());
				statement.setString(5, employee.getGender());
				statement.setString(6, employee.getEmailId());
				statement.setString(7, employee.getContact());
				statement.setString(8, employee.getSkypeId());
				statement.setString(9, employee.getProfilePicture());
				statement.setInt(10, employee.getCode());
				int result = statement.executeUpdate();
				if (result != 0) {
					return true;
				}
				return false;
			} catch (SQLException ex) {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}
}
