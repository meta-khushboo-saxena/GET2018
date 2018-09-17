package com.metacube.training.serviceInterface;

import java.util.List;

import com.metacube.training.dto.ForgotPasswordToken;
import com.metacube.training.model.Employee;

public interface EmployeeServiceInterface {

	List<Employee> getAllInfo();

	Employee getInfoById(int id);

	boolean deleteInfo(int id);

	boolean updateInfo(Employee employee);

	boolean create(Employee employee);

	public Employee getInfoByEmail(String email);

	public List<Employee> searchBy(String filter, String attributeName);

	public Boolean validateLogin(String email, String password);

	public Boolean resetPassword(String email, String oldPassword,
			String newPassword);

	public Boolean forgotPassword(String email, String newPassword);

	public ForgotPasswordToken getToken(String email);

}
