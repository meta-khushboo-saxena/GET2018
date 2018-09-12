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
			+ "profile_picture, password) "
			+ "VALUES "
			+ "(?,?,?,?,?,?,?,?,?,?)";
	private final String SQL_GET_ALL = "SELECT * FROM employee WHERE enabled = 'true' ";

	private final String SQL_FIND_EMPLOYEE = "SELECT * FROM employee WHERE code = ?";

	private final String SQL_UPDATE_EMPLOYEE = "UPDATE employee SET first_name = ? , middle_name = ? , last_name = ? , dob = ? , gender = ?,"
			+ " email = ? , contact = ? , skype_id = ? , profile_picture = ? WHERE code = ?";

	private final String SQL_GET_EMPLOYEE_BY_EMAIL = "SELECT * FROM employee WHERE email = ? ";

	private final String SQL_Disable_Employee = "UPDATE employee SET enabled = 'false'  WHERE code = ?";

	private final String SQL_GET_EMPLOYEE_BY_NAME = "SELECT * FROM employee WHERE first_name = ? ";

	private final String SQL_GET_EMPLOYEE_BY_PROJECT = "SELECT * FROM employee as E INNER JOIN employee_project EP on E.code = EP.employee_code"
			+ " INNER JOIN project_master as PM  on PM.project_id = EP.project_id"
			+ " WHERE PM.name = ? AND enabled = 'true'";

	private final String SQL_GET_EMPLOYEE_BY_SKILLS = "SELECT * FROM employee as E INNER JOIN employee_skills ES on E.code = ES.employee_code"
			+ " INNER JOIN skill_master as SM  on SM.skill_id = ES.skill_code"
			+ " WHERE SM.skill_name = ? AND enabled = 'true'; ";

	private final String SQL_GET_EMPLOYEE_BY_EXPERIENCE = "SELECT * FROM employee as E INNER JOIN job_details JD on E.code = JD.employee_code"
			+ " WHERE JD.total_experience  = ? ";

	private final String SQL_VALIDATE_LOGIN = "SELECT * FROM employee WHERE email = ? AND password = ?";

	private final String SQL_UPDATE_PASSWORD = "UPDATE employee SET password = ? WHERE email = ? AND password = ? ";

	@Override
	public boolean create(Employee employee) {
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(SQL_INSERT_EMPLOYEE);) {
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
				PreparedStatement statement = conn
						.prepareStatement(SQL_FIND_EMPLOYEE);) {
			try {
				statement.setInt(1, id);
				ResultSet resultSet = statement.executeQuery();
				if (resultSet.next()) {

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
					employee.setProfilePicture(resultSet
							.getString("profile_picture"));
					employee.setPassword(resultSet.getString("password"));

					return employee;
				}
				return null;
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
				PreparedStatement statement = conn
						.prepareStatement(SQL_GET_ALL);) {
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
					employee.setProfilePicture(resultSet
							.getString("profile_picture"));
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
				PreparedStatement statement = conn
						.prepareStatement(SQL_Disable_Employee);) {
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
				PreparedStatement statement = conn
						.prepareStatement(SQL_UPDATE_EMPLOYEE);) {
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

	/**
	 * Function to get the information of the employee by email
	 * 
	 * @param email
	 * @return employee
	 */
	public Employee getInfoByEmail(String email) {
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(SQL_GET_EMPLOYEE_BY_EMAIL);) {
			try {
				statement.setString(1, email);
				ResultSet resultSet = statement.executeQuery();
				if (resultSet.next()) {

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
					employee.setProfilePicture(resultSet
							.getString("profile_picture"));
					employee.setPassword(resultSet.getString("password"));

					return employee;
				}
				return null;

			} catch (SQLException ex) {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	/**
	 * Function to get the information of the employee by name
	 * 
	 * @param name
	 * @return list of employees
	 */
	public List<Employee> getInfoByName(String name) {
		List<Employee> employeeList = new ArrayList<Employee>();
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(SQL_GET_EMPLOYEE_BY_NAME);) {
			try {
				statement.setString(1, name);
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
					employee.setProfilePicture(resultSet
							.getString("profile_picture"));
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

	/**
	 * Function to get the information of the employee by project
	 * 
	 * @param project
	 * @return list of employees
	 */
	public List<Employee> getInfoByProject(String project) {
		List<Employee> employeeList = new ArrayList<Employee>();
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(SQL_GET_EMPLOYEE_BY_PROJECT);) {
			try {
				statement.setString(1, project);
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
					employee.setProfilePicture(resultSet
							.getString("profile_picture"));
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

	/**
	 * Function to get the information of the employee by skills
	 * 
	 * @param skills
	 * @return list of employees
	 */
	public List<Employee> getInfoBySkills(String skills) {
		List<Employee> employeeList = new ArrayList<Employee>();
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(SQL_GET_EMPLOYEE_BY_SKILLS);) {
			try {
				statement.setString(1, skills);
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
					employee.setProfilePicture(resultSet
							.getString("profile_picture"));
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

	/**
	 * Function to get the information of the employee by experience
	 * 
	 * @param experience
	 * @return list of employees
	 */
	public List<Employee> getInfoByExperience(String experience) {
		List<Employee> employeeList = new ArrayList<Employee>();
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(SQL_GET_EMPLOYEE_BY_EXPERIENCE);) {
			try {
				statement.setString(1, experience);
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
					employee.setProfilePicture(resultSet
							.getString("profile_picture"));
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

	/**
	 * Function to validate login of employee
	 * 
	 * @params email
	 * @params password
	 * @return boolean
	 */
	public Employee validateLogin(String email, String password) {
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(SQL_VALIDATE_LOGIN);) {
			try {
				statement.setString(1, email);
				statement.setString(2, password);
				ResultSet resultSet = statement.executeQuery();
				if (resultSet.next()) {

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
					employee.setProfilePicture(resultSet
							.getString("profile_picture"));
					employee.setPassword(resultSet.getString("password"));

					return employee;
				}
				return null;

			} catch (SQLException ex) {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	/**
	 * Function to reset the password
	 *
	 * @param email
	 * @param oldPassword
	 * @param newPassword
	 * @return boolean
	 */
	public boolean resetPassword(String email, String oldPassword,
			String newPassword) {
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(SQL_UPDATE_PASSWORD);) {
			try {
				statement.setString(1, newPassword);
				statement.setString(2, email);
				statement.setString(3, oldPassword);
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
