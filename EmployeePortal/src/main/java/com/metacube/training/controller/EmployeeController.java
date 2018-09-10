package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.training.model.Employee;
import com.metacube.training.service.EmployeeServiceImplement;
import com.metacube.training.service.ServiceInterface;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	ServiceInterface<Employee> employeeService;

	/**
	 * Function to redirect to dashboard
	 * 
	 * @return string
	 */
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard(@ModelAttribute("email") String email) {
		return "employee/dashboard?email=" + email;
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
	 * @return
	 */
	@RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
	public String showProfile(@ModelAttribute("employee") Employee employee,
			Model model) {
		employeeService.updateInfo(employee);
		model.addAttribute("email", employee.getEmailId());
		return "employee/dashboard";
	}

	@RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
	public String resetPasssword(Model model,
			@RequestParam("email") String email) {
		model.addAttribute("email", email);
		return "employee/resetPassword";
	}

	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public String resetPasssword(@RequestParam("email") String email,
			@RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword,
			@RequestParam("confirmPassword") String confirmPassword, Model model) {
		String view;
		if (confirmPassword.equals(newPassword)) {
			((EmployeeServiceImplement) employeeService).resetPassword(email,
					oldPassword, newPassword);
			view = "employee/login";
		} else {
			view = "employee/resetPassword";
			model.addAttribute("error", "error");
		}
		return view;
	}
	// @RequestMapping(value = "/login", method = RequestMethod.GET)
	// public String login() {
	//
	// return "employee/login";
	// }
	//
	// @RequestMapping(value = "/login", method = RequestMethod.POST)
	// public ModelAndView login(@RequestParam("username") String username,
	// @RequestParam("password") String password){
	//
	// String view;
	// EmployeeService employeeService = EmployeeServiceImpl.getInstance();
	//
	// if(employeeService.isValidLogin(username, password))
	// view = "employee/dashboard";
	// else
	// view = "employee/login";
	//
	// return new ModelAndView(view, "email", username);
	// }
	//
	// @RequestMapping(value = "/editProfile", method = RequestMethod.GET)
	// public ModelAndView addEmployee(@RequestParam String email){
	//
	// EmployeeService employeeService = EmployeeServiceImpl.getInstance();
	//
	// return new ModelAndView("employee/editProfile", "employee",
	// employeeService.getEmployeeByEmail(email));
	// }
	//
	// @RequestMapping(value = "/editProfile", method = RequestMethod.POST)
	// public ModelAndView addEmployee(@RequestParam("employeeCode") String
	// employeeCode, @RequestParam("firstName") String firstName,
	// @RequestParam("middleName") String middleName,
	// @RequestParam("lastName") String lastName, @RequestParam("email") String
	// email, @RequestParam("dob") String dob,
	// @RequestParam("gender") char gender, @RequestParam("primaryContact")
	// String primaryContact, @RequestParam("secondaryContact") String
	// secondaryContact,
	// @RequestParam("skypeId") String skypeId, @RequestParam("skills") String[]
	// skills,@RequestParam("oldPassword") String oldPassword,
	// @RequestParam("password") String password,
	// @RequestParam("confirmPassword") String confirmPassword,
	// @RequestParam("enabled") boolean enabled) throws ParseException{
	//
	// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	// Date dateOfBirth = format.parse(dob);
	//
	// Employee employee = new Employee();
	// employee.setEmployeeCode(employeeCode);
	// employee.setFirstName(firstName);
	// employee.setMiddleName(middleName);
	// employee.setLastName(lastName);
	// employee.setEmail(email);
	// employee.setDob(dateOfBirth);
	// employee.setGender(gender);
	// employee.setPrimaryContact(primaryContact);
	// employee.setSecondaryContact(secondaryContact);
	// employee.setSkypeId(skypeId);
	// employee.setEnabled(enabled);
	//
	// if(!"".equals(password) && password.equals(confirmPassword))
	// employee.setPassword(password);
	// else
	// employee.setPassword(oldPassword);
	//
	// EmployeeService employeeService = EmployeeServiceImpl.getInstance();
	// employeeService.addSkills(skills, employeeCode);
	// employeeService.updateEmployee(employee);
	//
	// return new ModelAndView("employee/dashboard", "email", email);
	// }
	//
	// @RequestMapping(value = "/searchEmployee", method = RequestMethod.GET)
	// public ModelAndView searchEmployee(){
	//
	// return new ModelAndView("employee/searchEmployee");
	// }
	//
	// @RequestMapping(value = "/searchEmployee", method = RequestMethod.POST)
	// public ModelAndView searchEmployee(@RequestParam("criteria") String
	// criteria, @RequestParam("keyword") String keyword){
	//
	// EmployeeService employeeService = EmployeeServiceImpl.getInstance();
	// List<Employee> searchResult = employeeService.searchEmployee(criteria,
	// keyword);
	//
	// return new ModelAndView("employee/searchResults", "result",
	// searchResult);
	// }
	//
	// @RequestMapping(value = "/viewEmployee", method = RequestMethod.GET)
	// public ModelAndView viewEmployee(@RequestParam String employeeCode){
	//
	// EmployeeService employeeService = EmployeeServiceImpl.getInstance();
	//
	// return new ModelAndView("viewEmployee", "employee",
	// employeeService.getEmployeeByCode(employeeCode));
	// }

}
