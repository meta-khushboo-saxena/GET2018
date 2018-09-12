package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.dao.DAOInterface;
import com.metacube.training.dao.EmployeeDAO;
import com.metacube.training.model.Employee;

/**
 * Class to provide interface between controller and dao
 */
@Service
public class EmployeeServiceImplement implements ServiceInterface<Employee> {

	@Autowired
	private DAOInterface<Employee> employeeDAO;

	@Override
	public Employee getInfoById(int id) {
		return employeeDAO.getInfoById(id);
	}

	@Override
	public List<Employee> getAllInfo() {
		return employeeDAO.getAllInfo();
	}

	@Override
	public boolean deleteInfo(int id) {
		return employeeDAO.deleteInfo(id);
	}

	@Override
	public boolean updateInfo(Employee employee) {
		return employeeDAO.updateInfo(employee);
	}

	@Override
	public boolean create(Employee employee) {
		Employee employeeDetail = getInfoByEmail(employee.getEmailId());
		if (employeeDetail != null) {
			return false;
		}
		employeeDAO.create(employee);
		return true;
	}

	/**
	 * Function to get the information of employee by email
	 * 
	 * @params email
	 * @return employee
	 */
	public Employee getInfoByEmail(String email) {
		return ((EmployeeDAO) employeeDAO).getInfoByEmail(email);
	}

	/**
	 * Function to get the information of employee by filter
	 * 
	 * @params filter
	 * @params attributeName
	 * @return list of employee
	 */
	public List<Employee> searchBy(String filter, String attributeName) {
		if (filter.equals("name")) {
			return ((EmployeeDAO) employeeDAO).getInfoByName(attributeName);
		} else if (filter.equals("project")) {
			return ((EmployeeDAO) employeeDAO).getInfoByProject(attributeName);
		} else if (filter.equals("skills")) {
			return ((EmployeeDAO) employeeDAO).getInfoBySkills(attributeName);
		} else {
			return ((EmployeeDAO) employeeDAO)
					.getInfoByExperience(attributeName);
		}
	}

	/**
	 * Function to validate login of employee
	 * 
	 * @params email
	 * @params password
	 * @return boolean
	 */
	public Boolean validateLogin(String email, String password) {
		Employee employee = ((EmployeeDAO) employeeDAO).validateLogin(email,
				password);
		if (employee != null) {
			return true;
		}
		return false;
	}

	/**
	 * Function to reset password
	 * 
	 * @params email
	 * @params oldPassword
	 * @params newPassword
	 * @return boolean
	 */
	public Boolean resetPassword(String email, String oldPassword,
			String newPassword) {
		return ((EmployeeDAO) employeeDAO).resetPassword(email, oldPassword,
				newPassword);

	}
}
