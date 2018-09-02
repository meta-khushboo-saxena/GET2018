package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enums.Status;
import com.facade.UserFacade;
import com.model.UserDetail;

/**
 * Servlet implementation class Profile
 */
@SuppressWarnings("serial")
public class ProfileUpdate extends HttpServlet {

	private UserFacade userFacade = UserFacade.getInstance();
	private UserDetail userDetail = new UserDetail();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		userDetail.setFirstName(request.getParameter("first_name"));
		userDetail.setLastName(request.getParameter("last_name"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String parameter = request.getParameter("dob");

		try {
			userDetail.setDateOfBirth(new java.sql.Date(sdf.parse(parameter).getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		userDetail.setEmail(request.getParameter("email"));
		userDetail.setAge(Integer.parseInt(request.getParameter("age")));
		userDetail.setContact(request.getParameter("contact"));
		userDetail.setOrganization(request.getParameter("organisation"));

		Status status = userFacade.updateUserDetail(userDetail);

		if (Status.UPDATED.equals(status)) {
			RequestDispatcher requestdispatch = request.getRequestDispatcher("/ProfileEdit?emailid=");
			requestdispatch.include(request, response);
		} else {
			out.println(status);
		}

	}
}
