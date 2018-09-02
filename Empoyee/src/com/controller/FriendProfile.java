package com.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facade.UserFacade;
import com.model.UserDetail;

/**
 * Servlet implementation class FriendProfile
 */
@SuppressWarnings("serial")
public class FriendProfile extends HttpServlet {
	private UserFacade userFacade = UserFacade.getInstance();
	private UserDetail userDetail = new UserDetail();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		userDetail = userFacade.getUserDetailByEmail(email);
		request.setAttribute("UserDetail", userDetail);

		RequestDispatcher view = request.getRequestDispatcher("/profile.jsp");
		view.forward(request, response);
	}

}
