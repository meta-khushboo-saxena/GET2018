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

import com.metacube.training.model.SkillsMaster;
import com.metacube.training.serviceInterface.SkillServiceInterface;

@Controller
@RequestMapping("/skill")
public class SkillController {

	@Autowired
	SkillServiceInterface skillService;

	/**
	 * Function to redirect to add skills page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addSkills", method = RequestMethod.GET)
	public String addSkill(Model model) {
		model.addAttribute("skills", new SkillsMaster());
		return "skill/skills";
	}

	/**
	 * Function to add new skill
	 * 
	 * @param skillsMaster
	 * @return
	 */
	@RequestMapping(value = "/addSkills", method = RequestMethod.POST)
	public ModelAndView addSkill(
			@Valid @ModelAttribute("skills") SkillsMaster skillsMaster,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("skill/skills");
		}
		System.out.println(skillService.create(skillsMaster));
		return new ModelAndView("admin/dashboard");
	}

}
