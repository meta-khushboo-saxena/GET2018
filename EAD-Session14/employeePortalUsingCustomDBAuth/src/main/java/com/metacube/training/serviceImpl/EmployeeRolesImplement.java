package com.metacube.training.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeRole;
import com.metacube.training.repository.EmployeeRolesRepository;
import com.metacube.training.serviceInterface.EmployeeRolesService;

@Service
public class EmployeeRolesImplement implements EmployeeRolesService {

	@Autowired
	private EmployeeRolesRepository<Employee> empRolesRepo;

	@Override
	public List<EmployeeRole> getInfoByEmail(String email) {
		return empRolesRepo.findByEmail(email);
	}
}
