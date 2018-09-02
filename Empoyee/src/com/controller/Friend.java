package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facade.UserFacade;
import com.model.UserDetail;

/**
 * Servlet implementation class Friend
 */
@SuppressWarnings("serial")
public class Friend extends HttpServlet {

	private UserFacade userFacade = UserFacade.getInstance();
	private List<UserDetail> userList = new ArrayList<UserDetail>();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session1 = request.getSession(false);
		if (session1 == null) {
			RequestDispatcher requestdispatch = request.getRequestDispatcher("/login.html");
			requestdispatch.include(request, response);
		} else {
			userList = userFacade.getFriendListByEmail((String) session1.getAttribute("Email"));

			request.setAttribute("UserList", userList);

			RequestDispatcher view = request.getRequestDispatcher("/friend.jsp");
			view.forward(request, response);
		}
	}
}
