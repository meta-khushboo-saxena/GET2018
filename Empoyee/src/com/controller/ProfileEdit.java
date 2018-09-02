package com.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facade.UserFacade;
import com.model.UserDetail;

/**
 * Servlet implementation class Profile
 */
@SuppressWarnings("serial")
public class ProfileEdit extends HttpServlet {

	private UserFacade userFacade = UserFacade.getInstance();
	private UserDetail userDetail = new UserDetail();

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session1 = request.getSession(false);
		if (session1 == null) {
			RequestDispatcher requestdispatch = request.getRequestDispatcher("/login.html");
			requestdispatch.include(request, response);
		} else {

			if (request.getParameter("emailid") == "") {
				userDetail = userFacade.getUserDetailByEmail((String) session1.getAttribute("Email"));
			} else {
				userDetail = userFacade.getUserDetailByEmail(request.getParameter("emailid"));
			}
			System.out.println(userDetail.getImage());
			request.setAttribute("UserDetail", userDetail);

			RequestDispatcher view = request.getRequestDispatcher("/profile.jsp");
			view.forward(request, response);
		}
	}
}
