package com.metacube.training.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
/**
 * Common controller class
 */
public class WelcomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		return "welcome";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(
			@RequestParam(value = "error", required = false) String error,
			Model model) {
		if (error == null) {
			return "login";
		}
		if (error.equals("true")) {
			model.addAttribute("error", "error");
		}
		return "login";
	}

	@RequestMapping(value = "/default", method = RequestMethod.GET)
	public String afterLogin(HttpServletRequest request) {
		if (request.isUserInRole("ROLE_ADMIN")) {
			return "redirect:/admin/dashboard";
		}
		return "redirect:/employee/dashboard";
	}
}
