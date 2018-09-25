package com.metacube.training.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.JobTitle;
import com.metacube.training.serviceInterface.JobTitleServiceInterface;

@Controller
@RequestMapping("/jobTitle")
public class JobTitleController {

	@Autowired
	JobTitleServiceInterface jobTitleService;

	/**
	 * Function to redirect to job title page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/jobTitle", method = RequestMethod.GET)
	public String addJobTitle(Model model) {
		model.addAttribute("jobTitle1", new JobTitle());
		return "admin/jobTitle";
	}

	/**
	 * Function to add new job title
	 * 
	 * @param jobTitle
	 * @return
	 */
	@RequestMapping(value = "/jobTitle", method = RequestMethod.POST)
	public ModelAndView addJobTitle(
			@Valid @ModelAttribute("jobTitle1") JobTitle jobTitle,
			BindingResult bindingResult) {
		jobTitleService.create(jobTitle);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("admin/jobTitle");
		}
		return new ModelAndView("admin/dashboard");
	}

}
