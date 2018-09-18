package com.metacube.training.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	/**
	 * Function to move to login page
	 * 
	 * @return string
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "admin/login";
	}

	/**
	 * Function to validate email and paassword of admin and redirect to
	 * dashboard page
	 * 
	 * @param email
	 * @param password
	 * @param model
	 *            : object to store the error message
	 * @return string
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email,
			@RequestParam("password") String password, Model model) {
		if (email.equalsIgnoreCase("admin@gmail.com")
				&& password.equals("123456")) {
			return "admin/dashboard";
		}
		model.addAttribute("error", "error");
		return "admin/login";
	}

	/**
	 * Function to logout the user
	 * 
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "admin/login";
	}
}