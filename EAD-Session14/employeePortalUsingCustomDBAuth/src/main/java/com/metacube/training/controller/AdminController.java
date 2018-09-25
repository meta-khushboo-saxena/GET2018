package com.metacube.training.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.metacube.training.serviceInterface.EmployeeServiceInterface;

/**
 * Class to perform various operations of admin
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	EmployeeServiceInterface employeeService;

	/**
	 * Function to redirect to dashboard
	 * 
	 * @return string
	 */
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard() {
		return "admin/dashboard";
	}
}