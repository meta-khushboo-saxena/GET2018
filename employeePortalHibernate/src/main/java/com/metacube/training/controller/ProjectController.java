package com.metacube.training.controller;

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

import com.metacube.training.model.ProjectMaster;
import com.metacube.training.serviceInterface.ProjectServiceInterface;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	ProjectServiceInterface projectService;
	
	/**
	 * Function to redirect to add project page
	 * 
	 * @param model
	 * @return link to add project page
	 */
	@RequestMapping(value = "/addProjects", method = RequestMethod.GET)
	public String addProject(Model model) {
		model.addAttribute("project", new ProjectMaster());
		return "project/addProjects";
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
			@Valid @ModelAttribute("project") ProjectMaster projectMaster,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "project/addProjects";
		}

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
		return "project/showProject";
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
		return "/project/addProjects";
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
		return "redirect:/project/showProject";
	}

}
