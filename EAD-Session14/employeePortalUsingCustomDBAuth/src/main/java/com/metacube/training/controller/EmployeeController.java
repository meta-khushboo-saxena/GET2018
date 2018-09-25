package com.metacube.training.controller;

import java.security.Principal;

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

import com.metacube.training.dto.ResetPassword;
import com.metacube.training.dto.ResetPasswordDetail;
import com.metacube.training.dto.SearchEmployee;
import com.metacube.training.model.Employee;
import com.metacube.training.serviceInterface.EmployeeServiceInterface;

/**
 * Employee controller class
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeServiceInterface employeeService;

	@Autowired
	HttpSession session;

	/**
	 * Function to redirect to dashboard
	 * 
	 * @return string
	 */
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard(@ModelAttribute("username") String email) {
		return "employee/dashboard";
	}

	/**
	 * Function to show profile page
	 * 
	 * @param model
	 * @param email
	 * @return string
	 */
	@RequestMapping(value = "/showProfile", method = RequestMethod.GET)
	public String showProfile(Model model, Principal principal) {
		model.addAttribute("employee",
				employeeService.getInfoByEmail(principal.getName()));
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
			System.out.println(status);
		} else {
			employeeService.updateInfo(employee);
			return "redirect:showEmployee";
		}
		if (status) {
			// emailServiceImplement.emailDetails(employee);
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
		model.addAttribute("searchEmployee", new SearchEmployee());
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
			@ModelAttribute("searchEmployee") SearchEmployee searchEmployee,
			Model model) {
		model.addAttribute("employees", employeeService.searchBy(
				searchEmployee.getSearchBy(), searchEmployee.getAttribute()));
		if (searchEmployee.getRole() == 1) {
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
	public String resetPasssword(Model model,Principal principal) {
		model.addAttribute("email", principal.getName());
		model.addAttribute("resetPassword", new ResetPassword());
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
			@ModelAttribute("resetPassword") ResetPassword resetPassword,
			@RequestParam("email") String email, Model model) {
		String view;
		if (resetPassword.getConfirmPassword().equals(
				resetPassword.getNewPassword())
				&& resetPassword.getOldPassword() != ""
				&& resetPassword.getNewPassword() != "") {
			employeeService.resetPassword(email,
					resetPassword.getOldPassword(),
					resetPassword.getNewPassword());
			view = "employee/login";
		} else {
			view = "employee/resetPassword";
			model.addAttribute("error", "error");
		}
		return view;
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
}
