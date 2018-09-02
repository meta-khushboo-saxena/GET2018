package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enums.Status;
import com.facade.UserFacade;
import com.model.UserDetail;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ProfileImage
 */
@SuppressWarnings("serial")
public class ProfileImage extends HttpServlet {
	private UserFacade userFacade = UserFacade.getInstance();
	private UserDetail userDetail = new UserDetail();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session1 = request.getSession();

		MultipartRequest multipartRequest = new MultipartRequest(request, "D:\\project\\Empoyee\\WebContent\\images");
		Enumeration files = multipartRequest.getFileNames();
		String fileName = null;
		while (files.hasMoreElements()) {
			String name = (String) files.nextElement();
			fileName = multipartRequest.getFilesystemName(name);
		}

		userDetail.setImage(fileName);
		userDetail.setEmail((String) session1.getAttribute("Email"));
		Status status = userFacade.updateImage(userDetail);

		if (Status.UPDATED.equals(status)) {
			RequestDispatcher requestdispatch = request.getRequestDispatcher("/ProfileEdit?emailid=");
			requestdispatch.include(request, response);
		} else {
			out.println(status);
		}
	}
}
