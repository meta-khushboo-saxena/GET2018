package com.metacube.training.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.metacube.training.dto.EmailDetail;
import com.metacube.training.dto.ForgotPasswordToken;
import com.metacube.training.dto.ResetPasswordDetail;
import com.metacube.training.model.Employee;
import com.metacube.training.serviceImpl.EmailServiceImplement;
import com.metacube.training.serviceImpl.EmployeeServiceImplement;
import com.metacube.training.serviceInterface.EmployeeServiceInterface;

/**
 * Employee controller class
 */
@Controller
@SessionAttributes("email")
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeServiceInterface employeeService;

	@Autowired
	EmailServiceImplement emailServiceImplement;

	@Autowired
	HttpSession session;

	/**
	 * Function to redirect to dashboard
	 * 
	 * @return string
	 */
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard(@ModelAttribute("email") String email) {
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
	public String updateProfile(@ModelAttribute("employee") Employee employee,
			Model model) {
		employeeService.updateInfo(employee);
		model.addAttribute("email", employee.getEmailId());
		return "employee/dashboard";
	}

	/**
	 * Function to redirect to Add Employee page
	 * 
	 * @param model
	 * @return string
	 */
	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public String adminAddEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "employee/addEmployee";
	}

	/**
	 * Function to Add new Employee
	 * 
	 * @param employee
	 * @param model
	 * @return link to redirect to another page
	 */
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	public String adminAddEmployee(
			@Valid @ModelAttribute("employee") Employee employee,
			BindingResult bindingResult, Model model) {
		Boolean status = false;
		if (bindingResult.hasErrors()) {
			return "employee/addEmployee";
		}
		if (employee != null && employee.getCode() == 0) {
			status = employeeService.create(employee);
		} else {
			employeeService.updateInfo(employee);
			return "redirect:showEmployee";
		}
		if (status) {
			emailServiceImplement.emailDetails(employee);
			return "redirect:showEmployee";
		}
		model.addAttribute("error", "error");
		return "employee/addEmployee";
	}

	/**
	 * Function to redirect to show employee page
	 * 
	 * @param model
	 * @return string
	 */
	@RequestMapping(value = "/showEmployee", method = RequestMethod.GET)
	public String showEmployee(Model model) {
		model.addAttribute("employees", employeeService.getAllInfo());
		return "admin/showEmployee";
	}

	/**
	 * Function to edit the details of the employee
	 * 
	 * @param model
	 * @param code
	 * @return
	 */
	@RequestMapping(path = "/editEmployee", method = RequestMethod.GET)
	public String editEmployee(Model model, @RequestParam("id") int code) {
		model.addAttribute("employee", employeeService.getInfoById(code));
		return "employee/addEmployee";
	}

	/**
	 * Function to disable the employee
	 * 
	 * @param code
	 * @return link to redirect
	 */
	@RequestMapping(path = "/deleteEmployee", method = RequestMethod.GET)
	public String deleteEmployee(@RequestParam("id") int code) {
		employeeService.deleteInfo(code);
		return "redirect:/employee/showEmployee";
	}

	/**
	 * Function to move to search employee page
	 * 
	 * @return
	 */
	@RequestMapping(value = "/searchEmployee", method = RequestMethod.GET)
	public String searchEmployee(@RequestParam("role") int role, Model model) {
		model.addAttribute("role", role);
		return "employee/searchEmployee";
	}

	/**
	 * Function to search the employee by name , experience , skills , project
	 * 
	 * @param attributeName
	 * @param searchBy
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/searchEmployee", method = RequestMethod.POST)
	public String searchEmployee(
			@RequestParam("attribute") String attributeName,
			@RequestParam("searchBy") String searchBy,
			@RequestParam("role") int role, Model model) {
		model.addAttribute("employees",
				((EmployeeServiceImplement) employeeService).searchBy(searchBy,
						attributeName));
		if (role == 1) {
			return "admin/showEmployee";
		} else
			return "employee/showEmployee";
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
	 * Function to send mail and generate link to reset password
	 * 
	 * @param email
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(path = "/forgotPassword", method = RequestMethod.POST)
	public String generatePasswordLink(
			@RequestParam(name = "email") String email, Model model,
			HttpServletRequest request) {
		try {
			Employee employee = employeeService.getInfoByEmail(email);

			String forgetPasswordTokenString = UUID.randomUUID().toString();

			ForgotPasswordToken forgotPasswordToken = new ForgotPasswordToken();
			forgotPasswordToken.setEmail(employee.getEmailId());
			forgotPasswordToken.setToken(forgetPasswordTokenString);
			employeeService.insertToken(forgotPasswordToken);

			EmailDetail emailDetail = new EmailDetail();
			emailDetail.setFirstName(employee.getFirstName());
			emailDetail.setEmailAddress(employee.getEmailId());
			emailDetail.setPassword(employee.getPassword());
			emailDetail.setLastname(employee.getLastName());
			emailDetail.setUrl(request.getScheme() + "://"
					+ request.getServerName()
					+ ":8080/employeePortal/employee/reset?token="
					+ forgetPasswordTokenString + "&email="
					+ employee.getEmailId());
			emailServiceImplement.sendEmail(emailDetail, "RESET PASSWORD");
		} catch (Exception e) {
			model.addAttribute("message", "invalid employee code");
		}
		model.addAttribute("message", "message ");
		return "employee/login";
	}

	/**
	 * Function to redirect to reset password page
	 * 
	 * @param token
	 * @param email
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/reset", method = RequestMethod.GET)
	public String resetPassword(@RequestParam(name = "token") String token,
			@RequestParam(name = "email") String email, Model model) {
		ResetPasswordDetail resetPasswordDetail = new ResetPasswordDetail();
		resetPasswordDetail.setEmail(email);
		resetPasswordDetail.setTokenId(token);
		model.addAttribute("resetPasswordDetail", resetPasswordDetail);
		return "employee/reset";
	}

	/**
	 * Function to create new password
	 * 
	 * @param resetPasswordDetail
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/reset", method = RequestMethod.POST)
	public String updateResetPassword(
			@ModelAttribute ResetPasswordDetail resetPasswordDetail, Model model) {
		ForgotPasswordToken forgotPasswordToken = employeeService
				.getToken(resetPasswordDetail.getEmail());
		if (forgotPasswordToken != null
				&& resetPasswordDetail.getNewPassword() != null
				&& resetPasswordDetail.getNewPassword().equals(
						resetPasswordDetail.getConfirmPassword())) {
			employeeService.deleteToken(resetPasswordDetail.getEmail());
			model.addAttribute("Updated", "Updated");
		} else {
			model.addAttribute("Expired", "Expired");
		}
		return "employee/login";
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
