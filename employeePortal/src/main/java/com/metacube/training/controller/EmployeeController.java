package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.training.dto.EmailDetail;
import com.metacube.training.model.Employee;
import com.metacube.training.service.EmailServiceImplement;
import com.metacube.training.service.EmployeeServiceImplement;
import com.metacube.training.service.ServiceInterface;

/**
 * Employee controller class
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	ServiceInterface<Employee> employeeService;

	@Autowired
	EmailServiceImplement emailServiceImplement;

	/**
	 * Function to redirect to dashboard
	 * 
	 * @return string
	 */
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard(@ModelAttribute("email") String email) {
		return "employee/dashboard";
		// return "employee/dashboard?email=" + email;
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
			view = "employee/dashboard";
			model.addAttribute("email", email);
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
	public String showProfile(Model model, @RequestParam("email") String email) {
		model.addAttribute("employee",
				((EmployeeServiceImplement) employeeService)
						.getInfoByEmail(email));
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
	public String resetPasssword(Model model,
			@RequestParam("email") String email) {
		model.addAttribute("email", email);
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
	public String resetPasssword(@RequestParam("email") String email,
			@RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword,
			@RequestParam("confirmPassword") String confirmPassword, Model model) {
		String view;
		if (confirmPassword.equals(newPassword) && oldPassword != ""
				&& confirmPassword != null) {
			((EmployeeServiceImplement) employeeService).resetPassword(email,
					oldPassword, newPassword);
			view = "employee/login";
		} else {
			view = "employee/resetPassword";
			model.addAttribute("error", "error");
		}
		return view;
	}

	/**
	 * Function to redirect to forgot Password page
	 * 
	 * @param email
	 * @param model
	 * @return view
	 */
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
	public String forgotPasssword() {
		return "employee/forgotPassword";
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
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public String forgotPasssword(@RequestParam("email") String email,
			Model model) {
		if (email != "") {
			Employee employee = ((EmployeeServiceImplement) employeeService)
					.getInfoByEmail(email);

			if (employee != null) {
				EmailDetail emailDetail = new EmailDetail();

				emailDetail.setFirstName(employee.getFirstName());
				emailDetail.setLastname(employee.getLastName());
				emailDetail.setEmailAddress(employee.getEmailId());
				emailDetail.setPassword(employee.getPassword());

				emailServiceImplement.sendEmail(emailDetail, "RESET PASSWORD");
				return "employee/login";
			}
		}
		model.addAttribute("error", "error");
		return "employee/forgotPassword";
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
