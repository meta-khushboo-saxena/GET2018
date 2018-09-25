package com.metacube.training.serviceInterface;

import java.util.List;
import com.metacube.training.model.EmployeeRole;

public interface EmployeeRolesService {

	List<EmployeeRole> getInfoByEmail(String email);
}
