package com.metacube.training.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.metacube.training.facade.UserFacade;
import com.metacube.training.enums.Status;
import com.metacube.training.model.UserDetail;

/**
 * Class to perform various operations of admin
 */
@Controller
@SessionAttributes("email")
@RequestMapping("/employee")
public class EmployeeController {

	private UserDetail userDetail = new UserDetail();
	@Autowired
	private HttpSession session;

	@Autowired
	private UserFacade userFacade;

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

		System.out.println(email);
		if (email != "" && password != "") {
			userDetail.setEmail(email);
			userDetail.setPassword(password);

			Status status = userFacade.checkUserDetail(userDetail);
			if (Status.DUPLICATE.equals(status)) {
				session.setAttribute("email", email);
				return "employee/profile";
			} else {
				model.addAttribute("error1", "error");
				return "employee/login";
			}
		} else {
			model.addAttribute("error2", "error");
			return "employee/login";
		}
	}

	/**
	 * Function to redirect to dashboard
	 * 
	 * @return string
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUp() {
		return "employee/signup";
	}

	/**
	 * Function to redirect to dashboard
	 * 
	 * @return string
	 */
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(Model model) {
		model.addAttribute("employee", userFacade
				.getUserDetailByEmail((String) session.getAttribute("email")));
		return "employee/profile";
	}
}
// package com.controller;
//
// import java.io.IOException;
//
// import javax.servlet.RequestDispatcher;
// import javax.servlet.ServletException;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import javax.servlet.http.HttpSession;
//
// import org.springframework.stereotype.Controller;
//
// /**
// * Servlet implementation class Login
// */
// @Controller
// @SuppressWarnings("serial")
// public class Login extends HttpServlet {
//
// /**
// * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
// * response)
// */
// protected void doPost(HttpServletRequest request, HttpServletResponse
// response) throws ServletException, IOException {
//
// HttpSession session = request.getSession();
// session.setAttribute("Email", request.getParameter("email"));
//
// RequestDispatcher requestdispatch =
// request.getRequestDispatcher("/ProfileEdit?emailid=");
// requestdispatch.include(request, response);
// }
//
// }
