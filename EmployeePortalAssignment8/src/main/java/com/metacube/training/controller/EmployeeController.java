package com.metacube.training.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.metacube.training.model.Employee;
import com.metacube.training.service.EmployeeServiceImplement;
import com.metacube.training.service.ServiceInterface;

/**
 * Employee controller class
 */
@Controller
@SessionAttributes("email")
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	ServiceInterface<Employee> employeeService;

	@Autowired
	HttpSession session;

	/**
	 * Function to redirect to dashboard
	 * 
	 * @return string
	 */
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard() {
		return "employee/dashboard";
	}

	/**
	 * Function to move to login page
	 * 
	 * @return string
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "employee/login";
	}

	/**
	 * Function to validate login page
	 * 
	 * @param email
	 * @param password
	 * @return string
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password, Model model) {
		String view;
		if (((EmployeeServiceImplement) employeeService).validateLogin(email,
				password)) {
			session.setAttribute("email", email);
			view = "employee/dashboard";
			// model.addAttribute("email", email);
		} else {
			view = "employee/login";
			model.addAttribute("error", "error");
		}
		return view;
	}

	/**
	 * Function to show profile page
	 * 
	 * @param model
	 * @param email
	 * @return string
	 */
	@RequestMapping(value = "/showProfile", method = RequestMethod.GET)
	public String showProfile(Model model) {
		model.addAttribute("employee",
				((EmployeeServiceImplement) employeeService)
						.getInfoByEmail((String) session.getAttribute("email")));
		return "employee/profile";
	}

	/**
	 * Function to update the profile
	 * 
	 * @param employee
	 * @param model
	 * @return view
	 */
	@RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
	public String showProfile(@ModelAttribute("employee") Employee employee,
			Model model) {
		employeeService.updateInfo(employee);
		model.addAttribute("email", employee.getEmailId());
		return "employee/dashboard";
	}

	/**
	 * Function to redirect to reset Password page
	 * 
	 * @param email
	 * @param model
	 * @return view
	 */
	@RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
	public String resetPasssword() {
		return "employee/resetPassword";
	}

	/**
	 * Function to reset password
	 *
	 * @param email
	 * @param oldPassword
	 * @param newPassword
	 * @param confirmPassword
	 * @param model
	 * @return view
	 */
	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public String resetPasssword(
			@RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword,
			@RequestParam("confirmPassword") String confirmPassword, Model model) {
		Boolean status = false;
		if (confirmPassword.equals(newPassword) && oldPassword != ""
				&& newPassword != "") {
			status = ((EmployeeServiceImplement) employeeService)
					.resetPassword((String)session.getAttribute("email"), oldPassword, newPassword);

		}
		if (status) {
			return "employee/login";
		} else {
			model.addAttribute("error", "error");
			return "employee/resetPassword";
		}
	}

	/**
	 * Function to logout the user
	 * 
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "employee/login";
	}
}
