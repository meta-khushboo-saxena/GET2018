package com.metacube.training.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.daoInterface.EmployeeDAO;
import com.metacube.training.dto.ForgotPasswordToken;
import com.metacube.training.model.Employee;
import com.metacube.training.serviceInterface.EmployeeServiceInterface;

/**
 * Class to provide interface between controller and dao
 */
@Service
public class EmployeeServiceImplement implements EmployeeServiceInterface {

	@Autowired
	private EmployeeDAO employeeDAO;

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
		System.out.println("enter employee");
		Employee employeeDetail = getInfoByEmail(employee.getEmailId());
		System.out.println("after get email");
		if (employeeDetail != null) {
			return false;
		}
		return employeeDAO.create(employee);
	}

	/**
	 * Function to get the information of employee by email
	 * 
	 * @params email
	 * @return employee
	 */
	public Employee getInfoByEmail(String email) {
		return employeeDAO.getInfoByEmail(email);
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
			return employeeDAO.getInfoByName(attributeName);
		} else if (filter.equals("project")) {
			return employeeDAO.getInfoByProject(attributeName);
		} else if (filter.equals("skills")) {
			return employeeDAO.getInfoBySkills(attributeName);
		} else {
			return employeeDAO.getInfoByExperience(attributeName);
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

		if (employeeDAO.validateLogin(email, password) != null) {
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
		return employeeDAO.resetPassword(email, oldPassword, newPassword);
	}

	/**
	 * Function to forgot password
	 * 
	 * @params email
	 * @params newPassword
	 * @return boolean
	 */
	public Boolean forgotPassword(String email, String newPassword) {
		Employee employeeDetail = getInfoByEmail(email);
		if (employeeDetail != null) {
			return employeeDAO.forgotPassword(email, newPassword);
		}
		return false;
	}

	@Override
	public ForgotPasswordToken getToken(String email) {
		Employee employeeDetail = getInfoByEmail(email);
		if (employeeDetail != null) {
			ForgotPasswordToken forgotPasswordToken = new ForgotPasswordToken();
			forgotPasswordToken.setTokenId(employeeDetail.getToken());
			return forgotPasswordToken;
		}
		return null;
	}
}
