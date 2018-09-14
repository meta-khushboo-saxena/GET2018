package com.metacube.training.daoInterface;

import java.util.List;

import com.metacube.training.dto.ForgotPasswordToken;
import com.metacube.training.model.Employee;

public interface EmployeeDAO extends BaseDAO<Employee> {

	public Employee getInfoByEmail(String email);

	public List<Employee> getInfoByName(String name);

	public List<Employee> getInfoByProject(String project);

	public List<Employee> getInfoBySkills(String skills);

	public List<Employee> getInfoByExperience(String experience);

	public boolean resetPassword(String email, String oldPassword,
			String newPassword);

	public boolean forgotPassword(String email, String newPassword);

	public Employee validateLogin(String email, String password);

	public Boolean insertToken(ForgotPasswordToken forgotPasswordToken);

	public boolean deleteToken(String email);

	public Boolean reset(String email, String password);
}
