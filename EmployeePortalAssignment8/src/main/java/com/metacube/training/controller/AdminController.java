package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.metacube.training.model.Employee;
import com.metacube.training.model.ProjectMaster;
import com.metacube.training.service.EmployeeServiceImplement;
import com.metacube.training.service.ServiceInterface;

/**
 * Class to perform various operations of admin
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	ServiceInterface<Employee> employeeService;

	@Autowired
	ServiceInterface<ProjectMaster> projectService;

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
	 * Function to redirect to Add Employee page
	 * 
	 * @param model
	 * @return string
	 */
	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public String adminAddEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "admin/addEmployee";
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
			@ModelAttribute("employee") Employee employee, Model model) {
		Boolean status = false;
		if (employee != null && employee.getCode() == 0) {
			status = employeeService.create(employee);
		} else {
			status = employeeService.updateInfo(employee);
		}
		if (status) {
			return "redirect:showEmployee";
		}
		model.addAttribute("error", "error");
		return "admin/addEmployee";
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
		return "admin/addEmployee";
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
		return "redirect:/admin/showEmployee";
	}

	/**
	 * Function to redirect to add project page
	 * 
	 * @param model
	 * @return link to add project page
	 */
	@RequestMapping(value = "/addProjects", method = RequestMethod.GET)
	public String addProject(Model model) {
		model.addAttribute("project", new ProjectMaster());
		return "admin/addProjects";
	}

	/**
	 * Function to add new project
	 * 
	 * @param projectMaster
	 * @return
	 */
	@RequestMapping(value = "/addProjects", method = RequestMethod.POST)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	public String addProject(
			@ModelAttribute("project") ProjectMaster projectMaster) {

		if (projectMaster != null && projectMaster.getProjectId() == 0) {
			projectService.create(projectMaster);
		} else {
			projectService.updateInfo(projectMaster);
		}
		return "admin/dashboard";
	}

	/**
	 * Function to redirect to show project page
	 * 
	 * @param model
	 * @return link to show project page
	 */
	@RequestMapping(path = "/showProject", method = RequestMethod.GET)
	public String showProjects(Model model) {
		model.addAttribute("projects", projectService.getAllInfo());
		return "admin/showProject";
	}

	/**
	 * Function to edit the project
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(path = "/editProject", method = RequestMethod.GET)
	public String editProject(Model model, @RequestParam("id") int id) {
		model.addAttribute("project", projectService.getInfoById(id));
		return "/admin/addProjects";
	}

	/**
	 * Function to delete the project
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(path = "/deleteProject", method = RequestMethod.GET)
	public String deleteProject(@RequestParam("id") int id) {
		projectService.deleteInfo(id);
		return "redirect:/admin/showProject";
	}

	/**
	 * Function to move to search employee page
	 * 
	 * @return
	 */
	@RequestMapping(value = "/searchEmployee", method = RequestMethod.GET)
	public String searchEmployee(@RequestParam("role") int role, Model model) {
		model.addAttribute("role", role);
		return "admin/searchEmployee";
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
	 * Function to logout the user
	 * 
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "admin/login";
	}
}