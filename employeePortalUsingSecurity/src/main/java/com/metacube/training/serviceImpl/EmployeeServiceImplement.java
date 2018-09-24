package com.metacube.training.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dto.ForgotPasswordToken;
import com.metacube.training.model.Employee;
import com.metacube.training.repository.EmployeeRepository;
import com.metacube.training.serviceInterface.EmployeeServiceInterface;

/**
 * Class to provide interface between controller and dao
 */
@Service
public class EmployeeServiceImplement implements EmployeeServiceInterface {

	@Autowired
	private EmployeeRepository<Employee> empRepo;

	@Override
	public List<Employee> getAllInfo() {
		return empRepo.findAllEmployee();
	}

	@Override
	public Employee getInfoById(int id) {
		return empRepo.findByCode(id);
	}

	@Override
	public boolean deleteInfo(int id) {
		return empRepo.setEnabledByCode(false, id) == 1;
	}

	@Override
	public boolean updateInfo(Employee employee) {
		empRepo.updateById(employee.getCode(), employee.getFirstName(),
				employee.getMiddleName(), employee.getLastName(),
				employee.getDob(), employee.getGender(), employee.getEmailId(),
				employee.getContact(), employee.getSkypeId(),
				employee.getProfilePicture());
		return true;
	}

	@Override
	public boolean create(Employee employee) {

		Employee employeeDetail = getInfoByEmail(employee.getEmailId());
		if (employeeDetail != null) {
			return false;
		}
		empRepo.save(employee);
		return true;
	}

	@Override
	public Employee getInfoByEmail(String email) {
		return empRepo.findByEmailId(email);
	}

	@Override
	public List<Employee> searchBy(String filter, String attributeName) {
		if (filter.equals("name")) {
			return empRepo.findByFirstName(attributeName);
		} else if (filter.equals("skills")) {
			return empRepo.findByskillName(attributeName);
		} else if (filter.equals("project")) {
			return empRepo.findByProject(attributeName);
		} else if (filter.equals("experience")) {
			return empRepo.findByExperience(Integer.parseInt(attributeName));
		}
		return null;
	}

	@Override
	public Boolean validateLogin(String email, String password) {
		Employee employee = getInfoByEmail(email);
		if (employee.getEmailId().equalsIgnoreCase(email)
				&& employee.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean resetPassword(String email, String oldPassword,
			String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean forgotPassword(String email, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ForgotPasswordToken getToken(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}
