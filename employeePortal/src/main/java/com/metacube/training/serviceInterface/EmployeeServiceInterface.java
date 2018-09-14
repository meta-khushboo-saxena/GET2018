package com.metacube.training.serviceInterface;

import java.util.List;

import com.metacube.training.dto.ForgotPasswordToken;
import com.metacube.training.model.Employee;

public interface EmployeeServiceInterface extends BaseService<Employee> {
	public Employee getInfoByEmail(String email);

	public List<Employee> searchBy(String filter, String attributeName);

	public Boolean validateLogin(String email, String password);

	public Boolean resetPassword(String email, String oldPassword,
			String newPassword);

	public Boolean forgotPassword(String email, String newPassword);
	
	public Boolean insertToken(ForgotPasswordToken forgotPasswordToken);
	
	public ForgotPasswordToken getToken(String email);
	
	public Boolean deleteToken(String email) ;
	
	public Boolean reset(String email , String password);
}
